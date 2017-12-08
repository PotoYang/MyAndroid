package com.potoyang.myandroid;

import com.potoyang.myandroid.activity.MainActivity;

import org.junit.Test;

/**
 * Created by potoyang on 2017/11/17.
 */

public class JNITest {

    @Test
    public void test01() {
        System.out.println(MainActivity.stringFromJNI());
    }
}
