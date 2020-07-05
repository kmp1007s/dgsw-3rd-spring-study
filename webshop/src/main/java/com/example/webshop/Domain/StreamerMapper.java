package com.example.webshop.Domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StreamerMapper {
    List<Streamer> findAll();
}
