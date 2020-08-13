package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.IndexDao;
import com.ctgu.salary.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-13 19:41
 * @ClassName IndexServiceImpl
 * @Version 1.0.0
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Resource
    private IndexDao indexDao;

    @Override
    public int getStaffNum() {
        return indexDao.getStaffNum();
    }

    @Override
    public int getDepartNum() {
        return indexDao.getDepartNum();
    }

    @Override
    public int getPositionNum() {
        return indexDao.getPositionNum();
    }

    @Override
    public List<Map<Integer, String>> departLateDay() {
        return indexDao.departLateDay();
    }
}
