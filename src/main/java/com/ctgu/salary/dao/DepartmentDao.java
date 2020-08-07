package com.ctgu.salary.dao;

import com.ctgu.salary.dto.DepartmentDto;
import com.ctgu.salary.dto.DepartmentName;
import com.ctgu.salary.po.Department;
import com.ctgu.salary.po.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 10:32
 * @ClassName DepartmentDao
 * @Version 1.0.0
 */
@Mapper
public interface DepartmentDao {
    int addDepartment(Department department);
    int updateDepartment(Department department);
    int delDepartmentById(Integer id);
    List<DepartmentName> findAllDepartmentName();
    List<DepartmentDto> findDepartmentByNameLike(String departName);
    DepartmentDto findDepartmentByName(String departName);
    DepartmentDto findDepartmentById(Integer id);
    List<DepartmentDto> findAllDepartment();
    List<Staff> findStaffsByDepartID(Integer departId);
}
