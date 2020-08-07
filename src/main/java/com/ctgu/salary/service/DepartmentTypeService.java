package com.ctgu.salary.service;

import com.ctgu.salary.po.DepartmentType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 15:11
 * @ClassName DepartmentTypeService
 * @Version 1.0.0
 */
public interface DepartmentTypeService {
    List<DepartmentType> findAllDepartmentType();
    int delDepartTypeById(Integer id);
    int addDepartType(String type);
    DepartmentType findOneDepartmentType(String type);
    int updateDepartType(Integer departTypeId, String type);
}
