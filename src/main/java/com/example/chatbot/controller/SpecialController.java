package com.example.chatbot.controller;

import com.example.chatbot.entity.SpecialRecord;
import com.example.chatbot.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SpecialController {
    @Autowired
    SpecialService specialService;

    @GetMapping("/special")
    public String toSpecial(Model model){
        List<SpecialRecord> specials = specialService.getAll();
        model.addAttribute("specials", specials);
        return "manage/special";
    }

    @GetMapping("/special_delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        specialService.deleteByID(id);
        return "redirect:/special";
    }

    @GetMapping("/special_alter/{id}")
    public String toAlter(@PathVariable("id") Integer id, Model model){
        SpecialRecord specialRecord = specialService.getByID(id);
        model.addAttribute("special", specialRecord);
        return "manage/alterspecial";
    }

    @GetMapping("/special_add")
    public String toAdd(){
        return "manage/alterspecial";
    }
}
