package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.DepartmentDao;
import com.ctgu.salary.dto.DepartmentDto;
import com.ctgu.salary.po.Department;
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
    private DepartmentDao departmentDao;

    @Override
    public int addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    @Override
    public List<DepartmentDto> findAllDepartment() {
        return departmentDao.findAllDepartment();
    }
}
