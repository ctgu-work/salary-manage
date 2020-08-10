package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.AdminDao;
import com.ctgu.salary.po.Admin;
import com.ctgu.salary.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: salary *
 * @classname: AdminServiceImpl *
 * @author: lnback *
 * @create: 2020-08-06 15:33
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin adminLogin(Admin admin) {
        return adminDao.selectAdminByUsernameAndPassword(admin);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminDao.selectAdminByUsername(username);
    }
}
