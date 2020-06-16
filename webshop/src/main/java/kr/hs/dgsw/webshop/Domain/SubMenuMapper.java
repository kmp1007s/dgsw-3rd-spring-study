package kr.hs.dgsw.webshop.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubMenuMapper {
  List<SubMenu> findByMenuid(Long menuid);

  SubMenu findById(Long id);
}