package com.example.webshop.Controller;

import java.util.List;

import com.example.webshop.Domain.Product;
import com.example.webshop.Service.ProductService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value="/api/product")
    public Long addProduct(@RequestBody Product product) { return productService.add(product); }

    @GetMapping(value="/api/product")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(value="/api/product/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping(value="/api/product/menu/{menuId}")
    public List<Product> findByMenuId(@PathVariable Long menuId) {
        return productService.findByMenuId(menuId);
    }
}