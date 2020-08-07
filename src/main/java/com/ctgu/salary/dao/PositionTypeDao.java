package com.ctgu.salary.dao;

import com.ctgu.salary.po.PositionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 16:06
 * @ClassName PositionTypeDao
 * @Version 1.0.0
 */
@Mapper
public interface PositionTypeDao {
    List<PositionType> findAllPositionType();
    int delPositionTypeById(Integer id);
    int addPositionType(String type);
    PositionType findOnePositionType(String type);
    int updatePositionType(@Param("positionTypeId") Integer positionTypeId, @Param("type") String type);

}
