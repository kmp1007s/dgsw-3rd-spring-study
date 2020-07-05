package kr.hs.dgsw.mywebshop.Controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.mywebshop.Domain.User;
import kr.hs.dgsw.mywebshop.Service.UserService;

@RestController
public class UserContorller {
  @Autowired
  UserService userService;

  @GetMapping("/users/id")
  public User findById(@Param("id") Long id) {
    return userService.findById(id);
  }
}