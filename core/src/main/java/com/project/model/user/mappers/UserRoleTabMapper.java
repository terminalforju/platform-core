package com.project.model.user.mappers;

import com.project.model.user.pojo.UserRoleTab;

public interface UserRoleTabMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRoleTab record);

    int insertSelective(UserRoleTab record);

    UserRoleTab selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRoleTab record);

    int updateByPrimaryKey(UserRoleTab record);
}
