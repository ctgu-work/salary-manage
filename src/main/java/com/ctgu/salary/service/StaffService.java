package com.ctgu.salary.service;

import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Staff;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 11:08
 * @ClassName StaffService
 * @Version 1.0.0
 */
public interface StaffService {
    StaffDto findStaffDetail(Integer staffId);
    List<StaffDto> findAllStaff();
    int updateStaffAvatar(String avatar);
    int delStaffById(Integer staffId);
    int updateStaff(Staff staff);
    StaffDto findStaffByIdCard(String idCard);
    int addStaff(Staff staff);
}
