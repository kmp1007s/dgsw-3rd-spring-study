package kr.hs.dgsw.webshop.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webshop.Domain.Menu;
import kr.hs.dgsw.webshop.Service.MenuService;

@RestController
public class MenuController {
  @Autowired
  MenuService menuService;

  @GetMapping("/api/menu")
  public List<Menu> findAll() {
    return menuService.findAll();
  }

  @GetMapping("/api/menu/id")
  public Menu findById(@Param("id") Long id) {
    return menuService.findById(id);
  }
}