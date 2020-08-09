package com.ctgu.salary.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: salary *
 * @classname: FixedSalary *
 * @author: lnback *
 * @create: 2020-08-09 13:25
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FixedSalary {
    private Integer fixedSalaryId;
    private Integer staffId;
    private Integer depId;
    private Double basicSalary;
    private Double subsidy;
    private String remarks;
}
