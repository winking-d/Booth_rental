package com.irs.service.impl;

import com.irs.mapper.TbShopsMapper;
import com.irs.pojo.TbShops;
import com.irs.pojo.TbShopsExample;
import com.irs.service.ShopService;
import com.irs.util.EmailUtil;
import com.irs.util.GlobalUtil;
import com.irs.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private TbShopsMapper tbShopsMapper;
    @Override
    public TbShops selShopByNumber(String shopNumber) {
        TbShopsExample example = new TbShopsExample();
        TbShopsExample.Criteria criteria = example.createCriteria();
        criteria.andShopNumberEqualTo(shopNumber);
        List<TbShops> shops = tbShopsMapper.selectByExample(example);
        if(shops!=null&&shops.size()>0){
            return shops.get(0);
        }
        return null;
    }

    @Override
    public void insShopService(TbShops shop) throws Exception {
        shop.setShopState("0");
        tbShopsMapper.insert(shop);
    }
}
