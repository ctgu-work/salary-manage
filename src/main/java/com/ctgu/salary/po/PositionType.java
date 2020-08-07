package com.ctgu.salary.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 16:30
 * @ClassName PositionType
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionType {
    private Integer positionTypeId;
    private String type;
}
