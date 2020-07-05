package com.example.webshop.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private int price;
    private Long menu_id;
    private Long sub_menu_id;
    private Long streamer_id;
    private String details;
    private String factory;
}