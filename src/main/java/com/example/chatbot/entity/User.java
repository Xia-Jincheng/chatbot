package com.example.chatbot.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String email;

    private Integer status;

    private String phone;

    private String password;

    private Boolean isPresent;
    /*如果是客服，是否上任，如果为true则上任，如果为false则不上任*/

    @OneToMany(mappedBy = "user",cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private List<ChatRecord> chatRecordList;

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }

    public List<ChatRecord> getChatRecordList() {
        return chatRecordList;
    }

    public void setChatRecordList(List<ChatRecord> chatRecordList) {
        this.chatRecordList = chatRecordList;
    }
    /*外键聊天记录*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
