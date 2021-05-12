package com.project.model.user.service;

import com.project.model.role.mappers.RoleMapper;
import com.project.model.user.mappers.UserTabMapper;
import com.project.model.user.pojo.UserTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserTabMapper userMapper;
//    @Autowired
//    private RoleMapper roleMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String code) throws UsernameNotFoundException {
        logger.info("登录用户名" + code);
        logger.info("登录用户名" + passwordEncoder.encode("1"));
        //查数据库
        UserTab user = userMapper.loadUserByCode(code);
        if (null != user) {
//            List<Role> roles = roleMapper.getRolesByUserId(user.getId());
//            user.setAuthorities( roles );
        }

        return user;
    }


}
