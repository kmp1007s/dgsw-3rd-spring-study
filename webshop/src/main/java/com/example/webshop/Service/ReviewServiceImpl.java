package com.example.webshop.Service;

import java.util.List;

import com.example.webshop.Domain.Review;
import com.example.webshop.Domain.ReviewMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public Long add(Review review) {
        return reviewMapper.add(review);
    }

    @Override
    public int deleteById(Long id) {
        return reviewMapper.deleteById(id);
    }

    @Override
    public int modify(Review review) {
        return reviewMapper.modify(review);
    }

    @Override
    public List<Review> findByProductId(Long productId) {
        return reviewMapper.findByProductId(productId);
    }
}