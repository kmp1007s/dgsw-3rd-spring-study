package kr.hs.dgsw.webshopping.Service;

import java.util.List;

import kr.hs.dgsw.webshopping.Domain.Menu;

public interface MenuService {
  List<Menu> findAll();

  Menu findById(Long id);
}