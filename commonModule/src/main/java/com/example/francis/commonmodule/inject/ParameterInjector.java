package com.example.francis.commonmodule.inject;

import android.app.Activity;

/**
 * Created by Francis on 2018/3/17.
 */

public class ParameterInjector
{
    private static final String SUFFIX = "$$ParameterInject";

    public static void injectParameter(Activity activity)
    {
        ParameterInject proxyActivity = findProxyActivity(activity);
        proxyActivity.inject(activity);
    }

    private static ParameterInject findProxyActivity(Object activity)
    {
        try
        {
            Class clazz = activity.getClass();
            Class injectorClazz = Class.forName(clazz.getName() + SUFFIX);
            return (ParameterInject) injectorClazz.newInstance();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        throw new RuntimeException(String.format("can not find %s , something when compiler.", activity.getClass().getSimpleName() + SUFFIX));
    }
}
