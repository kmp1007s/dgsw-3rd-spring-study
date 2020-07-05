package com.example.webshop.Controller;

import java.util.List;

import com.example.webshop.Domain.Review;
import com.example.webshop.Service.ReviewService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping(value="/api/review")
    public Long add(@RequestBody Review review) {
        return reviewService.add(review);
    }

    @DeleteMapping(value="/api/review/{id}")
    public int deleteById(@PathVariable Long id) {
        return reviewService.deleteById(id);
    }
    
    @GetMapping(value="/api/review/{productId}")
    public List<Review> findByProductId(@PathVariable Long productId) {
        return reviewService.findByProductId(productId);
    }

    @PutMapping(value="/api/review")
    public int modify(@RequestBody Review review) {
        return reviewService.modify(review);
    }
}