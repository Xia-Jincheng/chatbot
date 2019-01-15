package com.example.chatbot.controller;

import com.example.chatbot.entity.User;
import com.example.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CustomController {
    @Autowired
    UserService userService;

    @GetMapping("/customs")
    public String toListCustoms(Model model){
        List<User> users = userService.getAllCustom();
        model.addAttribute("users", users);
        return "manage/customs";
    }

    @GetMapping("/custom_alter/{id}")
    public String toAlterCustom(@PathVariable("id") Integer id, Model model){
        User user = userService.getUser(id).orElse(null);
        model.addAttribute("user", user);
        return "manage/altercustom";
    }
}
