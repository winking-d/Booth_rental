package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.OrderSearch;
import com.irs.pojo.TbShops;
import com.irs.service.OrderService;
import com.irs.service.ShopService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("order/")
@Controller
public class OrderManagementController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShopService shopServiceImpl;

    @RequestMapping("orderList")
    @RequiresPermissions("order:order:list")
    public String orderList() {
        orderService.updateState();
        return "page/order/orderList";
    }

    @RequestMapping("getOrderList")
    @RequiresPermissions("order:order:list")
    @ResponseBody
    public ResultUtil getOrderList(Integer page, Integer limit, OrderSearch search){
        return orderService.getOrderList(page, limit, search);
    }

    @RequestMapping("orderListTenant")
    @RequiresPermissions("order:order:list")
    public String orderListTenant() {
        orderService.updateState();
        return "page/order/orderListTenant";
    }

    @RequestMapping("getOrderListTenant")
    @RequiresPermissions("order:order:list")
    @ResponseBody
    public ResultUtil getOrderListTenant(Integer page, Integer limit, OrderSearch search){
        return orderService.getOrderListTenant(page, limit, search);
    }

    @RequestMapping("updateName/{id}")
    @RequiresPermissions("order:order:update")
    public String updateName(@PathVariable(value = "id") String id, Model model) {
        TbShops shop = shopServiceImpl.selShopByid(Integer.parseInt(id));
        model.addAttribute("shop", shop);
        return "page/order/updateName";
    }

    /**
     * 更新用户信息
     *
     * @param shop
     * @return
     */
    @SysLog(value = "更新商铺信息")
    @RequestMapping("updateShopName")
    @RequiresPermissions("order:order:update")
    @ResponseBody
    public ResultUtil updShop(TbShops shop) {
        try {
            shopServiceImpl.updateShopName(shop);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }
}
