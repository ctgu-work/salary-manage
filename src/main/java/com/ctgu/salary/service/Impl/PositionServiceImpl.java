package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.PositionDao;
import com.ctgu.salary.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 16:07
 * @ClassName PositionServiceImpl
 * @Version 1.0.0
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;
}
