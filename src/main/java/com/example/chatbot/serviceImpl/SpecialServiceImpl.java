package com.example.chatbot.serviceImpl;

import com.example.chatbot.entity.SpecialRecord;
import com.example.chatbot.repository.SpecialRecordRepository;
import com.example.chatbot.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialServiceImpl implements SpecialService {
    @Autowired
    SpecialRecordRepository specialRepository;

    @Override
    public List<SpecialRecord> getAll() {
        return specialRepository.findAll();
    }

    @Override
    public void deleteByID(Integer id) {
        specialRepository.deleteById(id);
    }

    @Override
    public SpecialRecord getByID(Integer id) {
        return specialRepository.getOne(id);
    }

    @Override
    public void add(SpecialRecord specialRecord) {
        specialRepository.save(specialRecord);
    }

    @Override
    @Modifying
    public void modify(SpecialRecord specialRecord){
        specialRepository.save(specialRecord);
    }
}
