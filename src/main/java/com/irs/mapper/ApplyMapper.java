package com.irs.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ApplyMapper {
    /**
     * 关闭相关申请
     *
     * @param id
     * @param shopId
     */
    void closeApplies(@Param("id") Integer id, @Param("shopId") Integer shopId);

    //待处理申请数
    int selApplyCount();

    //未完成订单数
    int selOrderingCount();

    //已完成订单数
    int selOrderedCount();

    //总收入金额
    int selIncome();

    //查询各类型商铺数
    List<Map<String,Object>> selTypeCount1();

    //查询各类型申请数
    List<Map<String,Object>> selTypeCount2();

    //查询各类型订单数和成交金额
    List<Map<String,Object>> selTypeCount3();
}
