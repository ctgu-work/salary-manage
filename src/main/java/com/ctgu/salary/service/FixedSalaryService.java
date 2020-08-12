package com.ctgu.salary.service;

import com.ctgu.salary.dto.FixedSalaryDto;
import com.ctgu.salary.po.FixedSalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: salary *
 * @classname: FixdeSalaryService *
 * @author: lnback *
 * @create: 2020-08-09 13:40
 **/

public interface FixedSalaryService {


    List<FixedSalaryDto> getAllFixedSalary();
    FixedSalaryDto selectAllFixedSalaryByDepartIdAndStaffId(Integer departId,Integer staffId);
    List<FixedSalaryDto> selectAllFixedSalaryByDepartId(Integer departId);
    void updateByDepartId(FixedSalaryDto fixedSalaryDto);

    List<FixedSalaryDto> selectFixedSalaryByDepartIdAndSection(Integer departId,Integer left,Integer right);
}
