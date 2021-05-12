package com.project.tools.datadict.aop;

import com.project.utils.BeanUtils;
import com.project.utils.cache.EhCacheUtil;
import com.project.tools.datadict.annotation.DataDict;
import com.project.tools.datadict.annotation.DataDictClass;
import com.project.tools.datadict.mappers.CustomMapper;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jzl on 2020/08/26.
 */
@Aspect
@Component
public class DataDictAspect implements Ordered {

    @Autowired
    private CustomMapper customMapper;


    @Pointcut("@annotation(dataDictClass)")
    public void doDataDictClass(DataDictClass dataDictClass) {
    }

    @Around("@annotation(dataDictClass)")
    public Object translation(final ProceedingJoinPoint pjp, DataDictClass dataDictClass) throws Throwable {
        Object result = pjp.proceed();
        if (result == null) {
            return result;
        }
        Object obj;
        if (result instanceof List || result instanceof ArrayList) {

            List olist = ((List) result);
            if (olist.size() == 0) {
                return result;
            }
            obj = olist.get(0);
        } else {
            obj = result;
        }


        /**
         * 获取翻译字段配置信息
         */
        Map<String, DataDict> dataDictMap = boDict(obj.getClass());
        if (dataDictMap.size() == 0) {
            return result;
        }

//        HashMap map = initDictDatas(dataDictMap);

//        赋值
        if (result instanceof List || result instanceof ArrayList) {
            for (Object o : (List) result) {
                setValue(o, dataDictMap);
            }
        } else {
            setValue(result, dataDictMap);
        }
        return result;
    }

    /**
     * 获取bo中属性值
     *
     * @param cla
     * @return
     */
    private Map<String, DataDict> boDict(Class cla) {
        Field[] fields = cla.getDeclaredFields();
        Map<String, DataDict> map = new HashMap<String, DataDict>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(DataDict.class)) {
                DataDict dataDict = field.getAnnotation(DataDict.class);
                String fieldName = field.getName();
                map.put(fieldName, dataDict);
            }
        }
        return map;
    }

    /**
     * 赋值
     *
     * @param obj
     * @param dataDictMap
     */
    private void setValue(Object obj, Map<String, DataDict> dataDictMap) throws Exception {
        EhCacheUtil ehCacheUtil = EhCacheUtil.getInstance();
        for (Map.Entry<String, DataDict> entry : dataDictMap.entrySet()) {
            String fileName = entry.getKey();
//            Map datas = datainfo.get(fileName);
            DataDict dataDict = entry.getValue();
            String keyStrs = (String) BeanUtils.getBeanFieldValue(obj.getClass(), obj, dataDict.source());
            String keys[] = keyStrs.split(dataDict.transferLineColumn());
            List values = new ArrayList();
            for (String key : keys) {
                values.add(ehCacheUtil.getDict(dataDict.dicId() + key));
            }
            BeanUtils.setBeanField(obj.getClass(), obj, fileName, StringUtils.join(values.toArray(), ","));
        }
    }

//    /**
//     * 初始化数据
//     * @param dataDictMap
//     * @return
//     */
//    private HashMap initDictDatas(Map<String, DataDict> dataDictMap) {
//        HashMap<String,Map<String,String>> map = new HashMap();
//        for (Map.Entry<String, DataDict> entry : dataDictMap.entrySet()) {
//            String fileName = entry.getKey();
//            DataDict dataDict = entry.getValue();
//            List<Dict> datas = customMapper.customQueryItem(dataDict.sql());
//            Map<String,String> m = datas.stream().collect(Collectors.toMap(Dict::getKey,Dict::getValue));
//            map.put(fileName,m);
//        }
//        return map;
//    }


    @Override
    public int getOrder() {
        return 50;
    }
}
