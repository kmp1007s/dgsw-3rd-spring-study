package kr.hs.dgsw.webclass01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // UserController는 문자열,객체 등을 리턴하는 Controller
public class UserController {
  @Autowired // 주입하려고 하는 객체의 타입이 일치하는지를 찾고 객체를 자동으로 주입
  UserService userService; // UserService를 사용하는 변수 선언

  @GetMapping("/user") // /user로 Get 요청이 들어오면 처리
  @ResponseBody // 메소드에서 리턴되는 값은 View를 통해 출력되지 않고 HTTP Response Body에 직접 쓰여짐
  /**
   * User 전체 반환
   * 
   * @return userList
   */
  public List<User> list() {
    return userService.list();
  }

  @GetMapping("/user/{id}") // /user/:id로 Get 요청이 들어오면 처리
  @ResponseBody // 메소드에서 리턴되는 값은 View를 통해 출력되지 않고 HTTP Response Body에 직접 쓰여짐
  /**
   * id에 해당하는 User 반환
   * 
   * @param id User's Id
   * @return user
   */
  public User view(@PathVariable String id) { // id라는 Path파라미터를 가져옴
    return userService.view(id); // id로 userList 조회
  }

  @PostMapping("/user") // /user/:id로 Post 요청이 들어오면 처리
  @ResponseBody // 메소드에서 리턴되는 값은 View를 통해 출력되지 않고 HTTP Response Body에 직접 쓰여짐
  /**
   * 
   * @param user User 객체
   * @return 추가 성공 실패 여부
   */
  public boolean add(@RequestBody User user) { // user라는 이름으로 request의 body를 가져옴
    return userService.add(user); // userList에 추가
  }

  @PutMapping("/user/{id}") // /user/:id로 Put 요청이 들어오면 처리
  @ResponseBody // 메소드에서 리턴되는 값은 View를 통해 출력되지 않고 HTTP Response Body에 직접 쓰여짐
  public User update(@PathVariable String id, @RequestBody User user) { // Path 파라미터 id와 Request의 body user를 가져옴
    return userService.update(id, user); // id로 user를 찾아 전달받은 user 객체로 업데이트
  }

  @DeleteMapping("/user/{id}") // /user/:id로 Delete 요청이 들어오면 처리
  @ResponseBody // 메소드에서 리턴되는 값은 View를 통해 출력되지 않고 HTTP Response Body에 직접 쓰여짐
  public boolean delete(@PathVariable String id) { // Path 파라미터 id를 가져옴
    return userService.delete(id); // id로 user를 찾아 userList에서 삭제
  }
}