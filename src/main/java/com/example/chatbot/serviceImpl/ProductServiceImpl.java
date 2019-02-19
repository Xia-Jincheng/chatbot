package com.example.chatbot.serviceImpl;

import com.example.chatbot.entity.Product;
import com.example.chatbot.repository.ProductRepository;
import com.example.chatbot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product){
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(Integer id){
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

    @Override
    @Modifying
    public void modifyProduct(Product product){
        productRepository.save(product);
    }
}
