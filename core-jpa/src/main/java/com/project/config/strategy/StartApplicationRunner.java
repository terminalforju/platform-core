package com.project.config.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 程序启动时，执行当前方法
 */
@Component
public class StartApplicationRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(StartApplicationRunner.class);


    private final List<DiscountStrategy> list;

//    注入要运行的方法
    @Autowired
    public StartApplicationRunner(List<DiscountStrategy> discountStrategies) {
        this.list = discountStrategies;
    }


    /**
     * 程序启动时，执行当前方法  创建缓存对象，缓存字典项
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        for (DiscountStrategy dictListValTab : list) {
          dictListValTab.run(args);
        }
    }


}
