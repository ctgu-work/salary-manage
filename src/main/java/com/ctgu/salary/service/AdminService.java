package com.ctgu.salary.service;

import com.ctgu.salary.po.Admin;

/**
 * @program: salary *
 * @classname: AdminService *
 * @author: lnback *
 * @create: 2020-08-06 15:33
 **/

public interface AdminService {
    Admin adminLogin(Admin admin);

    Admin findByUsername(String username);
}
