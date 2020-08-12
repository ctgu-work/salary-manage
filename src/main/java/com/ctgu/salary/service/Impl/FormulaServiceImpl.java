package com.ctgu.salary.service.Impl;

import com.ctgu.salary.dao.FormulaDao;
import com.ctgu.salary.po.Formula;
import com.ctgu.salary.service.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: salary *
 * @classname: FormulaServiceImpl *
 * @author: lnback *
 * @create: 2020-08-09 13:58
 **/
@Service
public class FormulaServiceImpl implements FormulaService {

    @Autowired
    FormulaDao formulaDao;

    @Override
    public List<Formula> selectFormula(Formula formula) {
        return formulaDao.selectAll(formula);
    }

    @Override
    public int deleteFormula(Integer formulaId) {
        return formulaDao.deleteFormula(formulaId);
    }

    @Override
    public int updateFormula(Formula formula) {
        return formulaDao.updateFormula(formula);
    }

    @Override
    public int addFormula(Formula formula) {
        return formulaDao.addFormula(formula);

    }
}
