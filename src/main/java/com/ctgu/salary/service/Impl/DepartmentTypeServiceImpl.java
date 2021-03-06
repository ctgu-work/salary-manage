package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.DepartmentTypeDao;
import com.ctgu.salary.po.DepartmentType;
import com.ctgu.salary.service.DepartmentTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 15:11
 * @ClassName DepartmentTypeServiceImpl
 * @Version 1.0.0
 */
@Service
public class DepartmentTypeServiceImpl implements DepartmentTypeService {
    @Resource
    private DepartmentTypeDao departmentTypeDao;

    @Override
    public List<DepartmentType> findAllDepartmentType() {
        return departmentTypeDao.findAllDepartmentType();
    }

    @Override
    public int delDepartTypeById(Integer id) {
        return departmentTypeDao.delDepartTypeById(id);
    }

    @Override
    public int addDepartType(String type) {
        return departmentTypeDao.addDepartType(type);
    }

    @Override
    public DepartmentType findOneDepartmentType(String type) {
        return departmentTypeDao.findOneDepartmentType(type);
    }

    @Override
    public int updateDepartType(Integer departTypeId, String type) {
        return departmentTypeDao.updateDepartType(departTypeId,type);
    }
}
