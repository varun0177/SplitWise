package com.project.splitwise.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder()
public class CreateGroupRequest {
    private String name;
    private List<Long> membersIds=new ArrayList<>();
    private Long createdBy;


}
