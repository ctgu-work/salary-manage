package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
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

    ResultBody resultBody = new ResultBody();

    @RequestMapping(value = "/del" , method = RequestMethod.POST )
    public ResultBody delDepartById(){
        return resultBody;
    }

}








