package com.zy.tow.shiro;

import com.zy.tow.Service.LoginService;
import com.zy.tow.bean.Permissions;
import com.zy.tow.bean.Role;
import com.zy.tow.bean.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name =(String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        User user =loginService.getUserByName(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        for(Role role : user.getRoleSet()){
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            //添加权限
            for (Permissions permissions : role.getPermissionsSet()) {
                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
            }
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候先认证，然后在到请求
        if (authenticationToken.getPrincipal() == null){
            return null;
        }

        //获取用户信息
        String name =authenticationToken.getPrincipal().toString();
        User user =loginService.getUserByName(name);
        if(user==null){
            //这里返回后会报出对应异常
            return null ;
        }else {
            //这里验证authenticationToke和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo =new SimpleAuthenticationInfo(name,user.getPassword().toString(),getName());
            return simpleAuthenticationInfo;
        }
    }
}
