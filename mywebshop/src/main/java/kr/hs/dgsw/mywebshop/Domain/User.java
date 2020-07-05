package kr.hs.dgsw.mywebshop.Domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
  private Long id;
  private String userId;
  private String password;
  private LocalDateTime created;
  private LocalDateTime updated;
}