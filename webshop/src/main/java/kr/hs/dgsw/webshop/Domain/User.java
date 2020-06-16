package kr.hs.dgsw.webshop.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User {
  private Long id;
  private String account;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;
  private String username;
  private String tel;
  private String phone;
  private String zipcode;
  private String address;
  private String email;
  private LocalDateTime created;
  private LocalDateTime modified;
}