package kr.hs.dgsw.webshop.Domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Review {
  private Long id;
  private Long productid;
  private String username;
  private String content;
  private LocalDateTime created;
  private LocalDateTime modified;
}