package com.example.webshop.Controller;

import java.util.List;

import com.example.webshop.Domain.Cart;
import com.example.webshop.Service.CartService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping(value="/api/cart")
    public Long add(Cart cart) {
        return cartService.add(cart);
    }

    @DeleteMapping(value="/api/cart/{id}")
    public int deleteById(@PathVariable Long id) {
        return cartService.deleteById(id);
    }

    @DeleteMapping(value="/api/cart/{userId}")
    public int deleteByUserId(@PathVariable Long userId) {
        return cartService.deleteByUserId(userId);
    }

    @GetMapping(value="/api/cart/{id}")
    public Cart findById(@PathVariable Long id) {
        return cartService.findById(id);
    }

    @GetMapping(value="/api/cart/{userId}")
    public List<Cart> findByUserId(@PathVariable  Long userId) {
        return cartService.findByUserId(userId);
    }
}