package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.PositionTypeDao;
import com.ctgu.salary.po.PositionType;
import com.ctgu.salary.service.PositionTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 16:08
 * @ClassName PositionTypeServiceImpl
 * @Version 1.0.0
 */
@Service
public class PositionTypeServiceImpl implements PositionTypeService {
    @Resource
    private PositionTypeDao positionTypeDao;

    @Override
    public List<PositionType> findAllPositionType() {
        return positionTypeDao.findAllPositionType();
    }

    @Override
    public int delPositionTypeById(Integer id) {
        return positionTypeDao.delPositionTypeById(id);
    }

    @Override
    public int addPositionType(String type) {
        return positionTypeDao.addPositionType(type);
    }

    @Override
    public PositionType findOnePositionType(String type) {
        return positionTypeDao.findOnePositionType(type);
    }

    @Override
    public int updatePositionType(Integer positionTypeId, String type) {
        return positionTypeDao.updatePositionType(positionTypeId,type);
    }
}




