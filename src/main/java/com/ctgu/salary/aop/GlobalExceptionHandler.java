package com.ctgu.salary.aop;

import com.ctgu.salary.dto.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 全局异常
 * @Author wh_lan
 * @create 2020-08-06 17:20
 * @ClassName GlobalExceptionHandler
 * @Version 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody defaultErrorHandler(HttpServletRequest req, Exception e) {
        ResultBody resultBody = new ResultBody();
        e.printStackTrace();
        // 这里可根据不同异常引起的类做不同处理方式
        String exceptionName = ClassUtils.getShortName(e.getClass());
        resultBody.setStatusCode("500");
        resultBody.setMsg(e.getMessage());
        resultBody.setResult(e);
        return resultBody;
    }
}
