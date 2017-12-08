package com.potoyang.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by potoyang on 2017/11/24.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface InjectView {
    int value();
}
