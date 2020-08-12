package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.ReportDao;
import com.ctgu.salary.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

}
