package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbShopsMapper;
import com.irs.pojo.ShopSearch;
import com.irs.pojo.TbShops;
import com.irs.pojo.TbShopsExample;
import com.irs.service.ShopService;
import com.irs.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private TbShopsMapper tbShopsMapper;

    /**
     * 根据商铺号查找商铺
     *
     * @param shopNumber
     * @return
     */
    @Override
    public TbShops selShopByNumber(String shopNumber) {
        TbShopsExample example = new TbShopsExample();
        TbShopsExample.Criteria criteria = example.createCriteria();
        criteria.andShopNumberEqualTo(shopNumber);
        List<TbShops> shops = tbShopsMapper.selectByExample(example);
        if (shops != null && shops.size() > 0) {
            return shops.get(0);
        }
        return null;
    }

    /**
     * 添加商铺
     *
     * @param shop
     * @throws Exception
     */
    @Override
    public void insShopService(TbShops shop) {
        shop.setShopState("0");
        tbShopsMapper.insert(shop);
    }

    /**
     * 查找商铺
     *
     * @param page
     * @param limit
     * @param search
     * @return
     */
    @Override
    public ResultUtil selShops(Integer page, Integer limit, ShopSearch search) {
        Double sizeMin = 0.0;
        Double sizeMax = 99999.9;

        PageHelper.startPage(page, limit);
        TbShopsExample example = new TbShopsExample();
        //按商铺号排序=
        example.setOrderByClause("shop_number ASC");
        TbShopsExample.Criteria criteria = example.createCriteria();

        if (search.getShopNumber() != null && !"".equals(search.getShopNumber())) {
            criteria.andShopNumberLike("%" + search.getShopNumber() + "%");
        }
        if (search.getShopType() != null && !"".equals(search.getShopType())) {
            criteria.andShopTypeEqualTo(search.getShopType());
        }
        if (search.getShopState() != null && !"".equals(search.getShopState())) {
            criteria.andShopStateEqualTo(search.getShopState());
        }
        if (search.getShopSizeMin() != null && !"".equals(search.getShopSizeMin())) {
            sizeMin = Double.parseDouble(search.getShopSizeMin());
        }
        if (search.getShopSizeMax() != null && !"".equals(search.getShopSizeMax())) {
            sizeMax = Double.parseDouble(search.getShopSizeMax());
        }
        criteria.andShopSizeBetween(sizeMin, sizeMax);
        List<TbShops> shops = tbShopsMapper.selectByExample(example);
        PageInfo<TbShops> pageInfo = new PageInfo<>(shops);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    /**
     * 根据id删除商铺
     *
     * @param id
     */
    @Override
    public void delShopByid(Integer id) {
        tbShopsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除商铺
     *
     * @param shopStr
     */
    @Override
    public void delShopsService(String shopStr) {
        String[] shops = shopStr.split(",");
        if (shops.length > 0) {
            for (String id : shops) {
                tbShopsMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    /**
     * 根据id查询商铺
     *
     * @param id
     * @return
     */
    @Override
    public TbShops selShopByid(Integer id) {
        TbShops shop = tbShopsMapper.selectByPrimaryKey(id);
        return shop;
    }

    /**
     * 更新商铺信息
     *
     * @param shop
     */
    @Override
    public void updShopService(TbShops shop) {
        tbShopsMapper.updateByPrimaryKey(shop);
    }

    /**
     * 命名商铺
     *
     * @param shop
     */
    @Override
    public void updateShopName(TbShops shop) {
        tbShopsMapper.updateByPrimaryKeySelective(shop);
    }

}
