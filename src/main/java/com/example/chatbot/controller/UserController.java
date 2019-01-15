package com.example.chatbot.controller;

import com.example.chatbot.entity.User;
import com.example.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String toListUsers(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "manage/users";
    }

    @GetMapping("/user_alter/{id}")
    public String toUserAlter(@PathVariable("id") Integer id, Model model){
        User user = userService.getUser(id).orElse(null);
        model.addAttribute("user", user);
        return "manage/alteruser";
    }

    @PutMapping("/user")
    public String userAlter(User user){
        userService.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user_delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
