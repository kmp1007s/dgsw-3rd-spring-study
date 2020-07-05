package kr.hs.dgsw.mywebshop.Domain;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  User findById(Long id);

  User findByUserId(String userId);

  Long add(User user);

  int modify(User user);

  int deleteById(Long id);

  User login(User user);
}