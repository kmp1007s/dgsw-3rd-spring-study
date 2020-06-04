package kr.hs.dgsw.webblog.Service;

import java.util.List;

import kr.hs.dgsw.webblog.Domain.User;

public interface UserService {
  User create(User user);

  User read(Long id);

  User update(Long id, User user);

  boolean delete(Long id);

  List<User> readAll();
}