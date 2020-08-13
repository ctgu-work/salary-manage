package com.ctgu.salary.service;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-13 19:41
 * @ClassName IndexService
 * @Version 1.0.0
 */
public interface IndexService {
    int getStaffNum();
    int getDepartNum();
    int getPositionNum();
    List<Map<Integer, String>> departLateDay();
}
