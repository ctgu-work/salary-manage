package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.FixedSalaryDao;
import com.ctgu.salary.dto.FixedSalaryDto;
import com.ctgu.salary.po.FixedSalary;
import com.ctgu.salary.service.FixedSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: salary *
 * @classname: FixdeSalaryServiceImpl *
 * @author: lnback *
 * @create: 2020-08-09 13:41
 **/
@Service
public class FixedSalaryServiceImpl implements FixedSalaryService {

    @Autowired
    private FixedSalaryDao fixedSalaryDao;

    @Override
    public List<FixedSalaryDto> getAllFixedSalary() {
        return fixedSalaryDao.selectAllFixedSalary();
    }

    @Override
    public FixedSalaryDto selectAllFixedSalaryByDepartIdAndStaffId(Integer departId, Integer staffId) {
        return fixedSalaryDao.selectAllFixedSalaryByDepartIdAndStaffId(departId,staffId);
    }

    @Override
    public List<FixedSalaryDto> selectAllFixedSalaryByDepartId(Integer departId) {
        return fixedSalaryDao.selectAllFixedSalaryByDepartId(departId);
    }

    @Override
    public void updateByDepartId(FixedSalaryDto fixedSalaryDto) {
        fixedSalaryDao.updateByDepartId(fixedSalaryDto);
    }


}
