package com.project.splitwise.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class CreateExpenseRequest {
    private String description;
    private double amount;
    private List<Long> usersId=new ArrayList<>();
}
