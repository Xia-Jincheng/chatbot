package com.example.chatbot.controller;

import com.example.chatbot.entity.User;
import com.example.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/main")
    public String toMain(){
        return "manage/main";
    }

    @GetMapping("/")
    public String tologin(){
        return "login";
    }

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        Map<String, Object> map, HttpSession session){
        User user = userService.findUserByName(username);
        if(user == null){
            map.put("msg", "用户不存在，请先注册！");
            return "login";
        }
        if(!user.getPassword().equals(password)){
            map.put("msg", "密码错误，请重新输入！");
            return "login";
        }
        session.setAttribute("loginUser", username);
        return "redirect:/summary";
    }

    @GetMapping("/signout")
    public String signOut(HttpSession session){
        session.removeAttribute("loginUser");
        return "/login";
    }
}
