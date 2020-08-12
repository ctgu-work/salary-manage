package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.PositionType;
import com.ctgu.salary.service.PositionTypeService;
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
 * @create 2020-08-07 16:05
 * @ClassName PositionTypeController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/position-type")
public class PositionTypeController {
    private final PositionTypeService positionTypeService;
    @Autowired
    public PositionTypeController(PositionTypeService positionTypeService) {
        this.positionTypeService = positionTypeService;
    }

    /**
     * @Author wh
     * @Description 全部岗位类型
     * @Date 2020/8/7 16:39
     * @Param [startPage, pageSize]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/list" , method = RequestMethod.GET )
    public ResultBody findPositionType(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        List<PositionType> positionTypes = positionTypeService.findAllPositionType();
        PageHelper.startPage(startPage, pageSize);
        PageInfo<PositionType> positionTypePage = new PageInfo<>(positionTypes);;
        resultBody.setResult(positionTypePage);
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 增加岗位类型
     * @Date 2020/8/7 15:25
     * @Param [type]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/add" , method = RequestMethod.POST )
    public ResultBody addOnePositionType(@RequestParam("type") String type){
        ResultBody resultBody = new ResultBody();
        if( positionTypeService.findOnePositionType(type) == null ){
            int id = positionTypeService.addPositionType(type);
            resultBody.setMsg("success");
            resultBody.setStatusCode("200");
            PositionType positionType = positionTypeService.findOnePositionType(type);
            resultBody.setResult(positionType);
        }
        else{
            resultBody.setMsg("已经存在");
            resultBody.setStatusCode("200");
        }
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 修改岗位类型
     * @Date 2020/8/7 16:01
     * @Param [departTypeId, type]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/update" , method = RequestMethod.POST )
    public ResultBody updateOnePositionType(@RequestParam("positionTypeId")Integer positionTypeId,
                                              @RequestParam("type")String type){
        positionTypeService.updatePositionType(positionTypeId,type);
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        PositionType positionType = positionTypeService.findOnePositionType(type);
        resultBody.setResult(positionType);
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 删除岗位类型通过ID
     * @Date 2020/8/7 12:12
     * @Param [id]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/del" , method = RequestMethod.GET )
    public ResultBody delOnePositionType(@RequestParam("id")Integer id){
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        positionTypeService.delPositionTypeById(id);
        return resultBody;
    }
}










