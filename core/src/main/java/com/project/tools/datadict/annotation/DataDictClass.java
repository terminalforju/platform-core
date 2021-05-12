package com.project.tools.datadict.annotation;

import java.lang.annotation.*;

/**
 * Created by jzl on 2020/08/26.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataDictClass {
}
