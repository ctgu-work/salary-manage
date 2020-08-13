package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.OperateLog;
import com.ctgu.salary.service.IndexService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-13 19:40
 * @ClassName IndexController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    /**
     * @Author wh
     * @Description 员工部门数
     * @Date 2020/8/13 19:59
     * @Param []
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping("/num")
    public ResultBody getNum(){
        List<Map<String,Integer>>nums = new LinkedList<>();
        Map<String,Integer> num = new HashMap<>();
        int staffNum = indexService.getStaffNum();
        int departNum = indexService.getDepartNum();
        int positionNum = indexService.getPositionNum();
        num.put("staff",staffNum);
        num.put("depart",departNum);
        num.put("position",positionNum);
        nums.add(num);
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        resultBody.setResult(nums);
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 各部门迟到总天数
     * @Date 2020/8/13 20:08
     * @Param []
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping("/late")
    public ResultBody lateDay(){
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        List<Map<Integer, String>> departLateDay = indexService.departLateDay();
        resultBody.setResult(departLateDay);
        return resultBody;
    }
}
