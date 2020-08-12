package com.ctgu.salary.aop;

import com.ctgu.salary.po.Admin;
import com.ctgu.salary.po.OperateLog;
import com.ctgu.salary.service.AdminService;
import com.ctgu.salary.service.OperateLogService;
import com.ctgu.salary.utils.RedisUtils;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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

    public LogInterceptor() {

    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        StringBuffer str = request.getRequestURL();
        String url = new String(str);
        String token = WebUtils.toHttp(request).getHeader("Authorization");
        RedisUtils redisUtils = new RedisUtils();
        String username = (String) redisUtils.get(token);
        System.out.println(username);
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
