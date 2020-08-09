package com.ctgu.salary.service;

import com.ctgu.salary.dto.DepartmentDto;
import com.ctgu.salary.dto.DepartmentName;
import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Department;
import com.ctgu.salary.po.Staff;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 10:32
 * @ClassName DepartmentService
 * @Version 1.0.0
 */
public interface DepartmentService {
    int addDepartment(Department department);
    int updateDepartment(Department department);
    int delDepartmentById(Integer id);
    DepartmentDto findDepartmentById(Integer id);
    List<DepartmentName> findAllDepartmentName();
    DepartmentDto findDepartmentByName(String departName);
    List<DepartmentDto> findDepartmentByNameLike(String departName);
    List<DepartmentDto> findAllDepartment();
    List<StaffDto> findStaffsByDepartID(Integer departId);
}
