package kr.hs.dgsw.webshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webshop.Domain.SubMenu;
import kr.hs.dgsw.webshop.Domain.SubMenuMapper;

@Service
public class SubMenuServiceImpl implements SubMenuService {

  @Autowired
  SubMenuMapper subMenuMapper;

  @Override
  public List<SubMenu> findByMenuId(Long menuid) {
    return subMenuMapper.findByMenuid(menuid);
  }

  @Override
  public SubMenu findById(Long id) {
    return subMenuMapper.findById(id);
  }

}