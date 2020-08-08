package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.DepartmentDao;
import com.ctgu.salary.dto.DepartmentDto;
import com.ctgu.salary.dto.DepartmentName;
import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Department;
import com.ctgu.salary.po.Staff;
import com.ctgu.salary.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 10:32
 * @ClassName DepartmentServiceImpl
 * @Version 1.0.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    protected DepartmentDao departmentDao;

    @Override
    public int addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    @Override
    public int delDepartmentById(Integer id) {
        return departmentDao.delDepartmentById(id);
    }

    @Override
    public DepartmentDto findDepartmentById(Integer id) {
        return departmentDao.findDepartmentById(id);
    }

    @Override
    public List<DepartmentName> findAllDepartmentName() {
        return departmentDao.findAllDepartmentName();
    }

    @Override
    public DepartmentDto findDepartmentByName(String departName) {
        return departmentDao.findDepartmentByName(departName);
    }

    @Override
    public List<DepartmentDto> findDepartmentByNameLike(String departName) {
        return departmentDao.findDepartmentByNameLike(departName);
    }

    @Override
    public List<DepartmentDto> findAllDepartment() {
        return departmentDao.findAllDepartment();
    }

    @Override
    public List<StaffDto> findStaffsByDepartID(Integer departId) {
        return departmentDao.findStaffsByDepartID(departId);
    }
}
