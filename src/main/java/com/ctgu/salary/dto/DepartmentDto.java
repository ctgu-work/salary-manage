package com.ctgu.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 14:54
 * @ClassName DepartmentDto
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Integer departId;
    private String departName;
    private Integer departTypeId;
    private String departPhone;
    private String fax;
    private String description;
    private String type;
    private String fatherDepartName;
    private Integer fatherDepartId;
    private Date establishDate;

}
