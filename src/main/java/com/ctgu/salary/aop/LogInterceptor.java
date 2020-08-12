package com.ctgu.salary.aop;

import com.ctgu.salary.po.Admin;
import com.ctgu.salary.po.OperateLog;
import com.ctgu.salary.service.AdminService;
import com.ctgu.salary.service.OperateLogService;
import com.ctgu.salary.utils.RedisUtils;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-11 20:52
 * @ClassName LogInterceptor
 * @Version 1.0.0
 */

public class LogInterceptor implements HandlerInterceptor {

    @Autowired
    private AdminService adminService;
    @Autowired
    private OperateLogService operateLogService;
    @Autowired
    private RedisUtils redisUtils ;
    public LogInterceptor() {

    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        StringBuffer str = request.getRequestURL();
        String url = new String(str);
        if( WebUtils.toHttp(request).getHeader("Authorization").equals("") ) return true;
        String token = WebUtils.toHttp(request).getHeader("Authorization");
        String username = (String) redisUtils.get(token);
        Admin admin = adminService.findByUsername(username);
        OperateLog operateLog = new OperateLog();
        operateLog.setOperaterId(admin.getAdminId());
        operateLog.setOperaterName(username);
        operateLog.setOperateMsg(url);
        operateLogService.addOperateLog(operateLog);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
