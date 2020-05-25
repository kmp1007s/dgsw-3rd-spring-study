package kr.hs.dgsw.webclass02.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webclass02.Domain.Comment;
import kr.hs.dgsw.webclass02.Domain.User;
import kr.hs.dgsw.webclass02.Protocol.CommentUsernameProtocol;
import kr.hs.dgsw.webclass02.Repository.CommentRepository;
import kr.hs.dgsw.webclass02.Repository.UserRepository;

@Service
public class CommentServiceImpl implements CommentService {
  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private UserRepository userRepository;

  @PostConstruct
  private void init() {
    User u = userRepository.save(new User("aaa", "aaa@dgsw", "1234", "C:/Users/saehan/Desktop/test", "originalName"));
    commentRepository.save(new Comment(u.getId(), "Hi 1", "C:/Users/saehan/Desktop/test", "originalName"));
  }

  @Override
  public CommentUsernameProtocol add(Comment comment) {
    // Optional<User> user = userRepository.findById(comment.getUserId());
    // if(user.isPresent()) added = commentRepository.save(comment);

    return new CommentUsernameProtocol(commentRepository.save(comment),
        userRepository.findById(comment.getUserId()).map(found -> found.getUserName()).orElse(null));
  }

  @Override
  public boolean remove(Long id) {
    try {
      commentRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public CommentUsernameProtocol update(Long id, Comment comment) {
    Optional<User> user = userRepository.findById(comment.getUserId());
    if (user.isPresent()) {
      return commentRepository.findById(id).map(found -> {
        found.setContent(Optional.ofNullable(comment.getContent()).orElse(found.getContent()));
        found.setStoredPath(Optional.ofNullable(comment.getStoredPath()).orElse(found.getStoredPath()));
        found.setOriginalName(Optional.ofNullable(comment.getOriginalName()).orElse(found.getOriginalName()));
        commentRepository.save(found);
        return new CommentUsernameProtocol(found, user.get().getUserName());
      }).orElse(null);
    }
    return null;
  }

  @Override
  public CommentUsernameProtocol view(Long id) {
    return commentRepository.findById(id).map(found -> {
      Optional<User> user = userRepository.findById(found.getUserId());
      String userName = user.isPresent() ? user.get().getUserName() : null;
      return new CommentUsernameProtocol(found, userName);
    }).orElse(null);
  }

  @Override
  public List<CommentUsernameProtocol> listAllComments() {
    List<Comment> commentList = commentRepository.findAll();
    List<CommentUsernameProtocol> cupList = new ArrayList<>();
    commentList.forEach(comment -> {
      Optional<User> found = userRepository.findById(comment.getUserId());
      String userName = found.isPresent() ? found.get().getUserName() : null;
      cupList.add(new CommentUsernameProtocol(comment, userName));
    });
    return cupList;
  }
}