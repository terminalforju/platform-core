package com.project.tools.datadict.mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomMapper<T> {

    public List<T> customQueryItem(String sqlContent);

}
