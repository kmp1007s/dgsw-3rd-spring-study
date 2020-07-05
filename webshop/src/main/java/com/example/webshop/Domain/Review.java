package com.example.webshop.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Review {
    private Long id;
    private Long product_id;
    private Long user_id;
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
}