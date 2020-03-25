package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.ShopSearch;
import com.irs.pojo.TbShops;
import com.irs.service.ShopService;
import com.irs.service.UserService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("shop/")
public class ShopManagementController {
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private ShopService shopServiceImpl;

    @RequestMapping("addShop")
    @RequiresPermissions("user:user:save")
    public String shopAdd() {
        return "page/shop/addShop";
    }

    @RequestMapping("shopList")
    @RequiresPermissions("shop:shop:list")
    public String shopList() {
        return "page/shop/shopList";
    }

    @RequestMapping("checkShopByNumber")
    @ResponseBody
    public ResultUtil checkShopNumber(String number) {
        TbShops shops = shopServiceImpl.selShopByNumber(number);
        if (shops != null) {
            return new ResultUtil(500, "商铺已存在，请重新填写！");
        }
        return new ResultUtil(0);
    }

    /**
     * 添加商铺
     *
     * @param shops
     * @return
     */
    @SysLog(value = "添加商铺")
    @RequestMapping("insShop")
    @RequiresPermissions("shop:shop:save")
    @ResponseBody
    public ResultUtil insShop(TbShops shops) {
        //防止浏览器提交
        TbShops s1 = shopServiceImpl.selShopByNumber(shops.getShopNumber());
        if (s1 != null) {
            return new ResultUtil(500, "商铺已存在，请重新填写！");
        }
        try {
            shopServiceImpl.insShopService(shops);
            return ResultUtil.ok();
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResultUtil(502, "系统发生错误，请再次尝试！");
        }
    }

    /**
     * 查找商铺
     *
     * @param page
     * @param limit
     * @param search
     * @return
     */
    @RequestMapping("getShopList")
    @RequiresPermissions("shop:shop:list")
    @ResponseBody
    public ResultUtil getShopList(Integer page, Integer limit, ShopSearch search) {
        return shopServiceImpl.selShops(page, limit, search);
    }

    /**
     * 批量删除用户
     *
     * @param shopStr
     * @return
     */
    @SysLog(value = "批量删除用户")
    @RequestMapping("delShops/{shopStr}")
    @RequiresPermissions("shop:shop:delete")
    @ResponseBody
    public ResultUtil delUsers(@PathVariable(value = "shopStr") String shopStr) {
        try {
            shopServiceImpl.delShopsService(shopStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    /**
     * 根据ID删除商铺
     *
     * @param id
     * @return
     */
    @SysLog(value = "根据ID删除商铺")
    @RequestMapping("delShopById/{id}")
    @RequiresPermissions("shop:shop:delete")
    @ResponseBody
    public ResultUtil delShopByid(@PathVariable(value = "id") String id) {
        try {
            shopServiceImpl.delShopByid(Integer.parseInt(id));
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    /**
     * 根据ID查找商铺
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("editShop/{id}")
    @RequiresPermissions("shop:shop:save")
    public String editUser(@PathVariable(value = "id") String id, Model model) {
        TbShops shop = shopServiceImpl.selShopByid(Integer.parseInt(id));
        model.addAttribute("shop", shop);
        return "page/shop/editShop";
    }

    /**
     * 更新用户信息
     *
     * @param shop
     * @return
     */
    @SysLog(value = "更新商铺信息")
    @RequestMapping("updShop")
    @RequiresPermissions("shop:shop:update")
    @ResponseBody
    public ResultUtil updShop(TbShops shop) {
        try {
            shopServiceImpl.updShopService(shop);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

}
