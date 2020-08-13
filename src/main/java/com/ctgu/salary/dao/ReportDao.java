package com.ctgu.salary.dao;

import com.ctgu.salary.dto.ReportDto;
import com.ctgu.salary.dto.WageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-12 17:12
 * @ClassName ReportDao
 * @Version 1.0.0
 */
@Mapper
public interface ReportDao {
    List<WageDto> findAllReportWage();
    List<ReportDto> findAllFormulaCal();
}
