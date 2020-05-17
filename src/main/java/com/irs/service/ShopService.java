package com.irs.service;

import com.irs.pojo.ShopSearch;
import com.irs.pojo.TbShops;
import com.irs.util.ResultUtil;

public interface ShopService {

    /**
     * 商铺号唯一性检验
     *
     * @param shopNumber
     * @return
     */
    public TbShops selShopByNumber(String shopNumber);

    /**
     * 增加用户
     *
     * @param shop
     */
    public void insShopService(TbShops shop);

    /**
     * 得到商铺信息
     *
     * @param page
     * @param limit
     * @param search
     * @return
     */
    public ResultUtil selShops(Integer page, Integer limit, ShopSearch search);

    /**
     * 根据id删除商铺
     *
     * @param id
     */
    public void delShopByid(Integer id);

    /**
     * 批量删除商铺
     *
     * @param shopStr
     */
    public void delShopsService(String shopStr);

    /**
     * 根据id查询商铺
     *
     * @param id
     * @return
     */
    public TbShops selShopByid(Integer id);

    /**
     * 更新商铺信息
     *
     * @param shop
     */
    public void updShopService(TbShops shop);

    /**
     * 命名商铺
     *
     * @param shop
     */
    public void updateShopName(TbShops shop);
}
