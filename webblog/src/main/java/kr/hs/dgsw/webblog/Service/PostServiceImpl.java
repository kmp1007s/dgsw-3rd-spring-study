package kr.hs.dgsw.webblog.Service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webblog.Domain.Post;
import kr.hs.dgsw.webblog.Domain.User;
import kr.hs.dgsw.webblog.Repository.PostRepository;
import kr.hs.dgsw.webblog.Repository.UserRepository;

@Service // Service로서 역할을 한다고 알림
public class PostServiceImpl implements PostService {

  @Autowired // 의존성 주입
  private PostRepository postRepository; // 실제 SQL로 DB 조작을 대신해주는 레포지토리
  @Autowired
  private UserRepository userRepository;

  @PostConstruct // @PostConstruct가 붙은 메소드는 클래스가 service를 수행하기 전에 발생, 다른 리소스에서 호출되지 않아도 수행함, bean
                 // lifecycle엣 오직 한 번만 수행
  private void init() {
    User user = userRepository.save(new User("imrimee01", "1234", "우효림11", "imrimee@dgsw.hs.kr", "010-1234-1234",
        "https://cdn3.iconfinder.com/data/icons/mixed-communication-and-ui-pack-1/48/general_pack_NEW_glyph_profile-512.png"));
    postRepository.save(new Post(user.getId(), "안녕하세요.", "첫 번째 게시물입니다."));
  }

  /**
   * @param post 생성할 포스트 데이터
   * @return Post 생성된 포스트 데이터
   */
  @Override
  public Post create(Post post) {
    return postRepository.save(post);
  }

  /**
   * @param id 읽어들일 포스트의 ID
   * @return Post 읽은 포스트 데이터
   */
  @Override
  public Post read(Long id) {
    return postRepository.findById(id).isPresent() ? postRepository.findById(id).get() : null;
  }

  /**
   * @param userId 작성자로써 조회할 사용자의 ID
   * @return Post 작성자가 작성한 포스트
   */
  @Override
  public Post readByUserId(Long userId) {
    return postRepository.findTopByUserIdOrderByIdDesc(userId).orElse(null);
  }

  /**
   * @param id   업데이트 할 포스트의 ID
   * @param post 업데이트 할 포스트 객체
   * @return Post 업데이트 한 포스트 객체
   */
  @Override
  public Post update(Long id, Post post) {
    return postRepository.findById(id).map(found -> {
      found.setTitle(Optional.ofNullable(post.getTitle()).orElse(found.getTitle()));
      found.setContent(Optional.ofNullable(post.getContent()).orElse(found.getContent()));
      found.setPictures(Optional.ofNullable(post.getPictures()).orElse(found.getPictures()));
      return postRepository.save(found);
    }).orElse(null);
  }

  /**
   * @param id 삭제 할 포스트의 ID
   * @return boolean 삭제 성공 여부
   */
  @Override
  public boolean delete(Long id) {
    try {
      postRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * @return List<Post> 전체 포스트
   */
  @Override
  public List<Post> readAll() {
    return postRepository.findAll();
  }
}