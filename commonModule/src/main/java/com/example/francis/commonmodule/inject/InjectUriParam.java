package com.example.francis.commonmodule.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Francis on 2018/3/15.
 * 定义我们的参数注解 InjectUriParam
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface InjectUriParam {
    String value() default "";
}