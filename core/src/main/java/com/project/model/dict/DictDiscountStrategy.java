//package com.project.dict;
//
//import com.project.config.strategy.DiscountStrategy;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DictDiscountStrategy implements DiscountStrategy {
//
//    @Autowired
//    private DictListValTabMapper dictListValTabMapper;
//
//    @Override
//    public void run(String... args) {
//        List<DictListValTab> dicts = dictListValTabMapper.findAll();
//        EhCacheUtil ehCacheUtil = EhCacheUtil.getInstance();
//        for (DictListValTab dictListValTab : dicts) {
//            ehCacheUtil.putDict(dictListValTab.getListid() + dictListValTab.getName(), dictListValTab.getValue());
//        }
//    }
//
//}
