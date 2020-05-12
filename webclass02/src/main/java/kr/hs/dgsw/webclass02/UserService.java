package kr.hs.dgsw.webclass02;

import java.util.List;

public interface UserService {
  List<User> list();

  User view(String id);

  boolean add(User user);

  User update(String id, User user);

  boolean delete(String id);
}