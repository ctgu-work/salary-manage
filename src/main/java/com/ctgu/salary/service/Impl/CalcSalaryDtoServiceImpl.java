package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.CalcSalaryDtoDao;
import com.ctgu.salary.dto.CalcSalaryDto;
import com.ctgu.salary.service.CalcSalaryDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: salary *
 * @classname: CalcSalaryDtoServiceImpl *
 * @author: lnback *
 * @create: 2020-08-13 14:07
 **/
@Service
public class CalcSalaryDtoServiceImpl implements CalcSalaryDtoService {


    @Autowired
    private CalcSalaryDtoDao calcSalaryDtoDao;

    @Override
    public List<CalcSalaryDto> selectByStaffNameAndCalcItemName(String staffName, String calcItemName) {
        return calcSalaryDtoDao.selectByStaffNameAndCalcItemName(staffName,calcItemName);
    }

    @Override
    public List<CalcSalaryDto> selectByStaffName(String staffName) {
        return calcSalaryDtoDao.selectByStaffName(staffName);
    }

    @Override
    public List<CalcSalaryDto> selectByCalcItemName(String calcItemName) {
        return calcSalaryDtoDao.selectByCalcItemName(calcItemName);
    }

    @Override
    public List<CalcSalaryDto> selectAll() {
        return calcSalaryDtoDao.selectAll();
    }

    @Override
    public int deleteCalcSalary(Integer calcSalaryId) {
        return deleteCalcSalary(calcSalaryId);
    }
}
