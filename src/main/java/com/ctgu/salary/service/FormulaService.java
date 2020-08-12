package com.ctgu.salary.service;

import com.ctgu.salary.po.Formula;

import java.util.List;

/**
 * @program: salary *
 * @classname: FormulaService *
 * @author: lnback *
 * @create: 2020-08-09 13:58
 **/

public interface FormulaService {
    List<Formula> selectFormula(Formula formula);
    int deleteFormula(Integer formulaId);
    int updateFormula(Formula formula);
    int addFormula(Formula formula);
}
