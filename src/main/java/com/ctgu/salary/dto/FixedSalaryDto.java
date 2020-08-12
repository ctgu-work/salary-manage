package com.ctgu.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: salary *
 * @classname: FixedSalaryDto *
 * @author: lnback *
 * @create: 2020-08-11 14:48
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FixedSalaryDto {
    private Integer fixedSalaryId;
    private Integer staffId;
    private String staffName;
    private String departName;
    private Double basicSalary;
    private Double subsidy;
    private String remarks;
}
