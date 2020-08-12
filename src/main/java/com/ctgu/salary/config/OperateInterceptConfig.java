package com.ctgu.salary.config;

import com.ctgu.salary.aop.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-11 20:50
 * @ClassName OperateIntercept
 * @Version 1.0.0
 */
@Configuration
public class OperateInterceptConfig extends WebMvcConfigurationSupport {
    /*
     * 拦截器配置
     */
    @Bean
    public LogInterceptor logInterceptor(){
        return new LogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(logInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/login");
        super.addInterceptors(registry);
    }

}