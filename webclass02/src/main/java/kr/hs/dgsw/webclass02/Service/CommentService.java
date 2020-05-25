package kr.hs.dgsw.webclass02.Service;

import java.util.List;

import kr.hs.dgsw.webclass02.Domain.Comment;
import kr.hs.dgsw.webclass02.Protocol.CommentUsernameProtocol;

public interface CommentService {
  CommentUsernameProtocol add(Comment comment);

  CommentUsernameProtocol update(Long id, Comment comment);

  boolean remove(Long id);

  CommentUsernameProtocol view(Long id);

  List<CommentUsernameProtocol> listAllComments();
}