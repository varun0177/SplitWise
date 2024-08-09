package com.project.splitwise.strategy;

import com.project.splitwise.dtos.SettleUpTransaction;
import com.project.splitwise.models.Expense;

import java.util.List;

public interface SettlementStrategy {
    List<SettleUpTransaction> settleUpExpenses(List<Expense> expenses);
}
