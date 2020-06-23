package kr.hs.dgsw.webshop.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webshop.Domain.Product;
import kr.hs.dgsw.webshop.Service.ProductService;

@RestController
public class ProductController {
  @Autowired
  ProductService productService;

  @GetMapping("/api/product")
  public List<Product> findAll() {
    return productService.findAll();
  }

  @GetMapping("/api/product/id")
  public Product findById(@Param("id") Long id) {
    return productService.findById(id);
  }

  @GetMapping("/api/product/menuid")
  public List<Product> findByMenuId(@Param("menuid") Long menuid) {
    return productService.findByMenuId(menuid);
  }

  @DeleteMapping("/api/product")
  public int deleteById(@Param("id") Long id) {
    return productService.deleteById(id);
  }
}