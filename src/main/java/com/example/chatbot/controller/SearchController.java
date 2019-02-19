package com.example.chatbot.controller;

import com.example.chatbot.entity.User;
import com.example.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController     // 只返回字符串（json），不返回资源映射
public class SearchController {
    @Autowired
    UserService userService;

    @GetMapping("/search")
    public List<User> search(@RequestParam String input){
        List<User> users = new ArrayList<>(userService.findUsersByInput(input));
        return users;
    }
}
