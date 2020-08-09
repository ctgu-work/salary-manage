package com.ctgu.salary.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: salary *
 * @classname: Admin *
 * @author: lnback *
 * @create: 2020-08-06 15:14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer adminId;
    private String adminName;
    private String userName;
    private String password;
}
