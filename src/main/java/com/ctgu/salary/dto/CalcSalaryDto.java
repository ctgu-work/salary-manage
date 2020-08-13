package com.ctgu.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: salary *
 * @classname: CalcSalaryDto *
 * @author: lnback *
 * @create: 2020-08-13 13:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalcSalaryDto {
    //    计算项目工资id，员工id，员工名字，计算条目id，计算条目名，公式id，公式名，公式百分比
    private Integer staffId;
    private String staffName;
    private Integer calcSalaryId;
    private Integer calcItemId;
    private String calcItemName;
    private Integer formulaId;
    private String formulaName;
    private Double formulaPercentage;
}
