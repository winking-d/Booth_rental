package com.irs.mapper;

import com.irs.pojo.TbTest;
import com.irs.pojo.TbTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTestMapper {
    long countByExample(TbTestExample example);

    int deleteByExample(TbTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTest record);

    int insertSelective(TbTest record);

    List<TbTest> selectByExample(TbTestExample example);

    TbTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTest record, @Param("example") TbTestExample example);

    int updateByExample(@Param("record") TbTest record, @Param("example") TbTestExample example);

    int updateByPrimaryKeySelective(TbTest record);

    int updateByPrimaryKey(TbTest record);
}