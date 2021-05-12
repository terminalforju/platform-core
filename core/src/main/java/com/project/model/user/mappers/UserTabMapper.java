package com.project.model.user.mappers;

import com.project.model.user.pojo.UserTab;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserTabMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserTab record);

    int insertSelective(UserTab record);

    UserTab selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserTab record);

    int updateByPrimaryKeyWithBLOBs(UserTab record);

    int updateByPrimaryKey(UserTab record);

    @Select("select * from user_tab")
    List<UserTab> loadAllUsers();

    @Select("select * from user_tab where code =  #{code}")
    UserTab loadUserByCode(String code);
}
