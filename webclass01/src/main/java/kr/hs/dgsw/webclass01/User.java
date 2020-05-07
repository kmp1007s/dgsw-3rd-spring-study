package kr.hs.dgsw.webclass01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
  private String id;
  private String name;
  private String email;

  @Override
  public String toString() {
    return id + "/" + name + "/" + email;
  }
}