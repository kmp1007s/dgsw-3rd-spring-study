package kr.hs.dgsw.webblog.Service;

import java.util.List;

import kr.hs.dgsw.webblog.Domain.Post;

// post 데이터를 다루는데 사용되는 함수들을 인터페이스로 선언
public interface PostService {
  Post create(Post post);

  Post read(Long id);

  Post readByUserId(Long userId);

  Post update(Long id, Post post);

  boolean delete(Long id);

  List<Post> readAll();
}