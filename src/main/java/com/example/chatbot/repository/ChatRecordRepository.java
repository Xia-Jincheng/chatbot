package com.example.chatbot.repository;

import com.example.chatbot.entity.ChatRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRecordRepository extends JpaRepository<ChatRecord,Integer> {
    @Query(value = "select * from chat_record as record where record.is_reply=false", nativeQuery = true)
    List<ChatRecord> getUnhandle();
}
