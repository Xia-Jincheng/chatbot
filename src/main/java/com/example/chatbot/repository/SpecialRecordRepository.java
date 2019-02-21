package com.example.chatbot.repository;

import com.example.chatbot.entity.SpecialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecialRecordRepository extends JpaRepository<SpecialRecord,Integer> {

    @Query(value = "select * from special_record limit ?1,11", nativeQuery = true)
    List<SpecialRecord> getAPageSpecial(Integer start);

    @Query(value = "select count(*) from special_record", nativeQuery = true)
    Integer getSpecialNum();
}
