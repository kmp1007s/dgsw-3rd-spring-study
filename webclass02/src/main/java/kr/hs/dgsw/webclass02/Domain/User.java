package kr.hs.dgsw.webclass02.Domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String userName;
  private String email;
  private String password;
  @CreationTimestamp
  private LocalDateTime joined;
  @UpdateTimestamp
  private LocalDateTime modified;
  private String storedPath;
  private String originalName;

  public User(String userName, String email, String password, String storedPath, String originalName) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.storedPath = storedPath;
    this.originalName = originalName;
  }
}