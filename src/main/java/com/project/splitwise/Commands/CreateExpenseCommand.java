package com.project.splitwise.Commands;

import com.project.splitwise.controller.ExpenseController;
import com.project.splitwise.dtos.CreateExpenseRequest;
import com.project.splitwise.models.Expense;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateExpenseCommand implements Command{
    @Autowired
    private ExpenseController expenseController;
    @Override
    public boolean matches(String input) {
        String command=getCommand(input);
        return command.equals(Commands.ADD_EXPENCE);
    }

    @Override
    public void execute(String input) {
        List<String> tokens=getTokens(input);
        List<Long> userIDS= Arrays.stream(tokens.get(3).split(","))
                .map(Long::valueOf)
                .toList();
        CreateExpenseRequest expense= CreateExpenseRequest.builder()
                .description(tokens.get(1))
                .amount(Double.parseDouble(tokens.get(2)))
                .usersId(userIDS)
                .build();
        Expense expense1=expenseController.createExpense(expense);
        System.out.println("Created expense with id: " + expense1.getId());
    }
}
