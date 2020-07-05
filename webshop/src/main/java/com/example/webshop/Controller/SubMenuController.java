package com.example.webshop.Controller;

import java.util.List;

import com.example.webshop.Domain.SubMenu;
import com.example.webshop.Service.SubMenuService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubMenuController {
    @Autowired
    SubMenuService subMenuService;

    @GetMapping(value="/api/subMenu/{menuId}")
    public List<SubMenu> findByMenuId(@PathVariable Long menuId) {
        return subMenuService.findByMenuId(menuId);
    }

    @GetMapping(value="/api/subMenu/{id}")
    public SubMenu findById(@PathVariable Long id) {
        return subMenuService.findById(id);
    }
}