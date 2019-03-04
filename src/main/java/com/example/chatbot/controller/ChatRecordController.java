package com.example.chatbot.controller;

import com.example.chatbot.entity.ChatRecord;
import com.example.chatbot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ChatRecordController {
    @Autowired
    RecordService recordService;

    @GetMapping("/chatrecords")
    public String toListRecods(Model model){
        return "forward:records_page/1";
    }


    @GetMapping("/records_page/{page_num}")
    public String getAPage(@PathVariable("page_num") Integer page_num, Model model){
        List<ChatRecord> records = recordService.getAPageRecord(page_num);
        model.addAttribute("records", records);
        model.addAttribute("page_num", page_num);
        Integer max = recordService.getRecordNum();
        model.addAttribute("max_page_num", max);
        return "manage/chatrecords";
    }

    @GetMapping("/record_delete/{id}")
    public String deleteRecord(@PathVariable("id") Integer id){
        recordService.deleteRecord(id);
        return "redirect:/chatrecords";
    }

    @GetMapping("/record_unhandle")
    public String toUnhandle(Model model){
        List<ChatRecord> records = recordService.getUnhandle();
        model.addAttribute("records", records);
        model.addAttribute("page_num",1);
        model.addAttribute("max_page_num", (int)Math.ceil(records.size()/11.0));
        return "manage/chatrecords";
    }
}
