package kr.hs.dgsw.webblog.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, unique = true, length = 20) // 유일값이며 길이는 20까지
  private String account;

  @Column(nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 쓰려는 경우에만 접근이 허용됨
  private String password;

  public void setPassword(String password) { // 비밀번호 암호화 함수
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-512"); // SHA-512 해쉬 알고리즘 사용
      md.update(password.getBytes(), 0, password.getBytes().length);
      this.password = new BigInteger(1, md.digest()).toString(16);
    } catch (NoSuchAlgorithmException e) {
      Logger logger = LoggerFactory.getLogger(User.class);
      logger.warn(e.getMessage());
    }
  }

  @Column(nullable = false)
  private String name;
  @Column(unique = true)
  private String email;
  @Column(unique = true)
  private String phone;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String profilePath;
  @CreationTimestamp
  @Column(updatable = false, nullable = false) // 수정 불가
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;
  @UpdateTimestamp
  @Column(updatable = false, nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime modified;

  public User(String account, String password, String name, String email, String phone, String profilePath) {
    this.account = account;
    setPassword(password);
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.profilePath = profilePath;
  }
}