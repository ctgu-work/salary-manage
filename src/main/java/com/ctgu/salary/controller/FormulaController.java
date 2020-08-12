package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.po.Formula;
import com.ctgu.salary.service.FormulaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: salary *
 * @classname: FormulaController *
 * @author: lnback *
 * @create: 2020-08-09 13:57
 **/
@RestController
@RequestMapping("/formula")
public class FormulaController {

    @Autowired
    FormulaService formulaService;

    @GetMapping("/getFormula")
    public ResultBody getFormula(@RequestParam(value = "formulaId",required = false,defaultValue = "0") Integer formulaId,
                                 @RequestParam(value = "formulaName",required = false,defaultValue = "null") String formulaName,
                                 @RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");
        if (formulaName.equals("null") || formulaName == "null"){
            formulaName = null;
        }
        Formula formula = new Formula();
        //两个参数都为空表示查询全部
        if(formulaId == 0 && formulaName == null){
            PageHelper.startPage(startPage,pageSize);
            List<Formula> list = formulaService.selectFormula(formula);
            PageInfo<Formula> pageInfo = new PageInfo<>(list);
            resultBody.setResult(pageInfo);
        }else {
            PageHelper.startPage(startPage,pageSize);
            formula.setFormulaName(formulaName);
            formula.setFormulaId(formulaId);
            List<Formula> list = formulaService.selectFormula(formula);
            PageInfo<Formula> pageInfo = new PageInfo<>(list);
            resultBody.setResult(list);
        }
        resultBody.setMsg("success");
        return resultBody;
    }

    @GetMapping("/deleteFormula")
    public ResultBody deleteFormula(@RequestParam("formulaId") Integer formulaId){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");

        if(formulaId == null){
            resultBody.setMsg("删除失败，未选定删除项！");
            resultBody.setResult(null);
        }else {
            formulaService.deleteFormula(formulaId);
            resultBody.setResult(null);
            resultBody.setMsg("success！");
        }
        return resultBody;
    }

    @PostMapping("/updateFormula")
    public ResultBody updateFormula(Formula formula){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");

        if(formula == null){
            resultBody.setMsg("修改失败，没有提交任何数据！");
            resultBody.setResult(null);
        }else {
            formulaService.updateFormula(formula);
            resultBody.setMsg("success");
            resultBody.setResult(null);
        }
        return resultBody;
    }

    @PostMapping("/addFormula")
    public ResultBody addFormula(Formula formula){
        ResultBody resultBody = new ResultBody();
        resultBody.setStatusCode("200");

        if(formula == null){
            resultBody.setMsg("添加失败，没有提交任何数据！");
            resultBody.setResult(null);
        }else {
            formulaService.addFormula(formula);
            resultBody.setMsg("success");
            resultBody.setResult(null);
        }
        return resultBody;
    }
}
