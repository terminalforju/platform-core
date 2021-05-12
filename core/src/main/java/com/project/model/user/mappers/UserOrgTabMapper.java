package com.project.model.user.mappers;

import com.project.model.user.pojo.UserOrgTab;

public interface UserOrgTabMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserOrgTab record);

    int insertSelective(UserOrgTab record);

    UserOrgTab selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserOrgTab record);

    int updateByPrimaryKey(UserOrgTab record);
}
