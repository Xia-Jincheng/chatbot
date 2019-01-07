package com.example.chatbot.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class ChatRecord {
    @Id
    @GeneratedValue
    private Integer id;

    private String question;

    private String answer;

    private String addTime;

    private Boolean isReply;
    /*如果已经回答，则为true。如果没有回答，则为false*/

    private Boolean isBot;
    /*如果是机器人则为true，客服为false*/

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="user_id")
    private User user;

    private String serviceName;

    private String serviceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Boolean getReply() {
        return isReply;
    }

    public void setReply(Boolean reply) {
        isReply = reply;
    }

    public Boolean getBot() {
        return isBot;
    }

    public void setBot(Boolean bot) {
        isBot = bot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
