package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.ReportDao;
import com.ctgu.salary.dto.ReportDto;
import com.ctgu.salary.dto.WageDto;
import com.ctgu.salary.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-12 17:13
 * @ClassName ReportServiceImpl
 * @Version 1.0.0
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportDao reportDao;

    @Override
    public List<WageDto> findAllReportWage() {
        return reportDao.findAllReportWage();
    }

    @Override
    public List<ReportDto> findAllFormulaCal() {
        return reportDao.findAllFormulaCal();
    }
}
