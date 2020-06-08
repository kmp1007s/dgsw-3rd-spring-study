package kr.hs.dgsw.webblog.Service;

import java.util.List;

import kr.hs.dgsw.webblog.Domain.User;

// user 데이터를 다루는데 사용되는 함수들을 인터페이스로 선언
public interface UserService {
  User create(User user);

  User read(Long id);

  User update(Long id, User user);

  boolean delete(Long id);

  List<User> readAll();
}