package com.hansky.annotation;

import java.lang.annotation.*;

/**
 * Created by shanghui on 2018/1/30.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogHandler {

    String description()  default "";
}
