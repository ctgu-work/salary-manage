package com.ctgu.salary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @program: salary *
 * @classname: RewardPunishDto *
 * @author: lnback *
 * @create: 2020-08-13 11:34
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardPunishDto {
    private Integer rewardPunishId;
    private Integer staffId;
    private String staffName;
    private Integer overday;
    private Integer lateday;
    private Integer sickday;
    private Integer affairday;
    private Integer reissue;
    private Integer departId;
    private String departName;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp startTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp endTime;
}
