package com.example.webshop.Service;

import java.util.List;

import com.example.webshop.Domain.Product;
import com.example.webshop.Domain.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public int deleteById(Long id) {
        return productMapper.deleteById(id);
    }

    @Override
    public Long add(Product product) {
        return productMapper.add(product);
    }

    @Override
    public int modify(Product product) {
        return productMapper.modify(product);
    }

    @Override
    public Product findById(Long id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> findByMenuId(Long menuId) {
        return productMapper.findByMenuId(menuId);
    }

    @Override
    public List<Product> findBySubMenuId(Long subMenuId) {
        return productMapper.findBySubMenuId(subMenuId);
    }
}