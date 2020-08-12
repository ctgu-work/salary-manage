package com.ctgu.salary.service;

import com.ctgu.salary.dto.FixedSalaryDto;
import com.ctgu.salary.po.FixedSalary;

import java.util.List;

/**
 * @program: salary *
 * @classname: FixdeSalaryService *
 * @author: lnback *
 * @create: 2020-08-09 13:40
 **/

public interface FixedSalaryService {
    List<FixedSalaryDto> getAllFixedSalary();

    int updateFixedSalary(FixedSalary fixedSalary);
}
