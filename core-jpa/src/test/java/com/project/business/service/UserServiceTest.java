package com.project.business.service;

import com.project.business.dao.UserDao;
import com.project.business.model.Role;
import com.project.business.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserDao userDao;

    @Test
    void UserSave(){
        User user = new User();
        user.setCode("admin");
        user.setUsername("管理员");
        user.setPassword("123");
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        ArrayList roles = new ArrayList();
        Role r1 = new Role();
        r1.setName("admin");
        r1.setNameZh("管理员");
        roles.add(r1);
        user.setRoles(roles);

        userDao.save(user);


        User user1 = new User();
        user1.setCode("test");
        user1.setUsername("测试账号");
        user1.setPassword("123");
        user1.setEnabled(true);
        user1.setAccountNonExpired(true);
        user1.setAccountNonLocked(true);
        user1.setCredentialsNonExpired(true);
        ArrayList roles1 = new ArrayList();
        Role r2 = new Role();
        r2.setName("test");
        r2.setNameZh("测试员");
        roles1.add(r2);
        user1.setRoles(roles1);

        userDao.save(user1);
    }

    @Test
    void findUserByUsername(){

       User user = userDao.findUserById(2l);
       User userAdmin = userDao.findUserByCode("admin");
//        userDao.delete(user);
        System.out.printf(user.getUsername()+"\n");
        System.out.printf(userAdmin.getRoles().get(0).getAuthority()+"\n");
        System.out.printf(userDao.existsByCode("test1")+"");
    }

    @Test
    @Transactional
    void testTrasactional() throws Exception {

        User user1 = new User();
        user1.setCode("test2");
        user1.setUsername("测试账号2");
        user1.setPassword("123");
        user1.setEnabled(true);
        user1.setAccountNonExpired(true);
        user1.setAccountNonLocked(true);
        user1.setCredentialsNonExpired(true);
        ArrayList roles1 = new ArrayList();
        Role r2 = new Role();
        r2.setName("test2");
        r2.setNameZh("测试员2");
        roles1.add(r2);
        user1.setRoles(roles1);

        userDao.save(user1);
        if (6l == user1.getId()){
            throw new RuntimeException("123");
        }
        userDao.delete(user1);
    }


}
