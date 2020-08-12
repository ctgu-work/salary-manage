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
@RequestMapping("/depart-type")
public class DepartmentTypeController {
    private final DepartmentTypeService departmentTypeService;

    @Autowired
    public DepartmentTypeController(DepartmentTypeService departmentTypeService) {
        this.departmentTypeService = departmentTypeService;
    }


    /**
     * @Author wh
     * @Description 部门类型全部
     * @Date 2020/8/7 11:01
     * @Param [startPage, pageSize]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/list" , method = RequestMethod.GET )
    public ResultBody findDepartmentType(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        List<DepartmentType> departmentTypes = departmentTypeService.findAllDepartmentType();
        PageHelper.startPage(startPage, pageSize);
        PageInfo<DepartmentType> departmentPage = new PageInfo<>(departmentTypes);;
        resultBody.setResult(departmentPage);
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 增加部门类型
     * @Date 2020/8/7 15:25
     * @Param [type]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/add" , method = RequestMethod.POST )
    public ResultBody addOneDepartmentType(@RequestParam("type") String type){
        ResultBody resultBody = new ResultBody();
        if( departmentTypeService.findOneDepartmentType(type) == null ){
            int id = departmentTypeService.addDepartType(type);
            resultBody.setMsg("success");
            resultBody.setStatusCode("200");
            DepartmentType departmentType = departmentTypeService.findOneDepartmentType(type);
            resultBody.setResult(departmentType);
        }
        else{
            resultBody.setMsg("已经存在");
            resultBody.setStatusCode("200");
        }
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 修改部门类型
     * @Date 2020/8/7 16:01
     * @Param [departTypeId, type]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/update" , method = RequestMethod.POST )
    public ResultBody updateOneDepartmentType(@RequestParam("departTypeId")Integer departTypeId,
                                              @RequestParam("type")String type){
        departmentTypeService.updateDepartType(departTypeId,type);
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        DepartmentType departmentType = departmentTypeService.findOneDepartmentType(type);
        resultBody.setResult(departmentType);
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 删除部门类型通过ID
     * @Date 2020/8/7 12:12
     * @Param [id]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/del" , method = RequestMethod.GET )
    public ResultBody delOneDepartmentType(@RequestParam("id")Integer id){
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        departmentTypeService.delDepartTypeById(id);
        return resultBody;
    }
}






