package com.example.chatbot.service;

import com.example.chatbot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void addUser(User user);
    public List<User> getAllUser();
    public void deleteUser(Integer id);
    public Optional<User> getUser(Integer id);
    public void modifyUser(User user);
}
