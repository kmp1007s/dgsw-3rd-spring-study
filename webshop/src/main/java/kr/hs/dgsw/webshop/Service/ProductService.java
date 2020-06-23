package kr.hs.dgsw.webshop.Service;

import java.util.List;

import kr.hs.dgsw.webshop.Domain.Product;

public interface ProductService {
  List<Product> findAll();

  int deleteById(Long id);

  Long add(Product product);

  int modify(Product product);

  Product findById(Long id);

  List<Product> findByMenuId(Long menuid);

  List<Product> findBySubMenuId(Long submenuid);
}