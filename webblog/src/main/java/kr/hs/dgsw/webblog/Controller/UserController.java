package kr.hs.dgsw.webblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webblog.Domain.User;
import kr.hs.dgsw.webblog.Protocol.ResponseFormat;
import kr.hs.dgsw.webblog.Protocol.ResponseType;
import kr.hs.dgsw.webblog.Service.UserService;

@RestController // PostController는 RestController 역할을 하는 클래스임
public class UserController {

  @Autowired // 의존성 주입
  private UserService userService; // DB 연동과 관련된 작업을 할 Service

  /**
   * POST 메소드로 /user/create 요청이 들어오면 처리
   */
  @PostMapping("/user/create")
  public ResponseFormat create(@RequestBody User user) {
    User newUser = userService.create(user);
    if (newUser != null) {
      return new ResponseFormat(ResponseType.USER_ADD, newUser, newUser.getId());
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  /**
   * Put 메소드로 /user/update/{id} 요청이 들어오면 처리
   */
  @PutMapping("/user/update/{id}")
  public ResponseFormat update(@PathVariable Long id, @RequestBody User user) {
    if (userService.update(id, user) != null) {
      return new ResponseFormat(ResponseType.USER_UPDATE, userService.update(id, user), user.getId());
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  /**
   * Delete 메소드로 /user/create/{id} 요청이 들어오면 처리
   */
  @DeleteMapping("/user/delete/{id}")
  public ResponseFormat delete(@PathVariable Long id) {
    if (userService.delete(id)) {
      return new ResponseFormat(ResponseType.USER_DELETE, userService.delete(id), id);
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  /**
   * Get 메소드로 /user/read/{id} 요청이 들어오면 처리
   */
  @GetMapping("/user/read/{id}")
  public ResponseFormat read(@PathVariable Long id) {
    if (userService.read(id) != null) {
      return new ResponseFormat(ResponseType.USER_GET, userService.read(id), id);
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  /**
   * Get 메소드로 /user/read 요청이 들어오면 처리
   */
  @GetMapping("/user/read")
  public ResponseFormat readAll() {
    if (userService.readAll() != null) {
      return new ResponseFormat(ResponseType.USER_GET_ALL, userService.readAll());
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }
}