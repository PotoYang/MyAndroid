package com.potoyang.common.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.potoyang.common.config.Config;
import com.potoyang.common.security.SecurityUtil;

/**
 * Created by potoyang on 2017/11/23.
 */

public class SharedPreferencesUtil {

    private static final String SHARED_PREFERENCE_NAME = Config.SHARED_APP_PREFERENCE_NAME;

    /**
     * 添加数据
     *
     * @param context
     * @param key
     * @param value
     */
    public static void addValue(Context context, String key, String value) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(
                    SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, value);
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加加密数据
     *
     * @param context
     * @param key
     * @param value
     */
    public static void addEncryptValue(Context context, String key, String value) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(
                    SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, SecurityUtil.encrypt(value));
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据
     *
     * @param context
     * @param key
     * @return
     */
    public static String getValue(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);

        String result = sharedPreferences.getString(key, null);
        return result;
    }

    /**
     * 获取加密数据
     *
     * @param context
     * @param key
     * @return
     */
    public static String getEncryptValue(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);

        String result = sharedPreferences.getString(key, null);
        result = SecurityUtil.decrypt(result);
        return result;
    }

    /**
     * 删除数据
     *
     * @param context
     * @param key
     */
    public static void removeValue(Context context, String key) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(
                    SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(key);
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
