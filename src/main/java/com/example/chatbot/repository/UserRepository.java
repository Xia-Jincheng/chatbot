package com.example.chatbot.repository;

import com.example.chatbot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from user where user.name=?1", nativeQuery = true)
    User findUserByName(String name);

    @Query(value = "select * from user where user.status=1", nativeQuery = true)
    List<User> getAllUser();

    @Query(value = "select * from user where user.status=0", nativeQuery = true)
    List<User> getAllAdmin();

    @Query(value = "select * from user where user.status=2", nativeQuery = true)
    List<User> getAllCustom();
}
