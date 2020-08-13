package com.ctgu.salary.dao;

import com.ctgu.salary.dto.CalcSalaryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: salary *
 * @classname: CalcSalaryDtoDao *
 * @author: lnback *
 * @create: 2020-08-13 14:06
 **/
@Mapper
@Repository
public interface CalcSalaryDtoDao {
    List<CalcSalaryDto> selectByStaffNameAndCalcItemName(@Param("staffName") String staffName,
                                                         @Param("calcItemName") String calcItemName);
    List<CalcSalaryDto> selectByStaffName(@Param("staffName") String staffName);

    List<CalcSalaryDto> selectByCalcItemName(@Param("calcItemName") String calcItemName);

    List<CalcSalaryDto> selectAll();

    int deleteCalcSalary(@Param("calcSalaryId") Integer calcSalaryId);

}
