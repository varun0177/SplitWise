package com.project.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "users")
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
}
