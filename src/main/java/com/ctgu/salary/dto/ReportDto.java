package com.ctgu.salary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-13 13:39
 * @ClassName ReportDto
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private String calcItemName;
    private Integer calcItemId;
    private Integer formulaId;
    private String formulaName;
    private Double formulaPercentage;
    private Integer calcSalaryId;
}
