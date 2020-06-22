package kr.hs.dgsw.webshop.Domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cart {
  private Long id;
  private String userid;
  private Long productid;
  private int price;
  private int amount;
  private int total;
  private LocalDateTime created;
}