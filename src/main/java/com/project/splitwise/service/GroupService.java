package com.project.splitwise.service;

import com.project.splitwise.dtos.CreateGroupRequest;
import com.project.splitwise.models.Group;
import com.project.splitwise.models.User;
import com.project.splitwise.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {
    private GroupRepository groupRepository;
    private UserService userService;
    public Group createGroup(CreateGroupRequest request) {
        User user=userService.getUser(request.getCreatedBy());
        List<User> users=userService.getUsers(request.getMembersIds());
        Group group= Group.builder()
                .name(request.getName())
                .createdBy(user)
                .members(users)
                .build();
        return groupRepository.save(group);
    }
    public Group getGroup(Long id){
        return groupRepository.findById(id).orElse(null);
    }
}
