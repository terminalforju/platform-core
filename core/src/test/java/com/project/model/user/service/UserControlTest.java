//package com.platform.core.user.service;
//
//import com.platform.core.utils.pagehelper.PageInfoPo;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class UserControlTest {
//
//    @Autowired
//    private UserControl userControl;
//
//    @Test
//    void save() {
//    }
//
//    @Test
//    void queryUserById() {
//    }
//
//    @Test
//    void query() {
//    }
//
//    @Test
//    void queryAll() throws Exception {
//        HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpServletResponse response =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
//        PageInfoPo page = new PageInfoPo();
//        page.setPageNum(1);
//        page.setPageSize(5);
//        System.out.println(userControl.queryAll(page, response, request));
//    }
//}
