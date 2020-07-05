package com.example.webshop.Controller;

import java.util.List;

import com.example.webshop.Domain.Cart;
import com.example.webshop.Service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping(value="/api/cart")
    public Long add(@RequestBody Cart cart) {
        return cartService.add(cart);
    }

    @DeleteMapping(value="/api/cart/{id}")
    public int deleteById(@PathVariable Long id) {
        return cartService.deleteById(id);
    }

    @DeleteMapping(value="/api/cart/user/{userId}")
    public int deleteByUserId(@PathVariable Long userId) {
        return cartService.deleteByUserId(userId);
    }

    @GetMapping(value="/api/cart/{id}")
    public Cart findById(@PathVariable Long id) {
        return cartService.findById(id);
    }

    @GetMapping(value="/api/cart/user/{userId}")
    public List<Cart> findByUserId(@PathVariable Long userId) {
        return cartService.findByUserId(userId);
    }

    @PutMapping(value="/api/cart")
    public int updateById(@RequestBody Cart cart) {
        return cartService.modify(cart);
    }
}