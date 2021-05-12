package com.project.model.role.mappers;

import com.project.model.role.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    @Select("select * from role t left join user_role t1 on t.id = t1.role_id where t1.user_id = #{id}")
    List<Role> getRolesByUserId(Long id);
}
