package kr.hs.dgsw.webblog.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // DB 엔티티의 구조
@Data // Getter, Settor 세팅
@NoArgsConstructor // 기본 생성자 추가
public class Attachment {
  @Id // 기본키
  @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql의 Auto Increment 사용
  private Long id;
  private String storedPath;
  private Long postId;
}