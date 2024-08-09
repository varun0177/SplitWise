package com.project.splitwise.service;

import com.project.splitwise.models.User;
import com.project.splitwise.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private BCryptEncoder bCryptEncoder;

    public User createUser(User user) {
        String password= bCryptEncoder.encode(user.getPassword());
        User user1=user.toBuilder().password(password).build();
        return userRepository.save(user1);
    }
    public User getUser(Long id){

        return userRepository.findById(id).orElse(null);
    }
    public List<User> getUsers(List<Long> ids){
        return userRepository.findAllById(ids);
    }

}
