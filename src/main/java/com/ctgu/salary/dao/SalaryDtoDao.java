package com.ctgu.salary.dao;

import com.ctgu.salary.dto.SalaryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: salary *
 * @classname: SalaryDtoDao *
 * @author: lnback *
 * @create: 2020-08-13 20:02
 **/
@Mapper
@Repository
public interface SalaryDtoDao {
    List<SalaryDto> selectAll(@Param("departId") Integer departId);
    List<Double> selectCalcSalary(@Param("staffId") Integer staffId);
    int updateWageStatus(@Param("status") Integer status,
                     @Param("wageId") Integer wageId);
}
