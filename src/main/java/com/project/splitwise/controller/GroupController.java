package com.project.splitwise.controller;

import com.project.splitwise.dtos.CreateGroupRequest;
import com.project.splitwise.models.Group;
import com.project.splitwise.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class GroupController {
    private GroupService groupService;
    public Group createGroup(CreateGroupRequest request){
        return groupService.createGroup(request);
    }
}
