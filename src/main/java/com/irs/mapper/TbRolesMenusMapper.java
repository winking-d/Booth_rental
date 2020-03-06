package com.irs.mapper;

import com.irs.pojo.TbRolesMenus;
import com.irs.pojo.TbRolesMenusExample;
import com.irs.pojo.TbRolesMenusKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRolesMenusMapper {
    int countByExample(TbRolesMenusExample example);

    int deleteByExample(TbRolesMenusExample example);

    int deleteByPrimaryKey(TbRolesMenusKey key);

    int insert(TbRolesMenus record);

    int insertSelective(TbRolesMenusKey record);

    List<TbRolesMenusKey> selectByExample(TbRolesMenusExample example);

    int updateByExampleSelective(@Param("record") TbRolesMenusKey record, @Param("example") TbRolesMenusExample example);

    int updateByExample(@Param("record") TbRolesMenusKey record, @Param("example") TbRolesMenusExample example);
    
}