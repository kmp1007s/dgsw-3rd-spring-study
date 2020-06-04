package kr.hs.dgsw.webblog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webblog.Domain.User;
import kr.hs.dgsw.webblog.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User create(User user) {
    Optional<User> found = userRepository.findByAccount(user.getAccount());
    if (found.isPresent())
      return null;
    return userRepository.save(user);
  }

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

  @Override
  public boolean delete(Long id) {
    try {
      userRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public User read(Long id) {
    Optional<User> user = userRepository.findById(id);
    return user.isPresent() ? user.get() : null;
  }

  @Override
  public List<User> readAll() {
    return userRepository.findAll();
  }
}