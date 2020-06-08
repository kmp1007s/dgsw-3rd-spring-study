package kr.hs.dgsw.webblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webblog.Domain.Post;
import kr.hs.dgsw.webblog.Protocol.ResponseFormat;
import kr.hs.dgsw.webblog.Protocol.ResponseType;
import kr.hs.dgsw.webblog.Service.PostService;

@RestController // MVC에서 Controller에 해당
public class PostController {

  @Autowired // 의존성 주입
  private PostService postService; // DB 연동과 관련된 작업을 할 Service

  /**
   * 포스트 생성 [POST] Endpoint: /post/create
   * 
   * @param post 생성할 포스트 객체
   * @return ResponseFormat 정형화된 응답 포맷
   */
  @PostMapping("/post/create")
  public ResponseFormat create(@RequestBody Post post) {
    Post newPost = postService.create(post);
    if (newPost != null) {
      return new ResponseFormat(ResponseType.POST_ADD, newPost, newPost.getId());
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  /**
   * ID로 포스트 업데이트 [PUT] Endpoint: /post/update/{id}
   * 
   * @param id   업데이트 할 포스트의 ID
   * @param post 업데이트 할 포스트 데이터
   * @return ResponseFormat 정형화된 응답 포맷
   */
  @PutMapping("/post/update/{id}")
  public ResponseFormat update(@PathVariable Long id, @RequestBody Post post) {
    if (postService.update(id, post) != null) {
      return new ResponseFormat(ResponseType.POST_UPDATE, postService.update(id, post), post.getId());
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  /**
   * ID로 포스트 삭제 [DELETE] Endpoint: /post/delete/{id}
   * 
   * @param id 삭제할 포스트의 ID
   * @return ResponseFormat 정형화된 응답 포맷
   */
  @DeleteMapping("/post/delete/{id}")
  public ResponseFormat delete(@PathVariable Long id) {
    if (postService.delete(id)) {
      return new ResponseFormat(ResponseType.POST_DELETE, postService.delete(id), id);
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  /**
   * ID로 포스트 가져오기 [GET] Endpoint: /post/read/{id}
   * 
   * @param id 읽어들일 포스트의 ID
   * @return ResponseFormat 정형화된 응답 포맷
   */
  @GetMapping("/post/read/{id}")
  public ResponseFormat read(@PathVariable Long id) {
    if (postService.read(id) != null) {
      return new ResponseFormat(ResponseType.POST_GET, postService.read(id), id);
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  /**
   * 작성자 ID로 포스트 가져오기 [GET] Endpoint: /post/read/user/{userId}
   * 
   * @param userId 포스트 작성자로 조회할 사용자의 id
   * @return ResponseFormat 정형화된 응답 포맷
   */
  @GetMapping("/post/read/user/{userId}")
  public ResponseFormat readByUserId(@PathVariable Long userId) {
    if (postService.readByUserId(userId) != null) {
      return new ResponseFormat(ResponseType.POST_GET_BY_USER, postService.readByUserId(userId), userId);
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  /**
   * 전체 포스트 가져오기 [GET] Endpoint: /post/read
   * 
   * @return ResponseFormat 정형화된 응답 포맷
   */
  @GetMapping("/post/read")
  public ResponseFormat readAll() {
    if (postService.readAll() != null) {
      return new ResponseFormat(ResponseType.POST_GET_ALL, postService.readAll());
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }
}