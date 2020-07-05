package com.example.webshop.Service;

import java.util.List;

import com.example.webshop.Domain.Menu;

public interface MenuService {
    List<Menu> findAll();
    Menu findById(Long id);
}