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
    public int updateFixedSalary(FixedSalary fixedSalary) {
        return 0;
    }
}
