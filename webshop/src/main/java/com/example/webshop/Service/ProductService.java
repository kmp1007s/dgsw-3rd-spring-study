package com.example.webshop.Service;

import java.util.List;

import com.example.webshop.Domain.Product;

public interface ProductService {
    List<Product> findAll();
    int deleteById(Long id);
    Long add(Product product);
    int modify(Product product);
    Product findById(Long id);
    List<Product> findByMenuId(Long menuId);
    List<Product> findBySubMenuId(Long subMenuId);
}