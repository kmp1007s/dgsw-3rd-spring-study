package kr.hs.dgsw.webclass02.Service;

import java.util.List;

import kr.hs.dgsw.webclass02.Domain.User;

public interface UserService {
  User add(User user);

  User login(String email, String password);

  User update(Long id, User user);

  boolean delete(Long id);

  User view(Long id);

  List<User> list();
}