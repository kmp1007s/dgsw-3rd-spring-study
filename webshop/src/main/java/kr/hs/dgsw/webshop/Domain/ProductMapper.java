package kr.hs.dgsw.webshop.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
  Long add(Product product);

  int modify(Product product);

  int deleteById(@Param("id") Long id);

  Product findById(@Param("id") Long id);

  List<Product> findByMenuId(@Param("menuid") Long menuid);

  List<Product> findBySubMenuId(@Param("submenuid") Long submenuid);

  List<Product> findAll();
}