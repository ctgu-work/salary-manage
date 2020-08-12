package com.ctgu.salary.service;

import com.ctgu.salary.po.RewardPunish;

import java.util.List;

/**
 * @program: salary *
 * @classname: RewardPunishService *
 * @author: lnback *
 * @create: 2020-08-12 20:59
 **/

public interface RewardPunishService {
    int deleteRewardPunish(Integer rewardPunishId);
    int updateRewardPunish(RewardPunish rewardPunish);
    void addRewardPunish(List<RewardPunish> list);
    List<RewardPunish> selectAll(RewardPunish rewardPunish);
}
