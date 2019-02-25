package com.example.chatbot.service;

import com.example.chatbot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    List<User> getAllUser();

    Integer getCount();

    void deleteUser(Integer id);
    Optional<User> getUser(Integer id);
    void save(User user);
    User findUserByName(String name);

    List<User> findUsersByInput(String input);

    List<User> getAllAdmin();

    List<User> getAllCustom();

    List<User> getAPageUser(Integer page_num);

    Integer getUserNum();

    List<User> getAPageCustom(Integer page_num);

    Integer getCustomNum();

    List<User> getAPageAdmin(Integer page_num);

    Integer getAdminNum();

    Integer getUserCount();

    Integer getAdminCount();

    Integer getCustomCount();
}
