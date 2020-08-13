package com.ctgu.salary.service;

import com.ctgu.salary.dto.CalcSalaryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: salary *
 * @classname: CalcSalaryDtoService *
 * @author: lnback *
 * @create: 2020-08-13 14:07
 **/

public interface CalcSalaryDtoService {

    List<CalcSalaryDto> selectByStaffNameAndCalcItemName (String staffName,
                                                        String calcItemName);
    List<CalcSalaryDto> selectByStaffName(String staffName);

    List<CalcSalaryDto> selectByCalcItemName(String calcItemName);

    List<CalcSalaryDto> selectAll();

    int deleteCalcSalary( Integer calcSalaryId);
}
