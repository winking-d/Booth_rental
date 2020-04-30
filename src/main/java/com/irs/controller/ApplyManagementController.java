package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.service.ApplyService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("apply/")
public class ApplyManagementController {
    @Autowired
    private ApplyService applyServiceImpl;

    @RequestMapping("applyShopList")
    @RequiresPermissions("apply:apply:shopList")
    public String applyShop() {
        return "page/apply/applyShopList";
    }

    @RequestMapping("applyListTenant")
    @RequiresPermissions("apply:apply:applyList")
    public String applyListTenant() {
        return "page/apply/applyListTenant";
    }

    @RequestMapping("applyListStaff")
    @RequiresPermissions("apply:apply:applyList")
    public String applyListStaff() {
        return "page/apply/applyListStaff";
    }
    /**
     * 申请商铺
     *
     * @param id
     * @return
     */
    @SysLog("申请商铺")
    @RequestMapping("apply/{id}")
    @RequiresPermissions("apply:apply:apply")
    @ResponseBody
    public ResultUtil applyShopByid(@PathVariable(value = "id") String id) {
        try {
            applyServiceImpl.apply(id);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    /**
     * 当前登陆用户申请列表
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("getAppliesByUser")
    @RequiresPermissions("apply:apply:applyList")
    @ResponseBody
    public ResultUtil getApplyListTenant(Integer page, Integer limit) {
        return applyServiceImpl.selapplysByUser(page, limit);
    }

    public ResultUtil getApplyListStaff(Integer page, Integer limit, Map<String,Object> search){
        return applyServiceImpl.selApplies(page, limit,search);
    }
}
