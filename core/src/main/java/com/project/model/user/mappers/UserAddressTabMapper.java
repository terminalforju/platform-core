package com.project.model.user.mappers;

import com.project.model.user.pojo.UserAddressTab;

public interface UserAddressTabMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserAddressTab record);

    int insertSelective(UserAddressTab record);

    UserAddressTab selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserAddressTab record);

    int updateByPrimaryKeyWithBLOBs(UserAddressTab record);

    int updateByPrimaryKey(UserAddressTab record);
}
