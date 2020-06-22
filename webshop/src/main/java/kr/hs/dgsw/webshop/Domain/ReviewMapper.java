package kr.hs.dgsw.webshop.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewMapper {
  Long add(Review review);

  int deleteById(@Param("id") Long id);

  int modify(Review review);

  List<Review> findByProductId(@Param("productid") Long productid);
}