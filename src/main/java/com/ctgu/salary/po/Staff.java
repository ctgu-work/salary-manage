package com.ctgu.salary.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 20:00
 * @ClassName Staff
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private Integer staffId;
    private Integer sex;
    private Integer positionId;
    private Integer departmentId;
    private Integer employeeForm;
    private Integer personnelSource;
    private Integer politicalType;
    private Integer nation;
    private Integer maritalType;
    private Integer bloodType;
    private Integer highestEducation;
    private Integer highestDegree;
    private String avatar;
    private String staffName;
    private String idCard;
    private String hometown;
    private String email;
    private String birthLocation;
    private String phoneNumber;
    private String school;
    private String major;
    private Double height;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date graduateTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birth;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date workTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date attWorkTime;
}









