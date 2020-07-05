package com.example.webshop.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubMenu {
    private Long id;
    private Long menu_id;
    private String name;
}