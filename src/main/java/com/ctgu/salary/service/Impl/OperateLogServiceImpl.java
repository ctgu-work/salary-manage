package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.OperateLogDao;
import com.ctgu.salary.po.OperateLog;
import com.ctgu.salary.service.OperateLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-11 21:00
 * @ClassName OperateLogServiceImpl
 * @Version 1.0.0
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Resource
    private OperateLogDao operateLogDao;

    @Override
    public int addOperateLog(OperateLog operateLog) {
        return operateLogDao.addOperateLog(operateLog);
    }

    @Override
    public List<OperateLog> findAllOperateLog() {
        return operateLogDao.findAllOperateLog();
    }
}
