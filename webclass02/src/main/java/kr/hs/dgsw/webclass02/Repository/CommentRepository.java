package kr.hs.dgsw.webclass02.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.hs.dgsw.webclass02.Domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}