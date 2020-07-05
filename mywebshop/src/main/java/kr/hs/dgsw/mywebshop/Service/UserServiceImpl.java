package kr.hs.dgsw.mywebshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.mywebshop.Domain.User;
import kr.hs.dgsw.mywebshop.Domain.UserMapper;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserMapper userMapper;

  @Override
  public User findById(Long id) {
    return userMapper.findById(id);
  }

  @Override
  public User findByUserId(String userId) {
    return userMapper.findByUserId(userId);
  }

  @Override
  public Long add(User user) {
    return userMapper.add(user);
  }

  @Override
  public int modify(User user) {
    return userMapper.modify(user);
  }

  @Override
  public int deleteById(Long id) {
    return userMapper.deleteById(id);
  }

  @Override
  public User login(User user) {
    return userMapper.login(user);
  }

}