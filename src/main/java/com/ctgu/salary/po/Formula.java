package com.ctgu.salary.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: salary *
 * @classname: Formula *
 * @author: lnback *
 * @create: 2020-08-09 13:52
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formula {
    private Integer formulaId;
    private String formulaName;
    private Double formulaPercentage;
}
