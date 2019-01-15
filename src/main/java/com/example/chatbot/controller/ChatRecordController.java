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
        List<ChatRecord> records = recordService.getAllRecords();
        model.addAttribute("records", records);
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
        return "manage/chatrecords";
    }
}
