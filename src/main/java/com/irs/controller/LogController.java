package com.irs.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.irs.annotation.SysLog;
import com.irs.pojo.UserSearch;
import com.irs.service.LogService;
import com.irs.util.ResultUtil;

@Controller
@RequestMapping("log/")
public class LogController {
	
	@Autowired
	private LogService logServiceImpl;
	
	@RequestMapping("logList")
	@RequiresPermissions("log:log:list")
	public String logList(){
		return "page/log/logList";
	}
	
	@RequestMapping("getLogList")
	@RequiresPermissions("log:log:list")
	@ResponseBody
	public ResultUtil getLogList(Integer page, Integer limit,UserSearch search){
		return logServiceImpl.selLogList(page,limit,search);
	}
}
