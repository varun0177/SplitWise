package com.project.splitwise.service;

import com.project.splitwise.dtos.CreateExpenseRequest;
import com.project.splitwise.dtos.CreateGroupExpenseRequest;
import com.project.splitwise.dtos.CreateUserExperienceRequest;
import com.project.splitwise.models.*;
import com.project.splitwise.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {
    private ExpenseRepository expenseRepository;
    private UserService userService;
    private UserExpenseService userExpenseService;
    private GroupService groupService;
    private GroupExpenseService groupExpenseService;

    public Expense createExpense(CreateExpenseRequest request) {
        List<User> users=userService.getUsers(request.getUsersId());
        Expense expense=Expense.builder()
                .description(request.getDescription())
                .amount(request.getAmount())
                .expenseStatus(ExpenseStatus.PENDING)
                .users(users)
                .build();
        return expenseRepository.save(expense);
    }


    public UserExpense addUserExpense(CreateUserExperienceRequest request) {
        Expense expense=expenseRepository.findById(request.getExpenseId()).orElse(null);
        User user=userService.getUser(request.getUserId());
        UserExpense userExpense=UserExpense.builder()
                .expense(expense)
                .user(user)
                .amount(request.getAmount())
                .type(request.getType())
                .build();
        return userExpenseService.createUserExpense(userExpense);
    }

    public GroupExpense createGroupExpense(CreateGroupExpenseRequest request) {
        Group group=groupService.getGroup(request.getGroupID());
        List<User> users=userService.getUsers(request.getUsers());
        Expense expense=Expense.builder()
                .users(users)
                .amount(request.getAmount())
                .description(request.getDescription())
                .expenseStatus(ExpenseStatus.PENDING)
                .build();
        expenseRepository.save(expense);
        GroupExpense groupExpense=GroupExpense
                .builder()
                .expense(expense)
                .group(group)
                .build();
        return  groupExpenseService.createGroupExpense(groupExpense);
    }
}
