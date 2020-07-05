package com.example.webshop.Service;

import java.util.List;

import com.example.webshop.Domain.SubMenu;
import com.example.webshop.Domain.SubMenuMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubMenuServiceImpl implements SubMenuService {
    @Autowired
    SubMenuMapper subMenuMapper;

    @Override
    public List<SubMenu> findByMenuId(Long menuId) {
        return subMenuMapper.findByMenuId(menuId);
    }

    @Override
    public SubMenu findById(Long id) {
        return subMenuMapper.findById(id);
    }


}