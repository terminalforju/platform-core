package com.project.model.role.mappers;

import com.project.model.role.pojo.Roles;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolesMapper {
    int insert(Roles record);

    int insertSelective(Roles record);
}
