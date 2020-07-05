package com.example.webshop.Controller;

import java.util.List;

import com.example.webshop.Domain.Product;
import com.example.webshop.Service.ProductService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value="/api/product")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(value="/api/product/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping(value="/api/product/{menuId}")
    public List<Product> findByMenuId(@PathVariable Long menuId) {
        return productService.findByMenuId(menuId);
    }
}