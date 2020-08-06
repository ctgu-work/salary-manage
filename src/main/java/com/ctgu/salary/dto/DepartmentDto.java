package com.ctgu.salary.dto;

import java.sql.Date;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 14:54
 * @ClassName DepartmentDto
 * @Version 1.0.0
 */
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

    public DepartmentDto() {
    }

    public DepartmentDto(Integer departId, String departName, Integer departTypeId, String departPhone, String fax, String description, String type, String fatherDepartName, Integer fatherDepartId, Date establishDate) {
        this.departId = departId;
        this.departName = departName;
        this.departTypeId = departTypeId;
        this.departPhone = departPhone;
        this.fax = fax;
        this.description = description;
        this.type = type;
        this.fatherDepartName = fatherDepartName;
        this.fatherDepartId = fatherDepartId;
        this.establishDate = establishDate;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Integer getDepartTypeId() {
        return departTypeId;
    }

    public void setDepartTypeId(Integer departTypeId) {
        this.departTypeId = departTypeId;
    }

    public String getDepartPhone() {
        return departPhone;
    }

    public void setDepartPhone(String departPhone) {
        this.departPhone = departPhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFatherDepartName() {
        return fatherDepartName;
    }

    public void setFatherDepartName(String fatherDepartName) {
        this.fatherDepartName = fatherDepartName;
    }

    public Integer getFatherDepartId() {
        return fatherDepartId;
    }

    public void setFatherDepartId(Integer fatherDepartId) {
        this.fatherDepartId = fatherDepartId;
    }

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "departId=" + departId +
                ", departName='" + departName + '\'' +
                ", departTypeId=" + departTypeId +
                ", departPhone='" + departPhone + '\'' +
                ", fax='" + fax + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", fatherDepartName='" + fatherDepartName + '\'' +
                ", fatherDepartId=" + fatherDepartId +
                ", establishDate=" + establishDate +
                '}';
    }
}
