package kr.hs.dgsw.webblog.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // JPA Entity라고 선언 -> Attachment라는 테이블과 매핑
@Data // Getter, Setter 세팅
@NoArgsConstructor // 기본 생성자 추가
public class Attachment {
  @Id // 튜플의 기본키
  @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql의 Auto Increment 전략 사용
  private Long id;
  private String storedPath;
  private Long postId;
}