package com.ctgu.salary;

import com.ctgu.salary.dao.AdminDao;
import com.ctgu.salary.po.Admin;
import com.ctgu.salary.service.AdminService;
import com.ctgu.salary.utils.Md5Salt;
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
		System.out.println(Md5Salt.Md5Crypt("123321"));
	}

}
