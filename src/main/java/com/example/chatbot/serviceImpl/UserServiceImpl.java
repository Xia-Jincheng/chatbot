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
    public List<User> findUsersByInput(String input){
        return userRepository.findUsersByInput(input);
    }

    @Override
    public List<User> getAllAdmin() {
        return userRepository.getAllAdmin();
    }

    @Override
    public List<User> getAllCustom() {
        return userRepository.getAllCustom();
    }

    @Override
    public List<User> getAPageUser(Integer page_num){
        return userRepository.getAPageUser((page_num - 1) * 11);
    }

    @Override
    public Integer getUserNum(){
        return (int)Math.ceil(userRepository.getUserNum() / 11.0);
    }

    @Override
    public List<User> getAPageCustom(Integer page_num){
        return userRepository.getAPageCustom((page_num - 1) * 11);
    }

    @Override
    public Integer getCustomNum(){
        return (int)Math.ceil(userRepository.getCustomNum() / 11.0);
    }

    @Override
    public List<User> getAPageAdmin(Integer page_num) {
        return userRepository.getAPageAdmin((page_num-1) * 11);
    }

    @Override
    public Integer getAdminNum() {
        return (int)Math.ceil(userRepository.getAdminNum() / 11.0);
    }
}
