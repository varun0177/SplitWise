package com.project.splitwise.controller;

import com.project.splitwise.dtos.CreateExpenseRequest;
import com.project.splitwise.dtos.CreateGroupExpenseRequest;
import com.project.splitwise.dtos.CreateUserExperienceRequest;
import com.project.splitwise.models.Expense;
import com.project.splitwise.models.GroupExpense;
import com.project.splitwise.models.UserExpense;
import com.project.splitwise.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ExpenseController {
    private ExpenseService expenseService;
    public Expense createExpense(CreateExpenseRequest request){
        return expenseService.createExpense(request);
    }
    public UserExpense addUserExpense(CreateUserExperienceRequest request){
        return expenseService.addUserExpense(request);
    }
    public GroupExpense createGroupExpense(CreateGroupExpenseRequest request){
        return expenseService.createGroupExpense(request);
    }
}
