package kr.hs.dgsw.webclass02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {
  private String id;
  private String name;
  private String email;
}