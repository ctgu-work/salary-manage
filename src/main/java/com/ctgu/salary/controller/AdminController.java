package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.Admin;
import com.ctgu.salary.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping("/login")
    public ResultBody adminLogin(Admin admin){
        ResultBody resultBody = new ResultBody();
        if(admin == null){
            resultBody.setMsg("用户名密码为空！");
            resultBody.setStatusCode("500");
            resultBody.setResult(null);
            return resultBody;
        }
        Admin result = adminService.adminLogin(admin);
        if(result != null){
            resultBody.setResult(result);
            resultBody.setStatusCode("200");
            resultBody.setMsg("登录成功");
        }else {
            resultBody.setMsg("用户名或密码错误！");
            resultBody.setStatusCode("500");
            resultBody.setResult(admin);
        }
        return resultBody;

    }
}
