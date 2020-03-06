package com.irs.controller;

import com.irs.pojo.TbAdmin;
import com.irs.service.AdminService;
import com.irs.util.ResultUtil;
import com.irs.util.ShiroUtils;
import io.swagger.annotations.Api;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/* *
 * 功能描述  公共接口  注意：login不需要鉴权，成功后返回：JSESSIONID
 *                           其他需要鉴权的请求url：http://localhost:8088/api/user/1;JSESSIONID=72e1eb77-69d7-40e1-844a-fa9181b88a81
 * @author duxiaod
 * @date 2019/4/11
 * @param
 * @return
 */
@Api(value = "公共接口", description = "公共接口")
@RestController
@RequestMapping(value = "api/")
public class ApiController extends BaseController{

    @Autowired
    private AdminService adminServiceImpl;

    @PostMapping(value = "login")
    public ResultUtil login(@RequestParam(required = true) String username, @RequestParam(required = true) String password){
        Subject subject = ShiroUtils.getSubject();
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        }catch (UnknownAccountException e) {
            return ResultUtil.error(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return ResultUtil.error(e.getMessage());
        }catch (LockedAccountException e) {
            return ResultUtil.error(e.getMessage());
        }catch (AuthenticationException e) {
            return ResultUtil.error("账户验证失败");
        }
        Session session = subject.getSession();
        logger.info("JSESSIONID:"+session.getId());
        Map<String,Object> map = new HashMap<>();
        map.put("JSESSIONID",session.getId());
        return ResultUtil.ok(map);
    }

    @GetMapping(value = "user/{id}")
    public ResultUtil getUser(@PathVariable(value = "id") Long id){
        TbAdmin admin= adminServiceImpl.selAdminById(id);
        return ResultUtil.ok(admin);
    }
}
