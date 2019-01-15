package com.example.chatbot.serviceImpl;

import com.example.chatbot.entity.ChatRecord;
import com.example.chatbot.repository.ChatRecordRepository;
import com.example.chatbot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    ChatRecordRepository recordRepository;

    @Override
    public void addRecord(ChatRecord chatRecord) {
        recordRepository.save(chatRecord);
    }

    @Override
    public List<ChatRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public ChatRecord findRecordById(Integer id) {
        return recordRepository.getOne(id);
    }

    @Override
    public void deleteRecord(Integer id) {
        recordRepository.deleteById(id);
    }

    @Override
    public void updateRecord(ChatRecord chatRecord) {
        recordRepository.save(chatRecord);
    }

    @Override
    public List<ChatRecord> getUnhandle() {
        return recordRepository.getUnhandle();
    }
}
