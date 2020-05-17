package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbOrdersMapper;
import com.irs.mapper.TbShopsMapper;
import com.irs.pojo.*;
import com.irs.service.OrderService;
import com.irs.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TbOrdersMapper tbOrdersMapper;
    @Autowired
    private TbShopsMapper tbShopsMapper;

    /**
     * 获取订单列表
     *
     * @param page
     * @param limit
     * @param search
     * @return
     */
    @Override
    public ResultUtil getOrderList(Integer page, Integer limit, OrderSearch search) {
        PageHelper.startPage(page, limit);
        TbOrdersExample example = new TbOrdersExample();
        example.setOrderByClause("start_time ASC");
        TbOrdersExample.Criteria criteria = example.createCriteria();
        if(search.getShopNumber()!=null&&!"".equals(search.getShopNumber())){
            criteria.andShopNumberLike("%"+search.getShopNumber()+"%");
        }
        if(search.getOrderState()!=null&&!search.getOrderState().equals("")){
            criteria.andOrderStateEqualTo(search.getOrderState());
        }
        if(search.getDateTime()!=null&&!"".equals(search.getDateTime())){
            String startTime = search.getDateTime().substring(0,10);
            String endTime = search.getDateTime().substring(13);
            criteria.andEndTimeBetween(startTime,endTime);
        }
        List<TbOrders> list = tbOrdersMapper.selectByExample(example);
        PageInfo<TbOrders> pageInfo = new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    /**
     * 获取用户订单列表
     *
     * @param page
     * @param limit
     * @param search
     * @return
     */
    @Override
    public ResultUtil getOrderListTenant(Integer page, Integer limit, OrderSearch search) {
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        PageHelper.startPage(page, limit);
        TbOrdersExample example = new TbOrdersExample();
        example.setOrderByClause("start_time ASC");
        TbOrdersExample.Criteria criteria = example.createCriteria();
        if(search.getShopNumber()!=null&&!"".equals(search.getShopNumber())){
            criteria.andShopNumberLike("%"+search.getShopNumber()+"%");
        }
        if(search.getOrderState()!=null&&!search.getOrderState().equals("")){
            criteria.andOrderStateEqualTo(search.getOrderState());
        }
        if(search.getDateTime()!=null&&!"".equals(search.getDateTime())){
            String startTime = search.getDateTime().substring(0,10);
            String endTime = search.getDateTime().substring(13);
            criteria.andEndTimeBetween(startTime,endTime);
        }
        criteria.andUserIdEqualTo(admin.getId().toString());
        List<TbOrders> list = tbOrdersMapper.selectByExample(example);
        PageInfo<TbOrders> pageInfo = new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    /**
     * 更新订单状态
     */
    @Override
    public void updateState() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = df.format(new Date());
        TbOrders orders = new TbOrders();
        orders.setOrderState("1");
        TbOrdersExample example = new TbOrdersExample();
        TbOrdersExample.Criteria criteria = example.createCriteria();
        criteria.andEndTimeLessThan(nowDate);
        List<TbOrders> tbOrders = tbOrdersMapper.selectByExample(example);
        tbOrdersMapper.updateByExampleSelective(orders,example);
        if(tbOrders.size()>0){
            TbShops shops = new TbShops();
            shops.setShopState("0");
            for (TbOrders tbOrder : tbOrders){
                shops.setId(tbOrder.getShopId());
                tbShopsMapper.updateState(shops);
            }
        }

    }

}
