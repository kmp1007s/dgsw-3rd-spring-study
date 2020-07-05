package kr.hs.dgsw.mywebshop.Service;

import kr.hs.dgsw.mywebshop.Domain.User;

public interface UserService {
  User findById(Long id);

  User findByUserId(String userId);

  Long add(User user);

  int modify(User user);

  int deleteById(Long id);

  User login(User user);
}