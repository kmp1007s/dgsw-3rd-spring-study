package kr.hs.dgsw.webblog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.hs.dgsw.webblog.Domain.Post;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  Optional<Post> findTopByUserIdOrderByIdDesc(Long userId);
}