package com.potoyang.common.annotation;

import android.app.Activity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by potoyang on 2017/11/24.
 */

public class MyAnnotation {
    public static void injectView(Activity activity) {
        if (null == activity) {
            return;
        }

        Class<? extends Activity> activityClass = activity.getClass();
        Field[] declaredFilds = activityClass.getDeclaredFields();
        for (Field field : declaredFilds) {
            if (field.isAnnotationPresent(InjectView.class)) {
                //找到InjectView注解field
                InjectView injectViewAnnotation = field.getAnnotation(InjectView.class);
                //找到button的id
                int value = injectViewAnnotation.value();
                try {
                    //找到findViewById方法
                    Method findViewByIdMethod = activityClass.getMethod("findViewById", int.class);
                    findViewByIdMethod.setAccessible(true);
                    findViewByIdMethod.invoke(activity, value);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
