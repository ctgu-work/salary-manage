package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.Admin;
import com.ctgu.salary.service.AdminService;
import com.ctgu.salary.utils.JwtUtils;
import com.ctgu.salary.utils.Md5Salt;
import com.ctgu.salary.utils.RedisUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.MalformedInputException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: salary *
 * @classname: AdminController *
 * @author: lnback *
 * @create: 2020-08-06 15:27
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/login")
    public ResultBody adminLogin(@RequestParam("username") String username,
                                 @RequestParam("password") String password){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("500");
        resultBody.setMsg("error");


        Admin admin = adminService.findByUsername(username);
        String token = JwtUtils.sign(username, Md5Salt.Md5SaltCrypt(username));
        //密码正确
        if(admin.getPassword().equals(password)){
            /**
             * 1.将token放入redis(未配置) TODO 配置redis
             * 2.设置返回体内容（放一个token和admin）
             */
            redisUtils.set(username,token,60*60);
            resultBody.setMsg("success");
            resultBody.setStatusCode("200");
            Map<String,Object> map = new HashMap<>();
            map.put("Token",token);
            map.put("admin",admin);
            resultBody.setResult(map);
        }
        return resultBody;
    }

    @RequestMapping("/logout")
    public ResultBody adminLogout(HttpServletRequest request){
        String token = request.getHeader("Token");
        Subject subject = SecurityUtils.getSubject();
        String username = JwtUtils.getUsername(token);
        ResultBody resultBody = new ResultBody();
        if(subject.isAuthenticated() && redisUtils.get(username).equals(token)){
            redisUtils.del(username);
            resultBody.setResult(null);
            resultBody.setStatusCode("200");
            resultBody.setMsg("退出成功！");
        }else {
            resultBody.setResult(null);
            resultBody.setStatusCode("500");
            resultBody.setMsg("退出失败，当前没有用户登录！");
        }
        return resultBody;
    }
}
