package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.TbShops;
import com.irs.pojo.TbUsers;
import com.irs.pojo.UserSearch;
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
    public String shopAdd(){
        return "page/shop/addShop";
    }

    @RequestMapping("shopList")
    @RequiresPermissions("shop:shop:list")
    public String userList(){
        return "page/shop/shopList";
    }

    @RequestMapping("checkShopByNumber")
    @ResponseBody
    public  ResultUtil checkShopNumber(String number){
        TbShops shops = shopServiceImpl.selShopByNumber(number);
        if(shops!=null){
            return  new ResultUtil(500,"商铺已存在，请重新填写！");
        }
        return new ResultUtil(0);
    }

    @SysLog(value="添加商铺")
    @RequestMapping("insShop")
    @RequiresPermissions("shop:shop:save")
    @ResponseBody
    public ResultUtil insUser(TbShops shops){
        //防止浏览器提交
        TbShops s1= shopServiceImpl.selShopByNumber(shops.getShopNumber());
        if(s1!=null){
            return new ResultUtil(500,"商铺已存在，请重新填写！");
        }
        try {
            shopServiceImpl.insShopService(shops);
            return ResultUtil.ok();
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResultUtil(502,"系统发生错误，请再次尝试！");
        }
    }

    @RequestMapping("getUserList")
    @RequiresPermissions("user:user:list")
    @ResponseBody
    public ResultUtil getUserList(Integer page, Integer limit, UserSearch search){
        return userServiceImpl.selUsers(page,limit,search);
    }

    /**
     * 批量删除用户
     * @param userStr
     * @return
     */
    @SysLog(value="批量删除用户")
    @RequestMapping("delUsers/{userStr}")
    @RequiresPermissions("user:user:delete")
    @ResponseBody
    public ResultUtil delUsers(@PathVariable("userStr")String userStr){
        try {
            userServiceImpl.delUsersService(userStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    /**
     * 根据ID删除用户
     * @param uid
     * @return
     */
    @SysLog(value="根据ID删除用户")
    @RequestMapping("delUserByUid/{uid}")
    @RequiresPermissions("user:user:delete")
    @ResponseBody
    public ResultUtil delUserByUid(@PathVariable("uid")String uid){
        try {
            userServiceImpl.delUserByUid(uid);;
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @RequestMapping("editUser/{uid}")
    @RequiresPermissions("user:user:save")
    public String editUser(@PathVariable("uid")String uid, Model model){
        TbUsers user=userServiceImpl.selUserByUid(Long.parseLong(uid));
        model.addAttribute("user", user);
        return "page/user/editUser";
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @SysLog(value="更新用户信息")
    @RequestMapping("updUser")
    @RequiresPermissions("user:user:update")
    @ResponseBody
    public ResultUtil updUser(TbUsers user){
        try {
            userServiceImpl.updUserService(user);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

}
