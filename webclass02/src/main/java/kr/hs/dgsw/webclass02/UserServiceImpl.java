package kr.hs.dgsw.webclass02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service // UserServiceImpl이 Service라는 것을 알림
public class UserServiceImpl implements UserService { // UserService interface를 구현
  List<User> userList; // 사용자 리스트 선언

  public UserServiceImpl() {
    userList = new ArrayList<>(); // 사용자 리스트 ArrayList로 생성
    userList.add(new User("user1", "김세한", "kmp1007s@dgsw")); // 사용자 추가 1
    userList.add(new User("user2", "김세한2", "kmp1007s2@dgsw")); // 사용자 추가 2
    userList.add(new User("user3", "김세한3", "kmp1007s3@dgsw")); // 사용자 추가 3
  }

  @Override // UserService 인터페이스 구현
  /**
   * 전체 User 반환
   */
  public List<User> list() {
    return userList;
  }

  @Override // UserService 인터페이스 구현
  /**
   * userList중에서 인자로 받은 id와 일치하는 User 객체를 반환
   */
  public User view(String id) {
    User user = userList.stream().filter(found -> found.getId().equals(id)).findAny().orElse(null);
    return user;
  }

  @Override // UserService 인터페이스 구현
  /**
   * User 객체를 전달받아 userList에 추가하고 추가 성공 실패 여부를 반환
   */
  public boolean add(User user) {
    User found = view(user.getId()); // user의 Id로 userList에서 찾아옴. 있다면 User 없다면 null
    if (found == null) // userList에 존재하지 않는다면
      return userList.add(user); // userList에 추가
    return false; // userList에 이미 존재한다면 false를 반환
  }

  @Override // UserService 인터페이스 구현
  /**
   * id로 유저를 찾아 Name과 Email 필드를 전달받은 User의 Name과 Email로 업데이트
   */
  public User update(String id, User user) {
    User found = view(id); // user의 Id로 userList에서 찾아옴. 있다면 User 없다면 null
    if (found != null) { // userList에 존재하지 않는다면
      found.setName(user.getName()); // 찾은 User의 Name을 업데이트
      found.setEmail(user.getEmail()); // 찾은 User의 Email을 업데이트
    }
    return found; // null 반환
  }

  @Override // UserService 인터페이스 구현
  /**
   * 전달받은 id로 User를 찾아 userList에서 삭제
   */
  public boolean delete(String id) {
    User found = view(id);
    return userList.remove(found);
  }
}