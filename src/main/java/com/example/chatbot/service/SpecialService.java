package com.example.chatbot.service;

import com.example.chatbot.entity.SpecialRecord;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface SpecialService {
    List<SpecialRecord> getAll();
    void deleteByID(Integer id);
    SpecialRecord getByID(Integer id);
    void add(SpecialRecord specialRecord);

    @Modifying
    void modify(SpecialRecord specialRecord);

    List<SpecialRecord> getAPageSpecial(Integer page_num);

    Integer getSpecialNum();
}
