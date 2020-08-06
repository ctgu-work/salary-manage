package com.ctgu.salary.service;

import com.ctgu.salary.po.DepartmentType;

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
}
