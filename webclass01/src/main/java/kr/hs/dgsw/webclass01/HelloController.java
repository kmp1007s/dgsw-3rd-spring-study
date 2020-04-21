package kr.hs.dgsw.webclass01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/greeting")
  public String greeting(@RequestParam final String say, @RequestParam final String to) {
    return say + " " + to;
  }

  @GetMapping("/greeting1/{say}/{to}")
  public String greeting1(@PathVariable final String say, @PathVariable final String to) {
    return say + " " + to;
  }

  @PostMapping("/greeting2")
  public String greeting2(@RequestParam final String say2, @RequestParam final String to2) {
    return say2 + " " + to2;
  }
}