package com.example.chatbot.controller;

import com.example.chatbot.entity.User;
import com.example.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String toListUsers(){
        return "forward:/users_page/1";
    }

    @GetMapping("/users_page/{page_num}")
    public String getAPage(@PathVariable("page_num") Integer page_num, Model model){
        List<User> users = userService.getAPageUser(page_num);
        model.addAttribute("users", users);
        model.addAttribute("page_num", page_num);
        Integer max = userService.getUserNum();
        model.addAttribute("max_page_num", max);
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
        System.out.println(user.getName());
        System.out.println(user.getStatus());
        if(user.getStatus() == 0)
            return "redirect:/admins";
        if(user.getStatus() == 1)
            return "redirect:/users";
        return "redirect:/customs";
    }

    @DeleteMapping("/user_delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
