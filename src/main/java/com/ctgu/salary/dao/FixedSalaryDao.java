package com.ctgu.salary.dao;

import com.ctgu.salary.dto.FixedSalaryDto;
import org.apache.ibatis.annotations.Mapper;
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
}
