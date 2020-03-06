package com.irs.service;

import com.irs.pojo.TbShops;

public interface ShopService {
    //商铺号唯一性检验
    public TbShops selShopByNumber(String shopNumber);

    //增加用户
    public void insShopService(TbShops shop) throws Exception;
}
