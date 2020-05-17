package com.irs.controller;

import com.irs.service.ApplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("show/")
public class showController {

    @Autowired
    private ApplyService applyService;

    @RequestMapping("/showList")
    @RequiresPermissions("show:show:show")
    public String showList() {
        return "page/show/showList";
    }


    @RequestMapping("infoStatis")
    @RequiresPermissions("show:show:show")
    @ResponseBody
    public Map<String, Integer> infoStatis() {
        return applyService.infoStatis();
    }

    @RequestMapping("dataShow")
    @RequiresPermissions("show:show:show")
    @ResponseBody
    public Map<String, Object> dataShow() {
        return applyService.dataShow();
    }


}
