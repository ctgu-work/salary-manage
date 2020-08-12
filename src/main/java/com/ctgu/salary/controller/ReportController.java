package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-12 15:54
 * @ClassName ReportController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    @RequestMapping(value = "/list" , method = RequestMethod.GET )
    public ResultBody allStaffs(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage, pageSize);
//        List<StaffDto> staffList = staffService.findAllStaff();
//        PageInfo<StaffDto> staffs = new PageInfo<>(staffList);
//        resultBody.setResult(staffs);
//        resultBody.setMsg("success");
//        resultBody.setStatusCode("200");
        return resultBody;
    }
}
