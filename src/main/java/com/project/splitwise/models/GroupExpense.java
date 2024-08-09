package com.project.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupExpense extends BaseModel{
    @ManyToOne
    private Group group;
    @OneToOne
    private Expense expense;
}
