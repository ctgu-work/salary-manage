package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.Admin;
import com.ctgu.salary.service.AdminService;
import com.ctgu.salary.utils.JwtUtils;
import com.ctgu.salary.utils.Md5Salt;
import com.ctgu.salary.utils.RedisUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.MalformedInputException;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

    @PostMapping("/login")
    public ResultBody adminLogin(@RequestParam("username") String username,
                                 @RequestParam("password") String password){


        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");
        System.out.println(username);
        Admin admin = adminService.findByUsername(username);
        System.out.println(admin);
        if(admin == null){
            resultBody.setResult(null);
            //该用户不存在
            resultBody.setMsg("success");
            return resultBody;
        }
        String key = Md5Salt.Md5Crypt(password);
        if(key.equals(admin.getPassword())){
            if(redisUtils.hasKey(username)){
                redisUtils.del(username);
            }
            String token = JwtUtils.sign(username,password);
            redisUtils.set(username,token,10*60);
            redisUtils.set(token,username,10*60);
            resultBody.setMsg("success");
            Map<String,String> map = new LinkedHashMap<>();
            map.put("Token",token);
            map.put("username",username);
            resultBody.setResult(map);
        }else {
            resultBody.setResult(null);
            resultBody.setMsg("success");
        }
        return resultBody;
    }



    @RequiresAuthentication
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
            resultBody.setMsg("success");
        }else {
            resultBody.setResult(null);
            resultBody.setStatusCode("500");
            resultBody.setMsg("success");
        }
        return resultBody;
    }

    @RequestMapping("/test")
    public String gettest(){
//        Subject subject = SecurityUtils.getSubject();
//        if(subject.isAuthenticated()){
//            return "ok";
//        }else {
//            return "no";
//        }
        return "shahuhu";
    }
}
