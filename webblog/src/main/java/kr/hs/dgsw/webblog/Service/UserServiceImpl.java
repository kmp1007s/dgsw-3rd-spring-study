package kr.hs.dgsw.webblog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webblog.Domain.User;
import kr.hs.dgsw.webblog.Repository.UserRepository;

@Service // Service로서 역할을 한다고 알림
public class UserServiceImpl implements UserService {

  @Autowired // 의존성 주입
  private UserRepository userRepository; // 실제 SQL로 DB 조작을 대신해주는 레포지토리

  /**
   * @param user 생성할 유저 객체
   * @return User 생성된 유저 객체
   */
  @Override
  public User create(User user) {
    Optional<User> found = userRepository.findByAccount(user.getAccount());
    if (found.isPresent())
      return null;
    return userRepository.save(user);
  }

  /**
   * @param id   업데이트 할 유저의 ID
   * @param user 업데이트 할 유저 데이터
   * @return User 업데이트 된 유저 객체
   */
  @Override
  public User update(Long id, User user) {
    return userRepository.findById(id).map(found -> {
      found.setPassword(Optional.ofNullable(user.getPassword()).orElse(found.getPassword()));
      found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
      found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
      found.setPhone(Optional.ofNullable(user.getPhone()).orElse(found.getPhone()));
      found.setProfilePath(Optional.ofNullable(user.getProfilePath()).orElse(found.getProfilePath()));
      return userRepository.save(found);
    }).orElse(null);
  }

  /**
   * @param id 삭제할 유저의 ID
   * @return boolean 삭제 성공 여부
   */
  @Override
  public boolean delete(Long id) {
    try {
      userRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * @param id 읽어들일 유저의 ID
   * @return User 읽어들인 유저 객체
   */
  @Override
  public User read(Long id) {
    Optional<User> user = userRepository.findById(id);
    return user.isPresent() ? user.get() : null;
  }

  /**
   * @return List<User> 전체 유저 반환
   */
  @Override
  public List<User> readAll() {
    return userRepository.findAll();
  }
}