package com.ctgu.salary.dao;

import com.ctgu.salary.dto.FixedSalaryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: salary *
 * @classname: FixedSalaryDao *
 * @author: lnback *
 * @create: 2020-08-09 13:39
 **/
@Mapper
@Repository
public interface FixedSalaryDao {
    List<FixedSalaryDto> selectAllFixedSalary();
    FixedSalaryDto selectAllFixedSalaryByDepartIdAndStaffId(@Param("depart_id") Integer departId, @Param("staff_id") Integer staffId);
    List<FixedSalaryDto> selectAllFixedSalaryByDepartId(@Param("depart_id") Integer departId);
    void updateByDepartId(FixedSalaryDto fixedSalaryDto);
    List<FixedSalaryDto> selectAllFixedSalaryByDepartIdAndSection(@Param("depart_id") Integer departId,@Param("left") Integer left,@Param("right") Integer right);
}
