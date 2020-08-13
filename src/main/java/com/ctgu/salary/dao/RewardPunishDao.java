package com.ctgu.salary.dao;

import com.ctgu.salary.dto.RewardPunishDto;
import com.ctgu.salary.po.Formula;
import com.ctgu.salary.po.RewardPunish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: salary *
 * @classname: RewardPunishDao *
 * @author: lnback *
 * @create: 2020-08-12 20:59
 **/
@Mapper
@Repository
public interface RewardPunishDao {
    int deleteRewardPunish(@Param("rewardPunishId") Integer rewardPunishId);
    int updateRewardPunish(RewardPunish rewardPunish);
    void addRewardPunish(@Param("list") List<RewardPunish> list);
    List<RewardPunishDto> selectAll(RewardPunish rewardPunish);
}
