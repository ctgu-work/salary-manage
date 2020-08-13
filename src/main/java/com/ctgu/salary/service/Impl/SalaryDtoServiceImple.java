package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.SalaryDtoDao;
import com.ctgu.salary.dto.SalaryDto;
import com.ctgu.salary.service.SalaryDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: salary *
 * @classname: SalaryDtoServiceImple *
 * @author: lnback *
 * @create: 2020-08-13 20:02
 **/

@Service
public class SalaryDtoServiceImple implements SalaryDtoService {

    @Autowired
    private SalaryDtoDao salaryDtoDao;

    @Override
    public List<SalaryDto> getSalaryList(Integer departId) {
        List<SalaryDto> list = new LinkedList<>();
        list = salaryDtoDao.selectAll(departId);
        for (SalaryDto dto : list){
            List<Double> list1 = salaryDtoDao.selectCalcSalary(dto.getStaffId());
            double calcSalary = 1.0;
            for(double percentage : list1){
                calcSalary += dto.getFixedSalary() * percentage;
            }
            dto.setCalcSalary(calcSalary);
            dto.setTotalSalary(dto.getCalcSalary() + dto.getFixedSalary() + dto.getRewardPunishSalary());
        }
        return list;
    }

    @Override
    public int updateWageStatus(Integer status, Integer wageId) {
        return salaryDtoDao.updateWageStatus(status,wageId);
    }
}
