package com.example.chatbot.controller;

import com.example.chatbot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRecordController {
    @Autowired
    RecordService recordService;

    @GetMapping("/record_delete1/{id}")
    public String deleteRecord(@PathVariable("id") Integer id){
        recordService.deleteRecord(id);
        return "成功删除用户该条聊天记录！";
    }
}
