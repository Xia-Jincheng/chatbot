package com.example.chatbot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    private String name;

    private float fee;

    private float call_duration;

    private Integer flux;

    private Integer note;

    @OneToMany(mappedBy = "product",cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private List<SpecialRecord> specialRecordList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public float getCall_duration() {
        return call_duration;
    }

    public void setCall_duration(float call_duration) {
        this.call_duration = call_duration;
    }

    public Integer getFlux() {
        return flux;
    }

    public void setFlux(Integer flux) {
        this.flux = flux;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public List<SpecialRecord> getSpecialRecordList() {
        return specialRecordList;
    }

    public void setSpecialRecordList(List<SpecialRecord> specialRecordList) {
        this.specialRecordList = specialRecordList;
    }
}
