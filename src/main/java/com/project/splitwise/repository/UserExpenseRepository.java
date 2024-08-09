package com.project.splitwise.repository;

import com.project.splitwise.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExpenseRepository extends JpaRepository<UserExpense,Long> {
}
