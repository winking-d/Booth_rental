package com.irs.mapper;

import com.irs.pojo.TbOrders;
import com.irs.pojo.TbOrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrdersMapper {
    long countByExample(TbOrdersExample example);

    int deleteByExample(TbOrdersExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(TbOrders record);

    int insertSelective(TbOrders record);

    List<TbOrders> selectByExample(TbOrdersExample example);

    TbOrders selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") TbOrders record, @Param("example") TbOrdersExample example);

    int updateByExample(@Param("record") TbOrders record, @Param("example") TbOrdersExample example);

    int updateByPrimaryKeySelective(TbOrders record);

    int updateByPrimaryKey(TbOrders record);
}