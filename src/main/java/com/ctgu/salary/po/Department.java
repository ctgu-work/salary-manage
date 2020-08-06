package com.ctgu.salary.po;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 9:22
 * @ClassName Department
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer departId;
    private String departName;
    private Integer departTypeId;
    private String departPhone;
    private String fax;
    private String description;
    private Integer fatherDepartId;
    private Date establishDate;

}
