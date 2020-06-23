package kr.hs.dgsw.webshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webshop.Domain.Menu;
import kr.hs.dgsw.webshop.Domain.MenuMapper;

@Service
public class MenuServiceImpl implements MenuService {
  @Autowired
  MenuMapper menuMapper;

  @Override
  public List<Menu> findAll() {
    return menuMapper.findall();
  }

  @Override
  public Menu findById(Long id) {
    return menuMapper.findById(id);
  }
}