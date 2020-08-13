package com.ctgu.salary.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-13 19:40
 * @ClassName IndexDao
 * @Version 1.0.0
 */
@Mapper
public interface IndexDao {
    int getStaffNum();
    int getDepartNum();
    int getPositionNum();
    List<Map<Integer, String>> departLateDay();
}
