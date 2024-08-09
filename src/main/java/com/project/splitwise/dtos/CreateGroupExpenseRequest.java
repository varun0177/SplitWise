package com.project.splitwise.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
public class CreateGroupExpenseRequest {
    private String description;
    private double amount;
    private Long groupID;
    private List<Long> users=new ArrayList<>();
}
