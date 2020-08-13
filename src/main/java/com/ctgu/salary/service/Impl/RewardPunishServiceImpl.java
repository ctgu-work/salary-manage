package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.RewardPunishDao;
import com.ctgu.salary.dto.RewardPunishDto;
import com.ctgu.salary.po.RewardPunish;
import com.ctgu.salary.service.RewardPunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: salary *
 * @classname: RewardPunishServiceImpl *
 * @author: lnback *
 * @create: 2020-08-12 21:00
 **/

@Service
public class RewardPunishServiceImpl implements RewardPunishService {

    @Autowired
    private RewardPunishDao rewardPunishDao;

    @Override
    public int deleteRewardPunish(Integer rewardPunishId) {
        return rewardPunishDao.deleteRewardPunish(rewardPunishId);
    }

    @Override
    public int updateRewardPunish(RewardPunish rewardPunish) {
        return rewardPunishDao.updateRewardPunish(rewardPunish);
    }

    @Override
    public void addRewardPunish(List<RewardPunish> list) {
        rewardPunishDao.addRewardPunish(list);
    }

    @Override
    public List<RewardPunishDto> selectAll(RewardPunish rewardPunish) {
        return rewardPunishDao.selectAll(rewardPunish);
    }
}
