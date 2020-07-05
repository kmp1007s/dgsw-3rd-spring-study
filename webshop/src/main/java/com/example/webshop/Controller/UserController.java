package com.example.webshop.Controller;

import java.util.List;

import com.example.webshop.Domain.User;
import com.example.webshop.Service.UserService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/user/{id}")
    public User findById(@PathVariable Long id) {
      return userService.findById(id);
    }

    @GetMapping("/api/user/account/{account}")
    public User findByAccount(@PathVariable String account) {
      return userService.findByAccount(account);
    }

    @GetMapping(value="/api/user")
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

    @DeleteMapping("/api/user/{id}")
    public int deleteById(@PathVariable Long id) {
      return userService.deleteById(id);
    }

    @PostMapping("/api/user/login")
    public User login(@RequestBody User user) {
      return userService.login(user);
    }

    @GetMapping("/api/user/exist/{account}")
    public boolean accountExist(@PathVariable String account) {
        return userService.accountExist(account);
    }
}