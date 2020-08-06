package com.ctgu.salary.po;

/**
 * @Description 部门类型
 * @Author wh_lan
 * @create 2020-08-06 15:04
 * @ClassName DepartmentType
 * @Version 1.0.0
 */
public class DepartmentType {
    private Integer departTypeId;
    private String type;

    public DepartmentType(Integer departTypeId, String type) {
        this.departTypeId = departTypeId;
        this.type = type;
    }

    public DepartmentType() {
    }

    public Integer getDepartTypeId() {
        return departTypeId;
    }

    public void setDepartTypeId(Integer departTypeId) {
        this.departTypeId = departTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DepartmentType{" +
                "departTypeId=" + departTypeId +
                ", type='" + type + '\'' +
                '}';
    }
}
