package com.project.splitwise.dtos;

import com.project.splitwise.models.ExpenseType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserExperienceRequest {
    private Long expenseId;
    private Long userId;
    private Double amount;
    private ExpenseType type;
}
