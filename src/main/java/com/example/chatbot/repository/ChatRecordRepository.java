package com.example.chatbot.repository;

import com.example.chatbot.entity.ChatRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ChatRecordRepository extends JpaRepository<ChatRecord,Integer> {
    @Query(value = "select * from chat_record as record where record.is_reply=false", nativeQuery = true)
    List<ChatRecord> getUnhandle();


    @Query(value = "select * from chat_record limit ?1,11", nativeQuery = true)
    List<ChatRecord> getAPageRecord(Integer start);

    @Query(value = "select count(*) from chat_record", nativeQuery = true)
    Integer getRecordNum();

    @Query(value = "select * from chat_record where user_id=?1", nativeQuery = true)
    List<ChatRecord> getUserRecords(Integer user_id);

    @Query(value = "select * from chat_record where user_id=?1 and is_reply=false", nativeQuery = true)
    List<ChatRecord> getRecordsUnhandled(Integer user_id);

    @Query(value = "update chat_record set answer=?2, is_reply=true where id=?1", nativeQuery = true)
    @Modifying
    @Transactional
    void addAnswer(Integer record_id, String answer);
}
