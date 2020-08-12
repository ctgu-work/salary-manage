package com.ctgu.salary.service;

import com.ctgu.salary.po.OperateLog;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-11 21:00
 * @ClassName OperateLogService
 * @Version 1.0.0
 */
public interface OperateLogService {
    int addOperateLog(OperateLog operateLog);
    List<OperateLog> findAllOperateLog();
}
