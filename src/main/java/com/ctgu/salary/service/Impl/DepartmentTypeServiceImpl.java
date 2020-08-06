package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.DepartmentTypeDao;
import com.ctgu.salary.service.DepartmentTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
