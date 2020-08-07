package com.ctgu.salary.service;

import com.ctgu.salary.dto.StaffDto;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 11:08
 * @ClassName StaffService
 * @Version 1.0.0
 */
public interface StaffService {
    StaffDto findStaffDetail(Integer staffId);
}
