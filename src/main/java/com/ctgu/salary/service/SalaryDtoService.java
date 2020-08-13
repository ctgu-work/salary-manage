package com.ctgu.salary.service;

import com.ctgu.salary.dto.SalaryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: salary *
 * @classname: SalaryDtoService *
 * @author: lnback *
 * @create: 2020-08-13 20:02
 **/

public interface SalaryDtoService {
    List<SalaryDto> getSalaryList(Integer departId);
    int updateWageStatus(Integer status,
                         @Param("wageId") Integer wageId);
}
