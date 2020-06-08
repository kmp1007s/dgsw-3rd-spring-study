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

@RestController // MVC에서 Controller에 해당
public class UserController {

  @Autowired // 의존성 주입
  private UserService userService; // DB 연동과 관련된 작업을 할 Service

  /**
   * 유저를 생성함 [POST] /user/create
   * 
   * @param user 생성할 유저 객체
   * @return ResponseFormat 정형화된 응답 포맷
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
   * ID로 유저 업데이트 [PUT] /user/update/{id}
   * 
   * @param id   업데이트 할 유저의 ID
   * @param user 업데이트 할 유저 데이터
   * @return ResponseFormat 정형화된 응답 포맷
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
   * ID로 유저 삭제 [DELETE] /user/delete/{id}
   * 
   * @param id 삭제할 유저의 ID
   * @return ResponseFormat 정형화된 응답 포맷
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
   * ID로 유저 가져오기 [GET] /user/read/{id}
   * 
   * @param id 조회할 유저의 ID
   * @return ResponseFormat 정형화된 응답 포맷
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
   * 전체 유저 가져오기 [GET] /user/read
   * 
   * @return ResponseFormat 정형화된 응답 포맷
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