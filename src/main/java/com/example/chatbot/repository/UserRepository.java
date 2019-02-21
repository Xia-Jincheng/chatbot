package com.example.chatbot.repository;

import com.example.chatbot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from user where user.name=?1", nativeQuery = true)
    User findUserByName(String name);

    @Query(value = "select * from user where user.name regexp concat('.*', :input, '.*') or user.phone " +
            "regexp concat('.*', :input, '.*') or user.email regexp concat('.*', :input, '.*')", nativeQuery = true)
    List<User> findUsersByInput(@Param("input") String input);

    @Query(value = "select * from user where user.status=1", nativeQuery = true)
    List<User> getAllUser();

    @Query(value = "select * from user where user.status=0", nativeQuery = true)
    List<User> getAllAdmin();

    @Query(value = "select * from user where user.status=2", nativeQuery = true)
    List<User> getAllCustom();

    @Query(value = "select * from user where user.status=1 limit ?1,11", nativeQuery = true)
    List<User> getAPageUser(Integer start);

    @Query(value = "select count(*) from user where user.status=1", nativeQuery = true)
    Integer getUserNum();

    @Query(value = "select * from user where user.status=2 limit ?1,11", nativeQuery = true)
    List<User> getAPageCustom(Integer start);

    @Query(value = "select count(*) from user where user.status=2", nativeQuery = true)
    Integer getCustomNum();

    @Query(value = "select * from user where user.status=0 limit ?1,11", nativeQuery = true)
    List<User> getAPageAdmin(Integer start);

    @Query(value = "select count(*) from user where user.status=0", nativeQuery = true)
    Integer getAdminNum();
}
