package kr.hs.dgsw.webclass02.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webclass02.Domain.User;
import kr.hs.dgsw.webclass02.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Override
  public User add(User user) {
    Optional<User> found = userRepository.findByEmail(user.getEmail());
    if (found.isPresent())
      return null;
    return userRepository.save(user);
  }

  @Override
  public User login(String email, String password) {
    Optional<User> user = userRepository.findByEmail(email);
    if (user.isPresent()) {
      if (user.get().getPassword().equals(password))
        return user.get();
    }
    return null;
  }

  @Override
  public User update(Long id, User user) {
    return userRepository.findById(id).map(found -> {
      found.setUserName(Optional.ofNullable(user.getUserName()).orElse(found.getUserName()));
      found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
      found.setOriginalName(Optional.ofNullable(user.getOriginalName()).orElse(found.getOriginalName()));
      found.setStoredPath(Optional.ofNullable(user.getStoredPath()).orElse(found.getStoredPath()));
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
  public User view(Long id) {
    Optional<User> user = userRepository.findById(id);
    return user.isPresent() ? user.get() : null;
  }

  @Override
  public List<User> list() {
    return userRepository.findAll();
  }
}