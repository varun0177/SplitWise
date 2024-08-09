package com.project.splitwise.controller;

import com.project.splitwise.dtos.UserRequestDto;
import com.project.splitwise.models.User;
import com.project.splitwise.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;
    public User createUser(UserRequestDto request){
        return userService.createUser(request.toUser());
    }
}
