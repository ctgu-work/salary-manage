package com.ctgu.salary.controller;

import com.ctgu.salary.dto.FixedSalaryDto;
import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.Department;
import com.ctgu.salary.po.FixedSalary;
import com.ctgu.salary.service.FixedSalaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.media.jfxmedia.events.NewFrameEvent;
import net.sf.ehcache.store.LfuPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: salary *
 * @classname: FixedSalaryController *
 * @author: lnback *
 * @create: 2020-08-09 13:34
 **/
@RestController
@RequestMapping("/fixedSalary")
public class FixedSalaryController {

    @Autowired
    private FixedSalaryService fixedSalaryService;


    /**
     * 获得所有的固定工资项目（dto）
     * @param startPage
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public ResultBody getAllFixedSalary(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        List<FixedSalaryDto> list = new LinkedList<>();
        PageHelper.startPage(startPage,pageSize);
        list = fixedSalaryService.getAllFixedSalary();
        PageInfo<FixedSalaryDto> listOnePage = new PageInfo<>(list);
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("查询成功！");
        resultBody.setStatusCode("200");
        resultBody.setResult(listOnePage);
        return resultBody;
    }




    @GetMapping("/updateByDepartId")
    public ResultBody updateFixedSalary(@RequestParam("departId") Integer departId,
                                        @RequestParam(value = "basicSalary" ,required = false ,defaultValue = "0") Double basicSalary,
                                        @RequestParam(value = "subsidy",required = false ,defaultValue = "0") Double subsidy){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");
        FixedSalaryDto fixedSalaryDto = new FixedSalaryDto();
        fixedSalaryDto.setBasicSalary(basicSalary);
        fixedSalaryDto.setSubsidy(subsidy);
        fixedSalaryDto.setDepartId(departId);

        fixedSalaryService.updateByDepartId(fixedSalaryDto);

        resultBody.setMsg("修改成功！");
        resultBody.setResult(null);
        return resultBody;

    }


    @GetMapping("/getByDepartId")
    public ResultBody getByDepartId(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                              @RequestParam(value = "departId") Integer departId) {

        List<FixedSalaryDto> list = null;
        PageHelper.startPage(startPage,pageSize);
        list =  fixedSalaryService.selectAllFixedSalaryByDepartId(departId);
        PageInfo<FixedSalaryDto> page = new PageInfo<>(list);
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("查询成功");
        resultBody.setStatusCode("200");
        resultBody.setResult(page);


        return resultBody;
    }

    @GetMapping("/getByDepartIdAndStaffId")
    public ResultBody getByDepartIdAndStaffId(@RequestParam(value = "departId") Integer departId,
                                              @RequestParam("staffId") Integer staffId) {
        FixedSalaryDto fixedSalaryDto = new FixedSalaryDto();

        fixedSalaryDto =  fixedSalaryService.selectAllFixedSalaryByDepartIdAndStaffId(departId,staffId);
        List<FixedSalaryDto> list = new LinkedList<>();
        list.add(fixedSalaryDto);
        ResultBody resultBody = new ResultBody();
        resultBody.setResult(list);
        resultBody.setMsg("查询成功");
        resultBody.setStatusCode("200");

        return resultBody;
    }

    @GetMapping("/getByDepartIdAndSection")
    public ResultBody getByDepartIdAndSection(@RequestParam("depardId") Integer departId,
                                              @RequestParam(value = "left",required = true) Integer left,
                                              @RequestParam(value = "right",required = true) Integer right,
                                              @RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
                                              ){
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage,pageSize);
        List<FixedSalaryDto> list = null;
        list = fixedSalaryService.selectFixedSalaryByDepartIdAndSection(departId,left,right);
        PageInfo<FixedSalaryDto> pegeInfo = new PageInfo<>(list);
        resultBody.setResult(pegeInfo);
        resultBody.setMsg("查询成功");
        resultBody.setStatusCode("200");
        return resultBody;
    }
}
