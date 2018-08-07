package com.example.springboot.service;

public interface UserService {
    void create(String name, Integer age);

    void deleteByName(String name);

    Integer getAllUsers();

    void deleteAllUsers();
}

