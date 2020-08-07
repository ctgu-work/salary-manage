package com.ctgu.salary.controller;

import com.ctgu.salary.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 16:04
 * @ClassName PositionController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/position")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }



}












