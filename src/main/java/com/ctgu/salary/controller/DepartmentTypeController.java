package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.DepartmentType;
import com.ctgu.salary.service.DepartmentTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 15:20
 * @ClassName DepartmentTypeController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/detpye")
public class DepartmentTypeController {
    private final DepartmentTypeService departmentTypeService;

    @Autowired
    public DepartmentTypeController(DepartmentTypeService departmentTypeService) {
        this.departmentTypeService = departmentTypeService;
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET )
    public ResultBody findDepartmentType(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage, pageSize);
        try{
            List<DepartmentType> departmentTypes = departmentTypeService.findAllDepartmentType();
            resultBody.setMsg("success");
            resultBody.setStatusCode("200");
            PageInfo<DepartmentType> departmentPage = new PageInfo<>(departmentTypes);;
            resultBody.setResult(departmentPage);
        }
        catch (Exception e){
            System.out.println(e);
            resultBody.setMsg("error");
            resultBody.setStatusCode("500");
        }
        return resultBody;
    }
}






