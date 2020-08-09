package com.ctgu.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description 统一返回格式
 * @Author wh_lan
 * @create 2020-08-06 9:43
 * @ClassName ResultBody
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBody {
    private String msg;
    private String statusCode;
    private Object result;
}
