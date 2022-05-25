package com.zhstzzy.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
    public static String md5(String text) {
        String md5str = DigestUtils.md5Hex(text);
        return md5str;
    }

    public static boolean verify(String text, String md5) {
        String md5str = md5(text);
        if (md5str.equalsIgnoreCase(md5)) {
            return true;
        }
        return false;
    }

}