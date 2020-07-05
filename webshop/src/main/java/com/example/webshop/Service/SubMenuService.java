package com.example.webshop.Service;

import java.util.List;

import com.example.webshop.Domain.SubMenu;

public interface SubMenuService {
    List<SubMenu> findByMenuId(Long menuId);
    SubMenu findById(Long id);
}