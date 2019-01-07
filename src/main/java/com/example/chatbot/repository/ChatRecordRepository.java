package com.example.chatbot.repository;

import com.example.chatbot.entity.ChatRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRecordRepository extends JpaRepository<ChatRecord,Integer> {
}
