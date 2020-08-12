package com.ctgu.salary.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: salary *
 * @classname: RewardPunish *
 * @author: lnback *
 * @create: 2020-08-12 20:50
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardPunish {
    private Integer rewardPunishId;
    private Integer staffId;
    private Integer overday;
    private Integer lateday;
    private Integer sickday;
    private Integer affairday;
    private Integer reissue;
    private Integer departId;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp startTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp endTime;

}
