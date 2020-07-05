package com.example.webshop.Service;

import com.example.webshop.Domain.Streamer;
import com.example.webshop.Domain.StreamerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamerServiceImpl implements StreamerService {
    @Autowired
    StreamerMapper streamerMapper;

    @Override
    public List<Streamer> findAll() {
        return streamerMapper.findAll();
    }
}
