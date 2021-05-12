package com.project.business.service;

import com.project.business.dao.UserDao;
import com.project.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userDao.findUserByCode(username);
       if (user == null){
           throw(new UsernameNotFoundException("用户不存在"));
       }
       return user;
    }

}
