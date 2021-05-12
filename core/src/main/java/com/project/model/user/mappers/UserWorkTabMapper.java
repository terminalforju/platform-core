package com.project.model.user.mappers;

import com.project.model.user.pojo.UserWorkTab;

public interface UserWorkTabMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserWorkTab record);

    int insertSelective(UserWorkTab record);

    UserWorkTab selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserWorkTab record);

    int updateByPrimaryKeyWithBLOBs(UserWorkTab record);

    int updateByPrimaryKey(UserWorkTab record);
}
