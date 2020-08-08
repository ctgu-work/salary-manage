package com.ctgu.salary.service;

import com.ctgu.salary.dto.PositionDto;
import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Position;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 16:07
 * @ClassName PositionService
 * @Version 1.0.0
 */
public interface PositionService {
    List<PositionDto> findAllPosition();
    PositionDto findPositionById(Integer id);
    List<PositionDto> findPositionByNameLike(String positionName);
    PositionDto findPositionByName(String positionName);
    List<StaffDto> findStaffsByPositionId(Integer positionId);
    List<PositionDto> findPositionByTypeLike(String type);
    int delPositionById( Integer positionId );
    int updatePosition(Position position);
    int addPosition(Position position);
    List<PositionDto> findPositionByDepartId(Integer departId);

}
