package com.example.chatbot.controller;

import com.example.chatbot.entity.User;
import com.example.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping("/admin/user_add")
    public String toSignup(){
        return "signup";
    }

    @PostMapping("/admin/user_add")
    public String signUp(User user, Model model){
        if (userService.findUserByName(user.getName()) != null){
            model.addAttribute("user", user);
            model.addAttribute("msg", "用户名已存在，请重新输入！");
            return "signup";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/admins")
    public String toListAdmins(Model model){
        List<User> users = userService.getAllAdmin();
        model.addAttribute("users", users);
        return "manage/admins";
    }

    @GetMapping("/traffic")
    public String showTrafic(){
        return "manage/traffic";
    }
}
