package com.example.chatbot.entity;

import javax.persistence.*;

@Entity
public class UserSuit {
    @Id
    @GeneratedValue
    private Integer user_id;

    // 余额
    private float balance;

    // 剩余通话时长
    private float remain_call;

    // 剩余流量
    private float remain_flux;

    // 剩余免费短信数量
    private Integer remain_note;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="product")
    private Product product;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getRemain_call() {
        return remain_call;
    }

    public void setRemain_call(float remain_call) {
        this.remain_call = remain_call;
    }

    public float getRemain_flux() {
        return remain_flux;
    }

    public void setRemain_flux(float remain_flux) {
        this.remain_flux = remain_flux;
    }

    public Integer getRemain_note() {
        return remain_note;
    }

    public void setRemain_note(Integer remain_note) {
        this.remain_note = remain_note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
