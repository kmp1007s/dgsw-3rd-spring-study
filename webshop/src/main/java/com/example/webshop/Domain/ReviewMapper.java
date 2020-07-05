package com.example.webshop.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewMapper {
    Long add(Review review);
    int modify(Review review);
    int deleteById(@Param("id") Long id);
    List<Review> findByProductId(@Param("productId") Long productId);
}