package com.ctgu.salary.controller;

import com.ctgu.salary.dto.DepartmentDto;
import com.ctgu.salary.dto.DepartmentName;
import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.Department;
import com.ctgu.salary.po.DepartmentType;
import com.ctgu.salary.po.Staff;
import com.ctgu.salary.service.DepartmentService;
import com.ctgu.salary.service.DepartmentTypeService;
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
    private final DepartmentTypeService departmentTypeService;

    @Autowired
    public DepartmentController(DepartmentService departmentService , DepartmentTypeService departmentTypeService) {
        this.departmentService = departmentService;
        this.departmentTypeService = departmentTypeService;
    }

    /**
     * @Author wh
     * @Description 查找全部部门
     * @Date 2020/8/6 16:50
     * @Param [startPage, pageSize]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/list" , method = RequestMethod.GET )
    public ResultBody findDepartment(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage, pageSize);
        List<DepartmentDto> departments = departmentService.findAllDepartment();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        PageInfo<DepartmentDto> departmentPage = new PageInfo<>(departments);
        resultBody.setResult(departmentPage);
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 全部部门名字
     * @Date 2020/8/6 17:05
     * @Param []
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/name-list" , method = RequestMethod.GET )
    public ResultBody findDepartmentName(){
        ResultBody resultBody = new ResultBody();
        List<DepartmentName> departmentNames = departmentService.findAllDepartmentName();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        resultBody.setResult(departmentNames);
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 全部部门类型
     * @Date 2020/8/6 17:15
     * @Param []
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/type-list" , method = RequestMethod.GET )
    public ResultBody findDepartmentTypeName(){
        ResultBody resultBody = new ResultBody();
        List<DepartmentType> departmentTypes = departmentTypeService.findAllDepartmentType();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        resultBody.setResult(departmentTypes);
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

        Department departmentFind = departmentService.findDepartmentByName(department.getDepartName());
        if( departmentFind == null ){
            departmentService.addDepartment(department);
            resultBody.setMsg("success");
            resultBody.setStatusCode("200");
        }
        else{
            resultBody.setMsg("exist");
            resultBody.setStatusCode("302");
        }
        resultBody.setResult(department);
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
        departmentService.updateDepartment(department);
        resultBody.setMsg("update success");
        resultBody.setStatusCode("200");
        Department updateDepartment = departmentService.findDepartmentById(department.getDepartId());
        resultBody.setResult(updateDepartment);
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 删除部门
     * @Date 2020/8/6 19:56
     * @Param [departId]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/del" , method = RequestMethod.POST )
    public ResultBody delDepartById(@RequestParam("departId") Integer departId){
        ResultBody resultBody = new ResultBody();
        departmentService.delDepartmentById(departId);
        resultBody.setMsg("del success");
        resultBody.setStatusCode("200");
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 通过Id查找
     * @Date 2020/8/6 19:58
     * @Param [id]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/find-id" , method = RequestMethod.GET )
    public ResultBody findDepartById(@RequestParam("id") Integer id){
        ResultBody resultBody = new ResultBody();
        Department department = departmentService.findDepartmentById(id);
        resultBody.setStatusCode("200");
        resultBody.setStatusCode("success");
        resultBody.setResult(department);
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 通过名称查找
     * @Date 2020/8/6 19:58
     * @Param [departName]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/find-name" , method = RequestMethod.GET )
    public ResultBody findDepartByName(@RequestParam("departName") String departName){
        ResultBody resultBody = new ResultBody();
        Department department = departmentService.findDepartmentByName(departName);
        resultBody.setResult(department);
        resultBody.setStatusCode("200");
        resultBody.setStatusCode("success");
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 查找部门下的员工
     * @Date 2020/8/6 20:43
     * @Param [departId]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/find-staff" , method = RequestMethod.GET )
    public ResultBody findStaffsByDepartId(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                           @RequestParam("departId") Integer departId){
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage, pageSize);
        List<Staff> staffs = departmentService.findStaffsByDepartID(departId);
        PageInfo<Staff> staffsPage = new PageInfo<>(staffs);
        resultBody.setResult(staffsPage);
        resultBody.setStatusCode("200");
        resultBody.setStatusCode("success");
        return resultBody;
    }
}








