package com.ctgu.salary.dao;

import com.ctgu.salary.po.OperateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-11 20:59
 * @ClassName OperateLogDao
 * @Version 1.0.0
 */
@Mapper
public interface OperateLogDao {
    int addOperateLog(OperateLog operateLog);
    List<OperateLog> findAllOperateLog();
}
