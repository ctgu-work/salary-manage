package com.ctgu.salary.controller;

import com.ctgu.salary.dto.DepartmentDto;
import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.Department;
import com.ctgu.salary.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET )
    public ResultBody findDepartment(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage, pageSize);
        try{
            List<DepartmentDto> departments = departmentService.findAllDepartment();
            resultBody.setMsg("success");
            resultBody.setStatusCode("200");
            PageInfo<DepartmentDto> departmentPage = new PageInfo<>(departments);;
            resultBody.setObject(departmentPage);
        }
        catch (Exception e){
            resultBody.setMsg("error");
            resultBody.setStatusCode("500");
        }
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 增加部门
     * @Date 2020/8/6 11:47
     * @Param [department]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/add" , method = RequestMethod.POST )
    public ResultBody addOneDepartment(@RequestBody(required = false) Department department){
        ResultBody resultBody = new ResultBody();

        //查找
        int result = departmentService.addDepartment(department);
        if( result == 0 ){
            resultBody.setMsg("add error");
            resultBody.setStatusCode("500");
        }
        else{
            resultBody.setMsg("add success");
            resultBody.setStatusCode("200");
        }
        resultBody.setObject(department);
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 修改部门
     * @Date 2020/8/6 11:47
     * @Param [department]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/update" , method = RequestMethod.POST )
    public ResultBody updateOneDepartment(@RequestBody(required = false) Department department){
        ResultBody resultBody = new ResultBody();

        int result = departmentService.updateDepartment(department);
        if( result == 1 ){
            resultBody.setMsg("update success");
            resultBody.setStatusCode("200");
        }
        else{
            resultBody.setMsg("update error");
            resultBody.setStatusCode("500");
        }

        resultBody.setObject(department);
        return resultBody;
    }


    @RequestMapping(value = "/del" , method = RequestMethod.POST )
    public ResultBody delDepartById(){
        ResultBody resultBody = new ResultBody();
        return resultBody;
    }

}








