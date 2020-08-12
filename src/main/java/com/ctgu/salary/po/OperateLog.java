package com.ctgu.salary.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-11 20:57
 * @ClassName OperateLog
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperateLog {
    private Integer operateLogId;
    private Integer operaterId;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date operateDate;
    private String operateMsg;
    private String operaterName;

}
