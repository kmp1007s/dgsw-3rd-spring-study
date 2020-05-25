package kr.hs.dgsw.webclass02.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webclass02.Domain.User;
import kr.hs.dgsw.webclass02.Service.UserService;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/user/add")
  public User add(@RequestBody User user) {
    return userService.add(user);
  }

  @PostMapping("/user/login")
  public User login(@RequestBody User user) {
    return userService.login(user.getEmail(), user.getPassword());
  }

  @PutMapping("/user/update/{id}")
  public User update(@PathVariable Long id, @RequestBody User user) {
    return userService.update(id, user);
  }

  @DeleteMapping("/user/delete/{id}")
  public boolean delete(@PathVariable Long id) {
    return userService.delete(id);
  }

  @GetMapping("/user/view/{id}")
  public User view(@PathVariable Long id) {
    return userService.view(id);
  }

  @GetMapping("/user/list")
  public List<User> list() {
    return userService.list();
  }
}