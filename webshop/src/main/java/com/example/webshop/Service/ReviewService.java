package com.example.webshop.Service;

import java.util.List;

import com.example.webshop.Domain.Review;

public interface ReviewService {
    Long add(Review review);
    int deleteById(Long id);
    int modify(Review review);
    List<Review> findByProductId(Long productId);
}