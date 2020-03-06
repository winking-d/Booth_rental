package com.irs.mapper;

import com.irs.pojo.TbShops;
import com.irs.pojo.TbShopsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbShopsMapper {
    long countByExample(TbShopsExample example);

    int deleteByExample(TbShopsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbShops record);

    int insertSelective(TbShops record);

    List<TbShops> selectByExample(TbShopsExample example);

    TbShops selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbShops record, @Param("example") TbShopsExample example);

    int updateByExample(@Param("record") TbShops record, @Param("example") TbShopsExample example);

    int updateByPrimaryKeySelective(TbShops record);

    int updateByPrimaryKey(TbShops record);
}