package com.ctgu.salary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @program: salary *
 * @classname: SalaryDto *
 * @author: lnback *
 * @create: 2020-08-13 19:37
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {
    //员工编号，员工姓名，部门名称，固定工资，计算项目工资，导入项目工资，总工资，创建时间，是否结算
    private Integer wageId;
    private Integer staffId;
    private String staffName;
    private Integer departId;
    private String departName;
    private Integer fixedSalary;
    private double calcSalary;
    private Integer rewardPunishSalary;
    private double totalSalary;
    private Integer status;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp createTime;
}
