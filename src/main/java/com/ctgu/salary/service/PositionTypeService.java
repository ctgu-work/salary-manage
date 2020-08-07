package com.ctgu.salary.service;

import com.ctgu.salary.po.PositionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 16:06
 * @ClassName PositionTypeService
 * @Version 1.0.0
 */
public interface PositionTypeService {
    List<PositionType> findAllPositionType();
    int delPositionTypeById(Integer id);
    int addPositionType(String type);
    PositionType findOnePositionType(String type);
    int updatePositionType(@Param("positionTypeId") Integer positionTypeId, @Param("type") String type);
}
