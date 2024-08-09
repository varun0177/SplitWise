package com.project.splitwise.strategy;

import org.springframework.data.util.Pair;
import com.project.splitwise.dtos.SettleUpTransaction;
import com.project.splitwise.models.Expense;
import com.project.splitwise.models.User;
import com.project.splitwise.models.UserExpense;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.*;
@Component
public class GreedySettlementStrategy implements SettlementStrategy{
    public Map<Long,Double> prepareInitialState(List<Expense> expenses){
        Map<Long,Double> result=new HashMap<>();
        for(Expense expense :expenses){
            for(UserExpense userExpense:expense.getOwedBy()){
                User user=userExpense.getUser();
                if(!result.containsKey(user.getId())){
                    result.put(user.getId(),0.0);
                }
                result.put(user.getId(),result.get(user.getId())+ userExpense.getAmount());
            }
            for(UserExpense userExpense1: expense.getPaidBy()){
                User user=userExpense1.getUser();
                if(!result.containsKey(user.getId())){
                    result.put(user.getId(),0.0);
                }
                result.put(user.getId(),result.get(user.getId())- userExpense1.getAmount());
            }
        }
        return result;
    }
    @Override
    public List<SettleUpTransaction> settleUpExpenses(List<Expense> expenses) {
        Map<Long,Double> initialState=prepareInitialState(expenses);
        TreeSet<Pair<Long, Double>> expenseTree = new TreeSet<>((left, right) -> (int) (left.getSecond() - right.getSecond()));
        for (Map.Entry<Long, Double> entry : initialState.entrySet()) {
            expenseTree.add(Pair.of(entry.getKey(), entry.getValue()));
        }
        List<SettleUpTransaction> transactions = new ArrayList<>();
        while (expenseTree.size() >1){
            Pair<Long,Double> smallestPair=expenseTree.first();
            Pair<Long,Double> largestPair=expenseTree.last();
            SettleUpTransaction transaction=SettleUpTransaction.builder()
                    .from(largestPair.getFirst())
                    .to(smallestPair.getFirst())
                    .amount(largestPair.getSecond())
                    .build();
            expenseTree.remove(largestPair);
            expenseTree.remove(smallestPair);
            expenseTree.add(Pair.of(smallestPair.getFirst(), smallestPair.getSecond() + largestPair.getSecond()));
            transactions.add(transaction);

        }

        return transactions;
    }
}
