package com.potoyang.common.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by potoyang on 2017/11/24.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@EventType(listenerType = View.OnClickListener.class,
        listenerSetter = "setOnClickListener",
        methodName = "onClick")
public @interface onClick {
    int[] value();
}
