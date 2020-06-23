package kr.hs.dgsw.webshop.Service;

import java.util.List;

import kr.hs.dgsw.webshop.Domain.SubMenu;

public interface SubMenuService {
  List<SubMenu> findByMenuId(Long menuid);

  SubMenu findById(Long id);
}