package com.ctgu.salary.controller;

import com.ctgu.salary.dto.DepartmentName;
import com.ctgu.salary.dto.PositionDto;
import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Position;
import com.ctgu.salary.po.PositionType;
import com.ctgu.salary.service.DepartmentService;
import com.ctgu.salary.service.PositionService;
import com.ctgu.salary.service.PositionTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 16:04
 * @ClassName PositionController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;
    private final DepartmentService departmentService;
    private final PositionTypeService positionTypeService;

    @Autowired
    public PositionController(PositionService positionService, DepartmentService departmentService,
                              PositionTypeService positionTypeService) {
        this.positionService = positionService;
        this.departmentService = departmentService;
        this.positionTypeService = positionTypeService;
    }

    /**
     * @return com.ctgu.salary.dto.ResultBody
     * @Author wh
     * @Description 查询全部
     * @Date 2020/8/7 19:18
     * @Param [startPage, pageSize]
     **/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultBody findPosition(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage, pageSize);
        List<PositionDto> positions = positionService.findAllPosition();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        PageInfo<PositionDto> positionsPage = new PageInfo<>(positions);
        resultBody.setResult(positionsPage);
        return resultBody;
    }


    /**
     * @return com.ctgu.salary.dto.ResultBody
     * @Author wh
     * @Description 增加时全部部门名字
     * @Date 2020/8/7 19:31
     * @Param []
     **/
    @RequestMapping(value = "/name-list", method = RequestMethod.GET)
    public ResultBody findAllDepartmentName() {
        ResultBody resultBody = new ResultBody();
        List<DepartmentName> departmentNames = departmentService.findAllDepartmentName();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        resultBody.setResult(departmentNames);
        return resultBody;
    }


    /**
     * @return com.ctgu.salary.dto.ResultBody
     * @Author wh
     * @Description 增加时全部岗位类型
     * @Date 2020/8/7 19:32
     * @Param []
     **/
    @RequestMapping(value = "/type-list", method = RequestMethod.GET)
    public ResultBody findAllPositionType() {
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        List<PositionType> positionTypes = positionTypeService.findAllPositionType();
        resultBody.setResult(positionTypes);
        return resultBody;
    }



    /**
     * @Author wh
     * @Description 增加员工
     * @Date 2020/8/8 12:53
     * @Param [position]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/add" , method = RequestMethod.POST )
    public ResultBody addOnePosition(@RequestBody(required = false) Position position){
        ResultBody resultBody = new ResultBody();
        if( positionService.findPositionByName(position.getPositionName()) == null ){
            positionService.addPosition(position);
            resultBody.setMsg("success");
            resultBody.setStatusCode("200");
        }
        else{
            resultBody.setMsg("已经存在");
            resultBody.setStatusCode("302");
        }
        resultBody.setResult(position);
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 修改岗位
     * @Date 2020/8/8 12:11
     * @Param [position]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/update" , method = RequestMethod.POST )
    public ResultBody updateOnePosition(@RequestBody(required = false) Position position){
        ResultBody resultBody = new ResultBody();
        positionService.updatePosition(position);
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        PositionDto updatePosition = positionService.findPositionById(position.getDepartId());
        resultBody.setResult(updatePosition);
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 删除岗位
     * @Date 2020/8/8 12:01
     * @Param [positionId]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/del" , method = RequestMethod.GET )
    public ResultBody delOnePositionById(@RequestParam("positionId") Integer positionId){
        ResultBody resultBody = new ResultBody();
        positionService.delPositionById(positionId);
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        return resultBody;
    }

    /**
     * @return com.ctgu.salary.dto.ResultBody
     * @Author wh
     * @Description 通过Id查找
     * @Date 2020/8/8 11:15
     * @Param [id]
     **/
    @RequestMapping(value = "/find-id", method = RequestMethod.GET)
    public ResultBody findDepartById(@RequestParam("id") Integer id) {
        ResultBody resultBody = new ResultBody();
        PositionDto positionDto = positionService.findPositionById(id);
        resultBody.setStatusCode("200");
        resultBody.setMsg("success");
        resultBody.setResult(positionDto);
        return resultBody;
    }

    /**
     * @return com.ctgu.salary.dto.ResultBody
     * @Author wh
     * @Description 通过名称查找
     * @Date 2020/8/8 11:26
     * @Param [startPage, pageSize, positionName]
     **/
    @RequestMapping(value = "/find-name", method = RequestMethod.GET)
    public ResultBody findDepartByName(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                       @RequestParam("positionName") String positionName) {
        ResultBody resultBody = new ResultBody();
        if (positionName.equals("")) return resultBody;
        List<PositionDto> positionDtos = positionService.findPositionByNameLike(positionName);
        PageHelper.startPage(startPage, pageSize);
        PageInfo<PositionDto> positionDtoPageInfo = new PageInfo<>(positionDtos);
        resultBody.setResult(positionDtoPageInfo);
        resultBody.setStatusCode("200");
        resultBody.setMsg("success");
        return resultBody;
    }

    /**
     * @return com.ctgu.salary.dto.ResultBody
     * @Author wh
     * @Description 通过类型查找
     * @Date 2020/8/8 11:52
     * @Param [startPage, pageSize, type]
     **/
    @RequestMapping(value = "/find-type", method = RequestMethod.GET)
    public ResultBody findDepartByType(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                       @RequestParam("type") String type) {
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");
        resultBody.setMsg("success");
        if( type.equals("") ) return resultBody;
        List<PositionDto> positions = positionService.findPositionByTypeLike(type);
        PageHelper.startPage(startPage, pageSize);
        PageInfo<PositionDto> positionPage = new PageInfo<>(positions);
        resultBody.setResult(positionPage);
        return resultBody;
    }

    /**
     * @return com.ctgu.salary.dto.ResultBody
     * @Author wh
     * @Description 查询岗位下员工
     * @Date 2020/8/8 11:43
     * @Param [startPage, pageSize, positionName]
     **/
    @RequestMapping(value = "/find-staff", method = RequestMethod.GET)
    public ResultBody findStaffsByDepartId( @RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                            @RequestParam("positionName") String positionName) {
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage, pageSize);
        if (positionService.findPositionByName(positionName) != null) {
            PositionDto position = positionService.findPositionByName(positionName);
            List<StaffDto> staffs = positionService.findStaffsByPositionId(position.getPositionId());
            PageInfo<StaffDto> staffsPage = new PageInfo<>(staffs);
            resultBody.setResult(staffsPage);
            resultBody.setStatusCode("200");
            resultBody.setMsg("success");
        } else {
            resultBody.setStatusCode("200");
            resultBody.setMsg("查找为空");
        }
        return resultBody;
    }


}












