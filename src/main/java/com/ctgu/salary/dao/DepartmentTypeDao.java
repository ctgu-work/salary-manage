package com.ctgu.salary.dao;

import com.ctgu.salary.po.DepartmentType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    int delDepartTypeById(Integer id);
    int addDepartType(String type);
    DepartmentType findOneDepartmentType(String type);
    int updateDepartType(@Param("departTypeId") Integer departTypeId,@Param("type") String type);

}
