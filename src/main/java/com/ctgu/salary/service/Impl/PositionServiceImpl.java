package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.PositionDao;
import com.ctgu.salary.dto.PositionDto;
import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Position;
import com.ctgu.salary.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<PositionDto> findAllPosition() {
        return positionDao.findAllPosition();
    }

    @Override
    public PositionDto findPositionById(Integer id) {
        return positionDao.findPositionById(id);
    }

    @Override
    public List<PositionDto> findPositionByNameLike(String positionName) {
        return positionDao.findPositionByNameLike(positionName);
    }

    @Override
    public PositionDto findPositionByName(String positionName) {
        return positionDao.findPositionByName(positionName);
    }

    @Override
    public List<StaffDto> findStaffsByPositionId(Integer positionId) {
        return positionDao.findStaffsByPositionId(positionId);
    }

    @Override
    public List<PositionDto> findPositionByTypeLike(String type) {
        return positionDao.findPositionByTypeLike(type);
    }

    @Override
    public int delPositionById(Integer positionId) {
        return positionDao.delPositionById(positionId);
    }

    @Override
    public int updatePosition(Position position) {
        return positionDao.updatePosition(position);
    }

    @Override
    public int addPosition(Position position) {
        return positionDao.addPosition(position);
    }
}
