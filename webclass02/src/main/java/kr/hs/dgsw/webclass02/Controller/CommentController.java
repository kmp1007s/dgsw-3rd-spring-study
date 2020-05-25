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

import kr.hs.dgsw.webclass02.Domain.Comment;
import kr.hs.dgsw.webclass02.Protocol.CommentUsernameProtocol;
import kr.hs.dgsw.webclass02.Service.CommentService;

@RestController
public class CommentController {
  @Autowired
  private CommentService commentService;

  @PostMapping("/comment/add")
  public CommentUsernameProtocol add(@RequestBody Comment comment) {
    return commentService.add(comment);
  }

  @PutMapping("/comment/update/{id}")
  public CommentUsernameProtocol update(@PathVariable Long id, @RequestBody Comment comment) {
    return commentService.update(id, comment);
  }

  @DeleteMapping("/comment/remove/{id}")
  public boolean remove(@PathVariable Long id) {
    return commentService.remove(id);
  }

  @GetMapping("/comment/view/{id}")
  public CommentUsernameProtocol view(@PathVariable Long id) {
    return commentService.view(id);
  }

  @GetMapping("/comment/list")
  public List<CommentUsernameProtocol> listAllComments() {
    return commentService.listAllComments();
  }
}