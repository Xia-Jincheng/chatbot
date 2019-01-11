package com.example.chatbot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    private String productDetail;

    @OneToMany(mappedBy = "product",cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private List<SpecialRecord> specialRecordList;
}
