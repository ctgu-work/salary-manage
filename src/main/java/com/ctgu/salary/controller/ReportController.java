package com.ctgu.salary.controller;

import com.ctgu.salary.dto.ReportDto;
import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.dto.WageDto;
import com.ctgu.salary.service.ReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-12 15:54
 * @ClassName ReportController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }


    /**
     * @Author wh
     * @Description 全部报表
     * @Date 2020/8/13 11:11
     * @Param [startPage, pageSize]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/list" , method = RequestMethod.GET )
    public ResultBody allStaffs(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        if( reportService.findAllReportWage() == null ){
            return resultBody;
        }

        List<WageDto> wageDtos = reportService.findAllReportWage();
        List<ReportDto> reportDtos = reportService.findAllFormulaCal();

        int j = 0;
        for( WageDto wage : wageDtos ){
            int sum = wage.getOverday() - wage.getAffairMoney() - wage.getLateMoney() - wage.getSickMoney();
            wage.setRpMoney(sum);
            for( ; j < reportDtos.size() ; j++ ){
                List<ReportDto> reports = new LinkedList<>();
                if( wage.getCalcSalaryId() == reportDtos.get(j).getCalcSalaryId() ){
                    reports.add(reportDtos.get(j));
                }
                else{
                    wage.setFormulaCal(reports);
                    break;
                }
            }

            wage.setFormulaCal(reportDtos);
        }

        PageHelper.startPage(startPage, pageSize);
        PageInfo<WageDto> wageDtoPageInfo = new PageInfo<>(wageDtos);
        resultBody.setResult(wageDtoPageInfo);

        return resultBody;
    }
}
