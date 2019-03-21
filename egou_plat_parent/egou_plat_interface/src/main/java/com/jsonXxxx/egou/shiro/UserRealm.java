package com.jsonXxxx.egou.shiro;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jsonXxxx.egou.config.MySimpleByteSource;
import com.jsonXxxx.egou.entity.Role;
import com.jsonXxxx.egou.entity.User;
import com.jsonXxxx.egou.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Component
public class UserRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = userMapper.selectByUsername(username);
        List<Role> roles = user.getRoles();
        Set<String> roleNames = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        roles.stream().forEach(role -> {
            roleNames.add(role.getSn());
            role.getPermissions().stream().forEach(permission -> {
                permissions.add(permission.getSn());
            });
        });
        authorizationInfo.setRoles(roleNames);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = null;
        try {
            user = userMapper.selectOne(new QueryWrapper<User>().eq("username", token.getUsername()));
        } catch (Exception e) {
            logger.error("UserRealm-->AuthenticationInfo" + e.getMessage(), e);
        }
        //账号不存在
        if (Objects.isNull(user)) {
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), new MySimpleByteSource(user.getSalt().getBytes()), getName());
        return info;
    }

}
