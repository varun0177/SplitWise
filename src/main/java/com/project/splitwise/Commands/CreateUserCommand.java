package com.project.splitwise.Commands;

import com.project.splitwise.controller.UserController;
import com.project.splitwise.dtos.UserRequestDto;
import com.project.splitwise.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateUserCommand implements Command{
    @Autowired
    private UserController userController;
    @Override
    public boolean matches(String input) {
        return
                getCommand(input).equals(Commands.REGISTER_USER_COMMAND);
    }

    @Override
    public void execute(String input) {
        List<String> tokens=getTokens(input);
        UserRequestDto user=UserRequestDto.builder()
                .name(tokens.get(1))
                .email(tokens.get(2))
                .password(tokens.get(3))
                .phoneNumber(tokens.get(4))
                .build();
       User user1= userController.createUser(user);
    }
}
