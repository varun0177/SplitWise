package com.project.splitwise.service;

import com.project.splitwise.models.UserExpense;
import com.project.splitwise.repository.UserExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserExpenseService {
    private UserExpenseRepository userExpenseRepository;
    public UserExpense createUserExpense(UserExpense userExpense) {
        return  userExpenseRepository.save(userExpense);
    }
}
