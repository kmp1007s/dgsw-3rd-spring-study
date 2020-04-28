package kr.hs.dgsw.webclass01.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
  @Autowired
  private CalculatorService cs;

  @GetMapping("/calculator/{num1}/{num2}/{sign}")
  public int calculator(@PathVariable String num1, @PathVariable String num2, @PathVariable String sign) {
    return cs.calculator(num1, num2, sign);
  }
}