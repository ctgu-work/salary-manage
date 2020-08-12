package com.ctgu.salary.config;

import com.auth0.jwt.JWT;
import com.ctgu.salary.dto.JwtToken;
import com.ctgu.salary.po.Admin;
import com.ctgu.salary.service.AdminService;
import com.ctgu.salary.utils.JwtUtils;
import com.ctgu.salary.utils.RedisUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: salary *
 * @classname: AdminRealm *
 * @author: lnback *
 * @create: 2020-08-10 15:23
 **/

public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisUtils redisUtils;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取token
        String token = new String((char[])authenticationToken.getCredentials());
        System.err.println(token);
        //解密获得username
        String username = JwtUtils.getUsername(token);
        //如果账号为空
        if(username == null || username.trim().equals("")){
            throw new AuthenticationException("token中账号为空");
        }
        //查询用户是否存在
        Admin admin = adminService.findByUsername(username);
        if(admin == null){
            throw new AuthenticationException("该账号不存在");
        }
        if(JwtUtils.verify(token,username,admin.getPassword()) && redisUtils.hasKey(username)){
            return new SimpleAuthenticationInfo(token,token,this.getName());
        }
        throw new AuthenticationException("错误");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
