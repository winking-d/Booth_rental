package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbApplyMapper;
import com.irs.pojo.TbAdmin;
import com.irs.pojo.TbApply;
import com.irs.pojo.TbApplyExample;
import com.irs.pojo.TbShops;
import com.irs.service.ApplyService;
import com.irs.service.ShopService;
import com.irs.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ShopService shopServiceImpl;
    @Autowired
    private TbApplyMapper tbApplyMapper;

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
        example.setOrderByClause("creatTime DESC");
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
    public ResultUtil selApplies(Integer page, Integer limit, Map<String, Object> search) {
        PageHelper.startPage(page, limit);
        TbApplyExample example = new TbApplyExample();
        example.setOrderByClause("shopNumber DESC");
        TbApplyExample.Criteria criteria=example.createCriteria();

        if(search.get("shopNumber")!=null&&!"".equals(search.get("shopNumber"))){
            criteria.andShopnumberLike("%"+search.get("shopNumber")+"%");
        }
        if(search.get("userName")!=null&&!"".equals(search.get("userName"))){
            criteria.andUsernameLike("%"+search.get("userName")+"%");
        }
        if(search.get("applyState")!=null&&!"".equals(search.get("applyState"))){
            criteria.andStateEqualTo(search.get("applyState").toString());
        }
        List<TbApply> list=tbApplyMapper.selectByExample(example);
        PageInfo<TbApply> pageInfo=new PageInfo<>();
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }


}
