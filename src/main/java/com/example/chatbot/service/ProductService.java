package com.example.chatbot.service;

import com.example.chatbot.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(Product product);
    List<Product> getAllProduct();
    void deleteProduct(Integer id);
    Optional<Product> getProduct(Integer id);
    void modifyProduct(Product product);
}