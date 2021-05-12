package com.project.model.user.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.model.user.mappers.UserTabMapper;
import com.project.model.user.pojo.UserTab;
import com.project.tools.datadict.annotation.DataDictClass;
import com.project.tools.pagehelper.PageInfoPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserControl {

    private static final Logger log = LoggerFactory.getLogger(UserControl.class);

    @Autowired
    private UserTabMapper userMapper;

    @RequestMapping(value = "/save")
    public String save(HttpServletResponse httpServletResponse, HttpServletRequest request) throws Exception {
        UserTab user = new UserTab();
//        user.setId(UUID.randomUUID().toString());
        user.setPassword("123111");
        user.setName("wan");
        userMapper.insert(user);
        log.info(user.getId().toString());
        return "SUCCESS";
    }

    @JsonFormat
    @DataDictClass
    @RequestMapping(value = "/queryUserById")
    public UserTab queryUserById(String id, HttpServletResponse httpServletResponse, HttpServletRequest request) throws Exception {
        return userMapper.selectByPrimaryKey(id);
    }

    @JsonFormat
    @RequestMapping(value = "/saves")
    public List<UserTab> queryUserById(@RequestBody List<UserTab> users) throws Exception {

        return users;
    }

    @JsonFormat
    @DataDictClass
    @RequestMapping(value = "/query")
    public List query(String id, HttpServletResponse httpServletResponse, HttpServletRequest request) throws Exception {
        List list = new ArrayList();
        UserTab user = userMapper.selectByPrimaryKey(id);
//        user.setStatusId("name");
//        list.add(user);
        return list;
    }


    @JsonFormat
    @RequestMapping(value = "/queryAll")
    public List queryAll(@RequestBody PageInfoPo pageInfoPo, HttpServletResponse httpServletResponse, HttpServletRequest request) throws Exception {
//       Page page = PageHelper.startPage(pageInfoPo.getPageNum(), pageInfoPo.getPageSize());
        List<UserTab> users = userMapper.loadAllUsers();
        return users;
    }

}
