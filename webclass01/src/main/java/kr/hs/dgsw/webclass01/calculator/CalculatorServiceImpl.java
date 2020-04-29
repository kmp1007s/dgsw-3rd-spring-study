package kr.hs.dgsw.webclass01.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

  @Override
  public int calculator(String num1, String num2, String operator) {
    int result = 0;

    switch (operator) {
      case "plus":
        result = Integer.parseInt(num1) + Integer.parseInt(num2);
        break;
      case "minus":
        result = Integer.parseInt(num1) - Integer.parseInt(num2);
        break;
      case "multi":
        result = Integer.parseInt(num1) * Integer.parseInt(num2);
        break;
      case "divide":
        result = Integer.parseInt(num1) / Integer.parseInt(num2);
        break;
    }

    return result;
  }
}