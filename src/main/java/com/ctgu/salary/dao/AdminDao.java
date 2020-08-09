package com.ctgu.salary.dao;

import com.ctgu.salary.po.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: salary *
 * @classname: AdminDao *
 * @author: lnback *
 * @create: 2020-08-06 15:35
 **/
@Mapper
@Repository
public interface AdminDao {
    Admin selectAdminByUsernameAndPassword(@Param("admin")Admin admin );
}
