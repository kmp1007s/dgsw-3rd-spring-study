package com.example.webshop.Controller;

import com.example.webshop.Domain.Streamer;
import com.example.webshop.Service.StreamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StreamerController {
    @Autowired
    StreamerService streamerService;

    @GetMapping(value="/api/streamer")
    public List<Streamer> findAll() {
        return streamerService.findAll();
    }
}
