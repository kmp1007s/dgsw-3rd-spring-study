package kr.hs.dgsw.webshop.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webshop.Domain.SubMenu;
import kr.hs.dgsw.webshop.Service.SubMenuService;

@RestController
public class SubMenuController {
  @Autowired
  SubMenuService subMenuService;

  @GetMapping("/api/subMenu/menuid")
  public List<SubMenu> findByMenuId(@Param("menuid") Long menuid) {
    return subMenuService.findByMenuId(menuid);
  }

  @GetMapping("/api/subMenu/id")
  public SubMenu findById(@Param("id") Long id) {
    return subMenuService.findById(id);
  }
}