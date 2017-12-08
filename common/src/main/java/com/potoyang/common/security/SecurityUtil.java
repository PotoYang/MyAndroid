package com.potoyang.common.security;

import android.text.TextUtils;

import com.potoyang.common.config.Config;
import com.potoyang.common.util.Base64Util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by potoyang on 2017/11/17.
 */

public class SecurityUtil {
    private static final String CHARSET = Config.CHARSET;
    private static String key = null;

    /**
     * 对文本信息进行加密
     *
     * @param text
     * @return
     */
    public static String encrypt(String text) {
        if (TextUtils.isEmpty(text)) {
            return null;
        }
        try {
            byte[] my_aes_key = getKey().getBytes(CHARSET);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(my_aes_key, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(my_aes_key);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            String finalText = text + PKCS7Padding.encodePadding(text.length());
            byte[] b = cipher.doFinal(finalText.getBytes(CHARSET));

            byte[] base64 = Base64Util.encode(b);

            return new String(base64, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对密文进行解密
     *
     * @param encodeText
     * @return
     */
    public static String decrypt(String encodeText) {
        if (TextUtils.isEmpty(encodeText)){
            return null;
        }
        try {
            byte[] my_aes_key = getKey().getBytes(CHARSET);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(my_aes_key, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(my_aes_key);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] decryptContent = Base64Util.decode(encodeText);
            byte[] original = cipher.doFinal(decryptContent);

            byte[] result = PKCS7Padding.decode(original);

            return new String(result, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取jni--C++源码返回的key
     *
     * @return
     */
    private static String getKey() {
        if (key == null) {
            key = EncryptKey.getKey();
        }

        return key;
    }
}
