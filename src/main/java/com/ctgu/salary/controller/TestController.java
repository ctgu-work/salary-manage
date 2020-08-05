package com.ctgu.salary.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-05 10:34
 * @ClassName TestController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/sc")
    public String test(){
        return "yyds";
    }
}
