package com.example.webshop.Controller;

import java.util.List;

import com.example.webshop.Domain.Menu;
import com.example.webshop.Service.MenuService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping(value="/api/menu")
    public List<Menu> findAll() {
        return menuService.findAll();
    }

    @GetMapping(value="/api/menu/{id}")
    public Menu findById(@PathVariable Long id) {
        return menuService.findById(id);
    }
}