package com.ctgu.salary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-12 23:56
 * @ClassName WageDto
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WageDto {
    private Integer departId;
    private Integer staffId;
    private String departName;
    private String staffName;
    private Integer sickday;
    private Integer sickMoney;
    private Double basicSalary;
    private Double subsidy;
    private Integer affairday;
    private Integer affairMoney;
    private Integer lateday;
    private Integer calcSalaryId;
    private Integer lateMoney;
    private Integer overday;
    private Integer overMoney;
    private Double reissue;
    private Integer wageId;
    private Integer status;
    private Double totalSalary;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp updateTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp createTime;
    private Integer rpMoney;
    List<ReportDto> formulaCal;
}


