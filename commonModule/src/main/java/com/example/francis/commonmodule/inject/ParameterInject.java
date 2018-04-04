package com.example.francis.commonmodule.inject;

/**
 * Created by Francis on 2018/3/17.
 */

public interface ParameterInject<T>
{
    void inject(T object);
}