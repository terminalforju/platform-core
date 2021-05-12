package com.project.tools.response.annotation;

import java.lang.annotation.*;

/**
 * Created by jzl on 2020/08/26.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {
}
