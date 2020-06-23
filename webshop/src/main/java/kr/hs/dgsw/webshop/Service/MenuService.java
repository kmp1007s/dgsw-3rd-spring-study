package kr.hs.dgsw.webshop.Service;

import java.util.List;

import kr.hs.dgsw.webshop.Domain.Menu;

public interface MenuService {
  List<Menu> findAll();

  Menu findById(Long id);
}