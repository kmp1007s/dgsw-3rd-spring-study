package kr.hs.dgsw.webshop.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  List<User> findall();

  int deleteById(@Param("id") Long id);

  Long add(User user);

  int modify(User user);

  User findById(@Param("id") Long id);

  Long Login(User user);
}