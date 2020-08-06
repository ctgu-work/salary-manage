package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 部门
 * @Author wh_lan
 * @create 2020-08-06 9:45
 * @ClassName DepartmentController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/depart")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @RequestMapping(value = "/test" , method = RequestMethod.GET )
    public ResultBody test(){
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        return resultBody;
    }

    @RequestMapping(value = "/del" , method = RequestMethod.POST )
    public ResultBody delDepartById(){
        ResultBody resultBody = new ResultBody();
        return resultBody;
    }

}








