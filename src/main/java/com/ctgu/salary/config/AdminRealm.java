package com.ctgu.salary.config;

import com.ctgu.salary.po.Admin;
import com.ctgu.salary.service.AdminService;
import com.ctgu.salary.utils.JwtUtils;
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


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 验证身份
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String username = JwtUtils.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token无效");
        }
        Admin admin = adminService.findByUsername(username);
        if (admin == null) {
            throw new AuthenticationException("用户不存在!");
        }
        if (!JwtUtils.verify(token, username, admin.getPassword())) {
            throw new AuthenticationException("用户名或密码错误");
        }

        return new SimpleAuthenticationInfo(token,token,this.getName());
    }
}
