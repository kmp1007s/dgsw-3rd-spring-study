package kr.hs.dgsw.webclass01.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
  @Autowired
  private CalculatorService cs;

  private boolean emptyParam(String[] params) {
    for (String param : params) {
      if (param == null || param.equals(""))
        return true;
    }
    return false;
  }

  private boolean canParseOperandToInt(String num1, String num2) {
    try {
      Integer.parseInt(num1);
      Integer.parseInt(num2);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private boolean divideWithZero(String sign, int num2) {
    return sign.equals("divide") && num2 == 0 ? true : false;
  }

  @GetMapping("/calculator/{num1}/{num2}/{sign}")
  public String calculator(@PathVariable String num1, @PathVariable String num2, @PathVariable String sign) {
    if (emptyParam(new String[] { num1, num2, sign }))
      return "Empty Parameter";

    if (!canParseOperandToInt(num1, num2))
      return "Can't Parse To Int";

    if (divideWithZero(sign, Integer.parseInt(num2)))
      return "Can't Divide With 0";

    return cs.calculator(num1, num2, sign) + "";
  }
}