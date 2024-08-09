package com.project.splitwise.Commands;

import com.project.splitwise.controller.GroupController;
import com.project.splitwise.dtos.CreateGroupRequest;
import com.project.splitwise.models.Group;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CreateGroupCommand implements Command{
    @Autowired
    private GroupController groupController;
    @Override
    public boolean matches(String input) {
        return getCommand(input).equals("Group");
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing create group commands");
        List<String> tokens=getTokens(input);
        List<Long> memberIds= Arrays.stream(tokens.get(3).split(",")).map(Long::valueOf)
                .collect(Collectors.toList());
        CreateGroupRequest request=CreateGroupRequest.builder()
                .name(tokens.get(1))
                .membersIds(memberIds)
                .createdBy(Long.valueOf(tokens.get(2)))
                .build();
        Group group= groupController.createGroup(request);
        System.out.println("Created group with id: " + group.getId());
    }
}
