package com.project.model.user.mappers;

import com.project.model.user.pojo.UserContactTab;

public interface UserContactTabMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserContactTab record);

    int insertSelective(UserContactTab record);

    UserContactTab selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserContactTab record);

    int updateByPrimaryKeyWithBLOBs(UserContactTab record);

    int updateByPrimaryKey(UserContactTab record);
}
