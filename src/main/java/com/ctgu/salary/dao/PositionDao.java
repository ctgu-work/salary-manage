package com.ctgu.salary.dao;

import com.ctgu.salary.dto.PositionDto;
import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Position;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 16:06
 * @ClassName PositionDao
 * @Version 1.0.0
 */
@Mapper
public interface PositionDao {
    List<PositionDto> findAllPosition();
    PositionDto findPositionById(Integer id);
    List<PositionDto> findPositionByNameLike(String positionName);
    List<PositionDto> findPositionByTypeLike(String type);
    PositionDto findPositionByName(String positionName);
    List<StaffDto> findStaffsByPositionId(Integer positionId);
    int delPositionById( Integer positionId );
    int updatePosition(Position position);
    int addPosition(Position position);
    List<PositionDto> findPositionByDepartId(Integer departId);
}
