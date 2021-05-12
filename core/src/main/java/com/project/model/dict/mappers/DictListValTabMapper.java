//package com.project.dict.mappers;
//
//import com.project.dict.pojo.DictListValTab;
//import org.apache.ibatis.annotations.Select;
//
//import java.util.List;
//
//public interface DictListValTabMapper {
//    static final String DEMO_CACHE_NAME = "DictList";
//
//    int insert(DictListValTab record);
//
//    int insertSelective(DictListValTab record);
//
//    DictListValTab getDictByListIdAndkey(String listId, String key);
//
//    @Select("select * from dict_list_val_tab")
//    List<DictListValTab> findAll();
//}
