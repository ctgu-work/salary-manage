package com.ctgu.salary.dto;

import com.ctgu.salary.po.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 18:55
 * @ClassName PositionDto
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class PositionDto extends Position {
    private String departName;
    private String type;
}
