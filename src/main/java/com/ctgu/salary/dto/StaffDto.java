package com.ctgu.salary.dto;

import com.ctgu.salary.po.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 10:51
 * @ClassName StaffDto
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto extends Staff {
    private String departName;
    private String positionName;

}
