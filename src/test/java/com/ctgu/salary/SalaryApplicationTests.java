package com.ctgu.salary;

import com.ctgu.salary.dao.AdminDao;
import com.ctgu.salary.dao.FormulaDao;
import com.ctgu.salary.dao.RewardPunishDao;
import com.ctgu.salary.dao.SalaryDtoDao;
import com.ctgu.salary.po.Admin;
import com.ctgu.salary.po.Formula;
import com.ctgu.salary.po.RewardPunish;
import com.ctgu.salary.service.AdminService;
import com.ctgu.salary.service.SalaryDtoService;
import com.ctgu.salary.utils.Md5Salt;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SalaryApplication.class)
class SalaryApplicationTests {


	@Autowired
	private SalaryDtoDao rewardPunishDao;

	@Autowired
	private SalaryDtoService salaryDtoService;

	@Test
	void contextLoads() {
		System.out.println(salaryDtoService.getSalaryList(2));
	}

}
