package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.StaffDao;
import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Staff;
import com.ctgu.salary.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 11:09
 * @ClassName StaffServiceImpl
 * @Version 1.0.0
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDao staffDao;

    @Override
    public StaffDto findStaffDetail(Integer staffId) {
        return staffDao.findStaffDetail(staffId);
    }
}
