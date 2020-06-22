package kr.hs.dgsw.webshop.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {
  Long add(Cart cart);

  int deleteById(@Param("id") Long id);

  int deleteByUserId(@Param("userid") Long userid);

  Cart findById(@Param("id") Long id);

  List<Cart> findByUserId(@Param("id") Long userid);

}