package com.ctgu.salary.service;

import com.ctgu.salary.dto.ReportDto;
import com.ctgu.salary.dto.WageDto;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-12 17:12
 * @ClassName ReportService
 * @Version 1.0.0
 */
public interface ReportService {
    List<WageDto> findAllReportWage();
    List<ReportDto> findAllFormulaCal();
}
