package com.ctgu.salary.dao;

import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
    List<StaffDto> findAllStaff();
    int updateStaffAvatar(String avatar);
    int delStaffById(Integer staffId);
    int updateStaff(Staff staff);
    List<StaffDto> findStaffByIdCard(String idCard);
    int addStaff(Staff staff);
}
