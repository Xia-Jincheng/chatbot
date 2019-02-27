package com.example.chatbot.controller;

import com.example.chatbot.entity.SpecialRecord;
import com.example.chatbot.service.ProductService;
import com.example.chatbot.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SpecialController {
    @Autowired
    SpecialService specialService;
    @Autowired
    ProductService productService;

    @GetMapping("/special")
    public String toSpecial(Model model){
        return "forward:/special_page/1";
    }

    @GetMapping("/special_page/{page_num}")
    public String getAPage(@PathVariable("page_num") Integer page_num, Model model){
        List<SpecialRecord> specials = specialService.getAPageSpecial(page_num);
        model.addAttribute("specials", specials);
        model.addAttribute("page_num", page_num);
        Integer max = specialService.getSpecialNum();
        model.addAttribute("max_page_num", max);
        return "manage/special";
    }

    @PostMapping("/special")
    public String addSpecial(SpecialRecord specialRecord){
        specialService.add(specialRecord);
        return "redirect:/special";
    }

    @PutMapping("/special")
    public String modifySpecial(SpecialRecord specialRecord){
        specialService.modify(specialRecord);
        return "redirect:/special";
    }

    @DeleteMapping("/special_delete/{id}")
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
