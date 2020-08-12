package com.ctgu.salary.controller;

import com.ctgu.salary.dto.FixedSalaryDto;
import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.FixedSalary;
import com.ctgu.salary.service.FixedSalaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        PageInfo<FixedSalaryDto> listOnePage = new PageInfo<>();
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("查询成功！");
        resultBody.setStatusCode("200");
        resultBody.setResult(listOnePage);
        return resultBody;
    }




    @PostMapping("/update")
    public ResultBody updateFixedSalary(@RequestBody(required = false) FixedSalary fixedSalary){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");
        if(fixedSalary == null){
            resultBody.setResult(null);
            resultBody.setMsg("待修改对象为空，不能修改！");
            return resultBody;
        }
        fixedSalaryService.updateFixedSalary(fixedSalary);
        return resultBody;
    }
}
