package com.ctgu.salary.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 9:22
 * @ClassName Department
 * @Version 1.0.0
 */
public class Department {
    private Integer departId;
    private String departName;
    private Integer departTypeId;
    private String departPhone;
    private String fax;
    private String description;
    private Integer fatherDepartId;
    private Date establishDate;

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

    public Department() {
    }

    public Department(Integer departId, String departName, Integer departTypeId, String departPhone, String fax, String description, Integer fatherDepartId, Date establishDate) {
        this.departId = departId;
        this.departName = departName;
        this.departTypeId = departTypeId;
        this.departPhone = departPhone;
        this.fax = fax;
        this.description = description;
        this.fatherDepartId = fatherDepartId;
        this.establishDate = establishDate;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departId=" + departId +
                ", departName='" + departName + '\'' +
                ", departTypeId=" + departTypeId +
                ", departPhone='" + departPhone + '\'' +
                ", fax='" + fax + '\'' +
                ", description='" + description + '\'' +
                ", fatherDepartId=" + fatherDepartId +
                ", establishDate=" + establishDate +
                '}';
    }
}
