package com.example.chatbot.service;

import com.example.chatbot.entity.ChatRecord;

import java.util.List;

public interface RecordService {
    void addRecord(ChatRecord chatRecord);
    List<ChatRecord> getAllRecords();
    ChatRecord findRecordById(Integer id);
    void deleteRecord(Integer id);
    void updateRecord(ChatRecord chatRecord);
    List<ChatRecord> getUnhandle();
}
