package com.project.splitwise.service;

import com.project.splitwise.models.GroupExpense;
import com.project.splitwise.repository.GroupExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupExpenseService {
    private GroupExpenseRepository groupExpenseRepository;
    public GroupExpense createGroupExpense(GroupExpense groupExpense) {
        return groupExpenseRepository.save(groupExpense);
    }
}
