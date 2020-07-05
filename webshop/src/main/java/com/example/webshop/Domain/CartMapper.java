package com.example.webshop.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {
    Long add(Cart cart);
    int deleteById(@Param("id") Long id);
    int deleteByUserId(@Param("userId") Long userId);
    Cart findById(@Param("id") Long id);
    List<Cart> findByUserId(@Param("userId") Long userId);
}