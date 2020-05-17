package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.ApplyMapper;
import com.irs.mapper.TbApplyMapper;
import com.irs.mapper.TbOrdersMapper;
import com.irs.mapper.TbShopsMapper;
import com.irs.pojo.*;
import com.irs.service.ApplyService;
import com.irs.service.ShopService;
import com.irs.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ShopService shopServiceImpl;
    @Autowired
    private TbApplyMapper tbApplyMapper;
    @Autowired
    private TbOrdersMapper tbOrdersMapper;
    @Autowired
    private TbShopsMapper tbShopsMapper;
    @Autowired
    private ApplyMapper applyMapper;

    /**
     * 申请商铺
     *
     * @param id
     */
    @Override
    public void apply(String id) {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        TbShops shop = shopServiceImpl.selShopByid(Integer.parseInt(id));
        TbApply apply = new TbApply();
        apply.setUserid(String.valueOf(admin.getId()));
        apply.setShopid(shop.getId());
        apply.setShopnumber(shop.getShopNumber());
        apply.setUsername(admin.getUsername());
        apply.setPhone(admin.getPhone());
        apply.setCreattime(df.format(new Date()));
        apply.setState("0");
        tbApplyMapper.insert(apply);
    }

    /**
     * 获取当前登陆用户的申请列表
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public ResultUtil selapplysByUser(Integer page, Integer limit) {
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        PageHelper.startPage(page, limit);
        TbApplyExample example = new TbApplyExample();
        example.setOrderByClause("creatTime ASC");
        TbApplyExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(admin.getId().toString());
        List<TbApply> applies = tbApplyMapper.selectByExample(example);
        PageInfo<TbApply> pageInfo = new PageInfo<>(applies);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    /**
     * 获取申请列表
     *
     * @param page
     * @param limit
     * @param search
     * @return
     */
    @Override
    public ResultUtil selApplies(Integer page, Integer limit, ApplySearch search) {
        PageHelper.startPage(page, limit);
        TbApplyExample example = new TbApplyExample();
        example.setOrderByClause("shopNumber ASC");
        TbApplyExample.Criteria criteria = example.createCriteria();

        if (search.getShopNumber() != null && !"".equals(search.getShopNumber())) {
            criteria.andShopnumberLike("%" + search.getShopNumber() + "%");
        }
        if (search.getUserName() != null && !"".equals(search.getUserName())) {
            criteria.andUsernameLike("%" + search.getUserName() + "%");
        }
        if (search.getApplyState() != null && !"".equals(search.getApplyState())) {
            criteria.andStateEqualTo(search.getApplyState());
        }
        List<TbApply> list = tbApplyMapper.selectByExample(example);
        PageInfo<TbApply> pageInfo = new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    /**
     * 判断是否已申请过该商铺
     *
     * @param id
     * @return
     */
    @Override
    public boolean isRepeat(String id) {
        TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
        TbApplyExample example = new TbApplyExample();
        TbApplyExample.Criteria criteria = example.createCriteria();
        criteria.andShopidEqualTo(Integer.parseInt(id));
        criteria.andUseridEqualTo(admin.getId().toString());
        List<TbApply> list = tbApplyMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 审批通过该申请
     *
     * @param id
     * @return
     */
    @Override
    public boolean passApply(String id) {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //通过该申请，并关闭此商铺的其他申请
            TbApply apply = tbApplyMapper.selectByPrimaryKey(Integer.valueOf(id));
            apply.setState("1");
            tbApplyMapper.updateByPrimaryKey(apply);
            applyMapper.closeApplies(Integer.valueOf(id), apply.getShopid());
            //创建新的订单
            TbOrders orders = new TbOrders();
            orders.setUserId(apply.getUserid());
            orders.setShopId(apply.getShopid());
            orders.setShopNumber(apply.getShopnumber());
            orders.setStartTime(df.format(new Date()));
            //获取订单结束的时间
            Calendar curr = Calendar.getInstance();
            curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + 1);
            Date date = curr.getTime();
            orders.setEndTime(df.format(date));
            TbShops shop = tbShopsMapper.selectByPrimaryKey(apply.getShopid());
            //修改商铺状态为已出组
            shop.setShopState("1");
            tbShopsMapper.updateByPrimaryKey(shop);
            //获取租金数额
            orders.setPayRent(Double.parseDouble(shop.getShopRent()));
            orders.setOrderState("0");
            tbOrdersMapper.insert(orders);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 统计信息
     *
     * @return
     */
    @Override
    public Map<String, Integer> infoStatis() {
        Map<String, Integer> map = new HashMap<>();
        map.put("applyCount", applyMapper.selApplyCount());
        map.put("orderingCount", applyMapper.selOrderingCount());
        map.put("orderedCount", applyMapper.selOrderedCount());
        map.put("income", applyMapper.selIncome());
        return map;
    }

    /**
     * 展示数据
     *
     * @return
     */
    @Override
    public Map<String, Object> dataShow() {
        List<Map<String, Object>> list1 = applyMapper.selTypeCount1();
        List<Map<String, Object>> list2 = applyMapper.selTypeCount2();
        List<Map<String, Object>> list3 = applyMapper.selTypeCount3();
        String[] type = {"服饰", "餐饮", "影院", "电玩", "超市"};
        int[] shopCount = new int[5];
        int[] applyCount = new int[5];
        int[] orderCount = new int[5];
        Double[] income = new Double[5];
        for (int i = 0; i < 5; i++) {
            shopCount[i] = Integer.parseInt(list1.get(i).get("count").toString());
            applyCount[i] = Integer.parseInt(list2.get(i).get("count").toString());
            orderCount[i] = Integer.parseInt(list3.get(i).get("count").toString());
            if (list3.get(i).get("sum") == null || "".equals(list3.get(i).get("sum"))) {
                income[i] = 0.0;
                continue;
            }
            income[i] = Double.parseDouble(list3.get(i).get("sum").toString());
        }
        Map<String, Object> json = new HashMap<>();
        json.put("type", type);
        json.put("shopCount", shopCount);
        json.put("applyCount", applyCount);
        json.put("orderCount", orderCount);
        json.put("income", income);
        return json;
    }


}
