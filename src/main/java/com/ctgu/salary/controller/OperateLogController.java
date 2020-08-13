package com.ctgu.salary.controller;

import com.ctgu.salary.dto.DepartmentDto;
import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.OperateLog;
import com.ctgu.salary.service.OperateLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-11 21:34
 * @ClassName OperateLogController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/operate-log")
public class OperateLogController {
    private final OperateLogService operateLogService;

    @Autowired
    public OperateLogController(OperateLogService operateLogService) {
        this.operateLogService = operateLogService;
    }


    /**
     * @Author wh
     * @Description 所有日志
     * @Date 2020/8/13 19:43
     * @Param [startPage, pageSize]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping("/list")
    public ResultBody getAll(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        List<OperateLog> operateLogs = operateLogService.findAllOperateLog();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        PageHelper.startPage(startPage, pageSize);
        PageInfo<OperateLog> operateLogPageInfo = new PageInfo<>(operateLogs);
        resultBody.setResult(operateLogPageInfo);
        return resultBody;
    }

}
