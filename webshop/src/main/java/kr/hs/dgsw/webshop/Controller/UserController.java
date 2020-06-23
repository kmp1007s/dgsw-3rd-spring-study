package kr.hs.dgsw.webshop.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webshop.Domain.User;
import kr.hs.dgsw.webshop.Service.UserService;

@RestController
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/api/user/id")
  public User findById(@Param("id") Long id) {
    return userService.findById(id);
  }

  @GetMapping("/api/user/account")
  public User findByAccount(@Param("account") String account) {
    return userService.findByAccount(account);
  }

  @GetMapping("/api/user")
  public List<User> findAll() {
    return userService.findAll();
  }

  @PostMapping("/api/user")
  public Long add(@RequestBody User user) {
    return userService.add(user);
  }

  @PutMapping("/api/user")
  public int modify(@RequestBody User user) {
    return userService.modify(user);
  }

  @DeleteMapping("/api/user")
  public int deleteById(@Param("id") Long id) {
    return userService.deleteById(id);
  }

  @PostMapping("/api/user/login")
  public User login(@RequestBody User user) {
    return userService.login(user);
  }
}