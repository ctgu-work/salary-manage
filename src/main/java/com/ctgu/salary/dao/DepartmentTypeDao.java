package com.ctgu.salary.dao;

import com.ctgu.salary.po.DepartmentType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 15:06
 * @ClassName DepartmentTypeDao
 * @Version 1.0.0
 */
@Mapper
public interface DepartmentTypeDao {
    List<DepartmentType> findAllDepartmentType();

}
