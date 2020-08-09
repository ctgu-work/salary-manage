package com.ctgu.salary.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 17:40
 * @ClassName Position
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    private Integer positionId;
    private Integer positionMan;
    private Integer departId;
    private Integer positionTypeId;
    private String positionName;
}
