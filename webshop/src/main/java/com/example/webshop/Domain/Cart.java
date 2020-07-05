package com.example.webshop.Domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cart {
    private Long id;
    private Long user_id;
    private Long product_id;
    private int price;
    private int amount;
    private int total;
    private LocalDateTime created;
}