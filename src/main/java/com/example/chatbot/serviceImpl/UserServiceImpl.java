package com.example.chatbot.serviceImpl;

import com.example.chatbot.entity.User;
import com.example.chatbot.repository.UserRepository;
import com.example.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user){
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser(){
        return userRepository.getAllUser();
    }

    @Override
    public Optional<User> getUser(Integer id){
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    @Override
    @Modifying
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public List<User> getAllAdmin() {
        return userRepository.getAllAdmin();
    }

    @Override
    public List<User> getAllCustom() {
        return userRepository.getAllCustom();
    }

}
