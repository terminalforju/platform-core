package com.project.tools.response.aop;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.tools.pagehelper.PageInfoPo;
import com.project.tools.response.annotation.ResponseResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class ResponseResultAspect<T> implements Ordered {

    @Pointcut("@annotation(responseResult)")
    public void doPageHelperClass(ResponseResult responseResult) {
    }

    @Around("@annotation(responseResult)")
    public Object doPage(ProceedingJoinPoint point, ResponseResult responseResult) throws Throwable {
        Object[] objs = point.getArgs();
        for (Object obj : objs) {
            if (obj instanceof PageInfoPo) {
                PageInfoPo pageInfoPo = (PageInfoPo) objs[0];
                PageHelper.startPage(pageInfoPo.getPageNum(), pageInfoPo.getPageSize());
                break;
            }
        }
        Object result = point.proceed();

        PageInfo<T> pageInfosPo = new PageInfo<T>((List<T>) result);
        return pageInfosPo;
    }


    @Override
    public int getOrder() {
        return 1000;
    }
}
