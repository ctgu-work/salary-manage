package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.dto.SalaryDto;
import com.ctgu.salary.service.SalaryDtoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.List;

/**
 * @program: salary *
 * @classname: SalaryDtoController *
 * @author: lnback *
 * @create: 2020-08-13 20:00
 **/
@RestController
@RequestMapping("/salary")
public class SalaryDtoController {

    @Autowired
    private SalaryDtoService salaryDtoService;


    @GetMapping("/getSalary")
    public ResultBody getSalary(@RequestParam("departId") Integer departId,
                                @RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage,pageSize);

        List<SalaryDto> list = salaryDtoService.getSalaryList(departId);

        PageInfo<SalaryDto> pageInfo = new PageInfo<>(list);

        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        resultBody.setResult(pageInfo);
        return resultBody;
    }

    @GetMapping("/updateSalaryStatus")
    public ResultBody updateSalaryStatus(@RequestParam("status") Integer status,
                                         @RequestParam("wageId") Integer wageId) {
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");
        resultBody.setMsg("success");
        resultBody.setResult(null);
        salaryDtoService.updateWageStatus(status,wageId);

        return resultBody;
    }
}
