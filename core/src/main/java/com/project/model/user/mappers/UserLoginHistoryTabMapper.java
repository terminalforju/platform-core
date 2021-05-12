package com.project.model.user.mappers;

import com.project.model.user.pojo.UserLoginHistoryTab;

public interface UserLoginHistoryTabMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserLoginHistoryTab record);

    int insertSelective(UserLoginHistoryTab record);

    UserLoginHistoryTab selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserLoginHistoryTab record);

    int updateByPrimaryKey(UserLoginHistoryTab record);
}
