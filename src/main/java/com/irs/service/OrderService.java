package com.irs.service;

import com.irs.pojo.OrderSearch;
import com.irs.util.ResultUtil;

public interface OrderService {
    /**
     * 获取订单列表
     *
     * @param page
     * @param limit
     * @param search
     * @return
     */
    public ResultUtil getOrderList(Integer page, Integer limit, OrderSearch search);

    /**
     * 获取订单列表
     *
     * @param page
     * @param limit
     * @param search
     * @return
     */
    public ResultUtil getOrderListTenant(Integer page, Integer limit, OrderSearch search);

    /**
     * 更新订单状态
     */
    public void updateState();
}
