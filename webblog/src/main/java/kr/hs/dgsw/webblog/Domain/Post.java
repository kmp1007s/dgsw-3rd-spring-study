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
  @Column(nullable = false, columnDefinition = "TEXT") // TEXT 데이터 타입 사용
  private String content;
  // 1:N관계, Entity 변경에 따라 관계를 맺은 Entity 변경 전략을 모두 사용,
  // 엔티티 매니저를 통해 엔티티를 조회하면 연관관계에 매핑되어 있는 엔티티도 함께 조회,
  // Entity 변경 시 DB 변경 전략을 DB 레이어에서 처리
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

  // request로 받아야 하는 필드들을 포함한 생성자
  public Post(Long userId, String title, String content) {
    this.userId = userId;
    this.title = title;
    this.content = content;
  }
}