package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.RewardPunish;
import com.ctgu.salary.service.RewardPunishService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @program: salary *
 * @classname: RewardPunishController *
 * @author: lnback *
 * @create: 2020-08-12 20:58
 **/
@RestController
@RequestMapping("/rewardPunish")
public class RewardPunishController {

    @Autowired
    RewardPunishService rewardPunishService;

    /**
     *
     * @param rewardPunish
     * @param startPage
     * @param pageSize
     * @return
     */
    @PostMapping("/getRewardPunish")
    public ResultBody getRewardPunish(RewardPunish rewardPunish,
                                      @RequestParam(value = "startPage",required = false,defaultValue = "1") Integer startPage,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){
            ResultBody resultBody = new ResultBody();
            resultBody.setStatusCode("200");
        System.out.println(rewardPunish);
        PageHelper.startPage(startPage,pageSize);
        List<RewardPunish> list = rewardPunishService.selectAll(rewardPunish);
        PageInfo<RewardPunish> pageInfo = new  PageInfo<>(list);
        resultBody.setMsg("success");
        resultBody.setResult(pageInfo);
        return resultBody;
    }


    @GetMapping("/deleteRewardPunish")
    public ResultBody deleteRewardPunish(@RequestParam("rewardPunishId") Integer rewardPunishId ){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");

        rewardPunishService.deleteRewardPunish(rewardPunishId);
        resultBody.setMsg("success");
        resultBody.setResult(null);
        return resultBody;
    }


    @PostMapping("/updateRewardPunish")
    public ResultBody updateRewardPunish(RewardPunish rewardPunish){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");
        rewardPunishService.updateRewardPunish(rewardPunish);
        resultBody.setMsg("success");
        resultBody.setResult(null);
        return resultBody;
    }

    @PostMapping("/addRewardPunish")
    public ResultBody addRewardPunish(@RequestBody List<RewardPunish> list){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");
        rewardPunishService.addRewardPunish(list);
        resultBody.setMsg("success");
        resultBody.setResult(null);
        return resultBody;
    }

}
