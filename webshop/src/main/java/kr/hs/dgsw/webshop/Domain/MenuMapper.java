package kr.hs.dgsw.webshop.Domain;

import java.util.List;

public interface MenuMapper {
  List<Menu> findall();

  Menu findById(Long id);
}