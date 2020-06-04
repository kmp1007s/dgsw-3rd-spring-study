package kr.hs.dgsw.webblog.Domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private Long userId;
  @Column(nullable = false)
  private String title;
  @Column(nullable = false, columnDefinition = "TEXT")
  private String content;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  private List<Attachment> pictures;
  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;
  @UpdateTimestamp
  @Column(nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime modified;

  public Post(Long userId, String title, String content) {
    this.userId = userId;
    this.title = title;
    this.content = content;
  }
}