package com.example.chatbot.service;

import com.example.chatbot.entity.SpecialRecord;

import java.util.List;

public interface SpecialService {
    List<SpecialRecord> getAll();
    void deleteByID(Integer id);
    SpecialRecord getByID(Integer id);
    void add(SpecialRecord specialRecord);
}
