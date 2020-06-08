package kr.hs.dgsw.webblog.Repository;

import kr.hs.dgsw.webblog.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // repository라고 알림, repository는 SQL로 DB 조작하는 함수를 자동 생성해 줌
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByAccount(String account);
}