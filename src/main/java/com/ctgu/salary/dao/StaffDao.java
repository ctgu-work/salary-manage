package com.ctgu.salary.dao;

import com.ctgu.salary.dto.StaffDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 11:07
 * @ClassName StaffDao
 * @Version 1.0.0
 */
@Mapper
public interface StaffDao {
    StaffDto findStaffDetail(Integer staffId);
}
