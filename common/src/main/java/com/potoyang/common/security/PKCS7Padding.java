package com.potoyang.common.security;

import com.potoyang.common.config.Config;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by potoyang on 2017/11/23.
 */

public class PKCS7Padding {

    private static final String CHARSET = Config.CHARSET;
    private static final int BLOCK_SIZE = 32;

    /**
     * 加密密文填充内容生成
     *
     * @param count
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encodePadding(int count) throws UnsupportedEncodingException {
        int paddingCount = BLOCK_SIZE - (count % BLOCK_SIZE);
        if (paddingCount == 0) {
            paddingCount = BLOCK_SIZE;
        }

        char paddingChar = getPaddingChar(paddingCount);
        String temp = new String();
        for (int index = 0; index < paddingCount; index++) {
            temp += Character.toString(paddingChar);
        }

        return temp;
    }

    /**
     * 去除拼接字符进行解密
     *
     * @param content
     * @return
     */
    public static byte[] decode(byte[] content) {
        int paddingCount = (int) content[content.length - 1];
        if (paddingCount < 1 || paddingCount > 32) {
            paddingCount = 0;
        }
        return Arrays.copyOfRange(content, 0, content.length - paddingCount);
    }

    /**
     * 返回传入数字的ASCII编码
     *
     * @param count
     * @return
     */
    private static char getPaddingChar(int count) {
        return (char) (count & 0xFF);
    }
}
