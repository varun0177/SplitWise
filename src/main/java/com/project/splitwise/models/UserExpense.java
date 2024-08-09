package com.project.splitwise.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;
    private Double amount;
    @ManyToOne
    @JoinColumn(name="expense_id")
    private Expense expense;
    @Enumerated
    private ExpenseType type;
}
