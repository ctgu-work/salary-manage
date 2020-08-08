package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.StaffDao;
import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Staff;
import com.ctgu.salary.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<StaffDto> findAllStaff() {
        return staffDao.findAllStaff();
    }

    @Override
    public int updateStaffAvatar(String avatar) {
        return staffDao.updateStaffAvatar(avatar);
    }

    @Override
    public int delStaffById(Integer staffId) {
        return staffDao.delStaffById(staffId);
    }

    @Override
    public int updateStaff(Staff staff) {
        return staffDao.updateStaff(staff);
    }

    @Override
    public StaffDto findStaffByIdCard(String idCard) {
        return staffDao.findStaffByIdCard(idCard);
    }

    @Override
    public int addStaff(Staff staff) {
        return staffDao.addStaff(staff);
    }
}
