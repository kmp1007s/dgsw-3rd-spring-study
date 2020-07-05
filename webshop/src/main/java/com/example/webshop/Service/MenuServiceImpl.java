package com.example.webshop.Service;

import java.util.List;

import com.example.webshop.Domain.Menu;
import com.example.webshop.Domain.MenuMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> findAll() {
        return menuMapper.findAll();
    }

    @Override
    public Menu findById(Long id) {
        return menuMapper.findById(id);
    }
    
}