package com.example.chatbot.controller;

import com.example.chatbot.entity.User;
import com.example.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        if(user.getStatus() == 0)
            return "redirect:/admins";
        if(user.getStatus() == 1)
            return "redirect:/users";
        return "redirect:/customs";
    }

    @GetMapping("/admins")
    public String toListAdmins(){
        return "forward:/admins_page/1";
    }

    @GetMapping("/admins_page/{page_num}")
    public String getAPage(@PathVariable("page_num")Integer page_num, Model model){
        List<User> users = userService.getAPageAdmin(page_num);
        model.addAttribute("users", users);
        model.addAttribute("page_num", page_num);
        model.addAttribute("max_page_num", userService.getAdminNum());
        return "manage/admins";
    }

    @GetMapping("/traffic")
    public String showTrafic(){
        return "manage/traffic";
    }

    @GetMapping("/products")
    public String toProduct(){
        return "manage/products";
    }
}
