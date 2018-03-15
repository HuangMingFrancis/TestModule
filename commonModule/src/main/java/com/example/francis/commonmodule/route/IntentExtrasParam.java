package com.example.francis.commonmodule.route;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Francis on 2018/3/14.
 * 用于定义跳转传参的 IntentExtrasParam（ IntentExtrasParam 注解的参数最终通过 Intent 来传递）：
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface IntentExtrasParam {
    String value();
}