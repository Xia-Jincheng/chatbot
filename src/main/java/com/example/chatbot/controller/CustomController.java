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
        return "forward:/customs_page/1";
    }

    @GetMapping("/customs_page/{page_num}")
    public String getAPage(@PathVariable("page_num")Integer page_num, Model model){
        List<User> users = userService.getAPageCustom(page_num);
        model.addAttribute("users", users);
        model.addAttribute("page_num", page_num);
        model.addAttribute("max_page_num", userService.getCustomNum());
        return "manage/customs";
    }

    @GetMapping("/custom_alter/{id}")
    public String toAlterCustom(@PathVariable("id") Integer id, Model model){
        User user = userService.getUser(id).orElse(null);
        model.addAttribute("user", user);
        return "manage/altercustom";
    }
}
