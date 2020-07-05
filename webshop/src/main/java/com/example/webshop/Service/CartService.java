package com.example.webshop.Service;

import java.util.List;

import com.example.webshop.Domain.Cart;

public interface CartService {
    Long add(Cart cart);
    int deleteById(Long id);
    int deleteByUserId(Long userId);
    Cart findById(Long id);
    List<Cart> findByUserId(Long userId);
}