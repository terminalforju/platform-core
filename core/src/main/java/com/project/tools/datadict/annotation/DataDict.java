package com.project.tools.datadict.annotation;

import java.lang.annotation.*;

/**
 * Created by jzl on 2020/08/26.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataDict {

    /**
     * 方法描述,可使用占位符获取参数:{{source}}
     * 主要标准编码之来源,
     * 查询用户信息时存储用户userId 的字段名称
     */
    String source() default "";

    /**
     * 方法描述 描述标准编码 或是用户字段(对应UserBo)
     * 与user配合使用,需要取的信息字段
     * 如：要去age 则配置age 要取 userName 则配置 userName
     *
     * @return
     */
    String target() default "";

    /**
     * 用来确定字段
     *
     * @return
     */
    String dicId() default "";

    /**
     * 默认值
     *
     * @return
     */
    String defValue() default "";

    /**
     * 查询类别
     * 使用默认自动查询 1
     * 使用自定义sql查询 2
     *
     * @return
     */
    String checkType() default "1";

    /**
     * 对source 值是否需要对行转列进行拆分处理{{","}}
     * 需要对source值按逗号进行拆分后翻译，默认拆分转换
     * 若是{{$}}则按$进行拆分
     * 默认不处理
     * 如：
     * "proMode": "1,2",
     * "proModeName": "出售,结算",
     *
     * @return
     */
    String transferLineColumn() default ",";


    String sql() default "";


}
