package kr.hs.dgsw.webshop.Service;

import java.util.List;

import kr.hs.dgsw.webshop.Domain.User;

public interface UserService {
  List<User> findAll();

  User findById(Long id);

  User findByAccount(String account);

  int deleteById(Long id);

  Long add(User user);

  int modify(User user);

  User login(User user);
}