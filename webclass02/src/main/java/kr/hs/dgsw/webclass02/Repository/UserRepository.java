package kr.hs.dgsw.webclass02.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.hs.dgsw.webclass02.Domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}