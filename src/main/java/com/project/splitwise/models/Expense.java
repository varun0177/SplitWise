package com.project.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense extends BaseModel{
    private String description;
    private Double amount;
    @ManyToMany
    private List<User> users=new ArrayList<>();
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> paidBy=new ArrayList<>();
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> owedBy=new ArrayList<>();
    @Enumerated
    private ExpenseStatus expenseStatus;

}
