package com.project.splitwise.dtos;

import com.project.splitwise.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UserRequestDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    public User toUser() {
        return User.builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .password(password)
                .build();
    }
}
