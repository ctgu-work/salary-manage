package com.ctgu.salary;

import com.ctgu.salary.dao.AdminDao;
import com.ctgu.salary.po.Admin;
import com.ctgu.salary.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SalaryApplication.class)
class SalaryApplicationTests {


	@Autowired
	private AdminDao adminDao;
	@Test
	void contextLoads() {
		Admin admin = new Admin(1, "lnback", "back", "123321");
		System.out.println(adminDao.selectAdminByUsernameAndPassword(admin));
	}

}
