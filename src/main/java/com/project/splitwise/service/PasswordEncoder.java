package com.project.splitwise.service;

public interface PasswordEncoder {
    String encode(String password);
    boolean matches(String plainText,String hashed);
}
