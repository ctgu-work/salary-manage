package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 11:06
 * @ClassName StaffController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }


    /**
     * @Author wh
     * @Description 员工详情
     * @Date 2020/8/7 12:01
     * @Param [staffId]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/detail" , method = RequestMethod.GET )
    public ResultBody staffDetail(@RequestParam("staffId")Integer staffId){
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        StaffDto staffDto = staffService.findStaffDetail(staffId);
        resultBody.setResult(staffDto);
        return resultBody;
    }

}










