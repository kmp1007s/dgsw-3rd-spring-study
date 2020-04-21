package kr.hs.dgsw.webclass01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcContoller {

  private boolean emptyParam(String[] params) {
    for (String param : params) {
      if (param.equals(""))
        return true;
    }
    return false;
  }

  @GetMapping("/calc")
  public String calcQuery(@RequestParam final String num1, @RequestParam final String operator,
      @RequestParam final String num2) {
    if (!emptyParam(new String[] { num1, operator, num2 })) {
      switch (operator) {
        case "add":
          return "" + (Integer.parseInt(num1) + Integer.parseInt(num2));
        case "sub":
          return "" + (Integer.parseInt(num1) - Integer.parseInt(num2));
        case "mul":
          return "" + (Integer.parseInt(num1) * Integer.parseInt(num2));
        case "div":
          return "" + (Integer.parseInt(num1) / Integer.parseInt(num2));
      }
    }

    return "Can't Caculate";
  }

  @GetMapping("/calc/{num1}/{operator}/{num2}")
  public String calcPath(@PathVariable final String num1, @PathVariable final String operator,
      @PathVariable final String num2) {
    if (!emptyParam(new String[] { num1, operator, num2 })) {
      switch (operator) {
        case "add":
          return "" + (Integer.parseInt(num1) + Integer.parseInt(num2));
        case "sub":
          return "" + (Integer.parseInt(num1) - Integer.parseInt(num2));
        case "mul":
          return "" + (Integer.parseInt(num1) * Integer.parseInt(num2));
        case "div":
          return "" + (Integer.parseInt(num1) / Integer.parseInt(num2));
      }
    }

    return "Can't Caculate";
  }
}