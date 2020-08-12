package com.ctgu.salary.dao;

import com.ctgu.salary.po.Formula;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: salary *
 * @classname: FormulaDao *
 * @author: lnback *
 * @create: 2020-08-09 13:57
 **/
@Mapper
@Repository
public interface FormulaDao {
    List<Formula> selectAll(Formula formula);
    int addFormula(Formula formula);
    int updateFormula(Formula formula);
    int deleteFormula(@Param("formulaId") Integer formulaId);
}
