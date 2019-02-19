package com.example.chatbot.service;

import com.example.chatbot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    List<User> getAllUser();
    void deleteUser(Integer id);
    Optional<User> getUser(Integer id);
    void save(User user);
    User findUserByName(String name);

    List<User> findUsersByInput(String input);

    List<User> getAllAdmin();

    List<User> getAllCustom();

    List<User> getAPage(Integer page_num);
}
