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
  @Column(nullable = false) // null이 들어갈 수 없는 필드
  private Long userId;
  @Column(nullable = false)
  private String title;
  @Column(nullable = false, columnDefinition = "TEXT") // text 데이터 타입 사용
  private String content;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  private List<Attachment> pictures;
  @CreationTimestamp // 생성 시각 자동 생성
  @Column(updatable = false, nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // JSON 응답값의 형식을 yyyy-MM-dd HH:mm:ss로 지정
  private LocalDateTime created;
  @UpdateTimestamp // 수정 시각 자동 생성
  @Column(nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime modified;

  public Post(Long userId, String title, String content) { // userId, title, content를 받는 생성자
    this.userId = userId;
    this.title = title;
    this.content = content;
  }
}