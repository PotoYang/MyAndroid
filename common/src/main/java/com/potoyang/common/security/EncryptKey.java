package com.potoyang.common.security;

/**
 * Created by potoyang on 2017/11/17.
 */

public class EncryptKey {
    static {
        System.loadLibrary("encrypt_key");
    }

    public static native String getKey();
}
