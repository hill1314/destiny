package com.mljr.destiny.annotations;


import java.lang.annotation.*;

/**
 * 保存接口调用记录的注解
 *
 * @author
 * @create 2018-07-28 下午4:21
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Repeatable(IntfLogs.class)
public @interface IntfLog {

    /**
     * 调用地址
     * @return
     */
    String url();

    /**
     * 备注
     * @return
     */
    String desc() default "";

    Class callbackClass() default Void.class;

}
