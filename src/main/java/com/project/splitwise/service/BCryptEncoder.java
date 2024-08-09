package com.project.splitwise.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptEncoder implements PasswordEncoder{
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean matches(String plainText, String hashed) {
            return encoder.matches(plainText,hashed);
    }
}
