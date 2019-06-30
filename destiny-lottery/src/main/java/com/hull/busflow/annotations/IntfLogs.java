package com.hull.busflow.annotations;

import java.lang.annotation.*;

/**
 * TODO 来点注释
 *
 * @author
 * @create 2018-07-28 下午4:36
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface IntfLogs {

    IntfLog[] value();

}
