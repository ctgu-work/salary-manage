package com.ctgu.salary.controller;

import com.ctgu.salary.dto.CalcSalaryDto;
import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.service.CalcSalaryDtoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: salary *
 * @classname: CalcSalaryDtoController *
 * @author: lnback *
 * @create: 2020-08-13 14:08
 **/
@RestController
@RequestMapping("/calcSalary")
public class CalcSalaryDtoController {

    @Autowired
    CalcSalaryDtoService salaryDtoService;


    @GetMapping("/getByStaffNameOrCalcItemName")
    public ResultBody getByStaffName(@RequestParam(value = "staffName",required = false,defaultValue = "") String staffName,
                                     @RequestParam(value = "calcItemName",required = false,defaultValue = "") String calcItemName,
                                     @RequestParam(value = "startPage",required = false,defaultValue = "1") Integer startPage,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage,pageSize);
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        if(staffName.equals("")&& calcItemName.equals("")){
            List<CalcSalaryDto> list = salaryDtoService.selectAll();
            PageInfo<CalcSalaryDto> pageInfo = new PageInfo<>(list);
            resultBody.setResult(pageInfo);
            return resultBody;
        }
        if(staffName.equals("") && !calcItemName.equals("")){
            List<CalcSalaryDto> list = salaryDtoService.selectByCalcItemName(calcItemName);
            PageInfo<CalcSalaryDto> pageInfo = new PageInfo<>(list);
            resultBody.setResult(pageInfo);
            return resultBody;
        }
        if(!staffName.equals("") && calcItemName.equals("")){
            List<CalcSalaryDto> list = salaryDtoService.selectByStaffName(staffName);
            PageInfo<CalcSalaryDto> pageInfo = new PageInfo<>(list);
            resultBody.setResult(pageInfo);
            return resultBody;
        }
        if(!staffName.equals("") && !calcItemName.equals("")){
            List<CalcSalaryDto> list = salaryDtoService.selectByStaffNameAndCalcItemName(staffName,calcItemName);
            PageInfo<CalcSalaryDto> pageInfo = new PageInfo<>(list);
            resultBody.setResult(pageInfo);
            return resultBody;
        }
        return  resultBody;
    }


    @GetMapping("/deleteCalcSalary")
    public ResultBody deleteCalcSalary(@RequestParam("calcSalaryId") Integer calcSalaryId){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");
        resultBody.setMsg("success");
        resultBody.setResult(null);
        salaryDtoService.deleteCalcSalary(calcSalaryId);
        return resultBody;
    }

}
