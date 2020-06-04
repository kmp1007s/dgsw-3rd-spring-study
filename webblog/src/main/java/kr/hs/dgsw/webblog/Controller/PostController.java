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

@RestController
public class PostController {

  @Autowired
  private PostService postService;

  @PostMapping("/post/create")
  public ResponseFormat create(@RequestBody Post post) {
    Post newPost = postService.create(post);
    if (newPost != null) {
      return new ResponseFormat(ResponseType.POST_ADD, newPost, newPost.getId());
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @PutMapping("/post/update/{id}")
  public ResponseFormat update(@PathVariable Long id, @RequestBody Post post) {
    if (postService.update(id, post) != null) {
      return new ResponseFormat(ResponseType.POST_UPDATE, postService.update(id, post), post.getId());
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @DeleteMapping("/post/delete/{id}")
  public ResponseFormat delete(@PathVariable Long id) {
    if (postService.delete(id)) {
      return new ResponseFormat(ResponseType.POST_DELETE, postService.delete(id), id);
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @GetMapping("/post/read/{id}")
  public ResponseFormat read(@PathVariable Long id) {
    if (postService.read(id) != null) {
      return new ResponseFormat(ResponseType.POST_GET, postService.read(id), id);
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @GetMapping("/post/read/user/{userId}")
  public ResponseFormat readByUserId(@PathVariable Long userId) {
    if (postService.readByUserId(userId) != null) {
      return new ResponseFormat(ResponseType.POST_GET_BY_USER, postService.readByUserId(userId), userId);
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @GetMapping("/post/read")
  public ResponseFormat readAll() {
    if (postService.readAll() != null) {
      return new ResponseFormat(ResponseType.POST_GET_ALL, postService.readAll());
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }
}