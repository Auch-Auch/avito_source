package ru.ok.android.sdk.util;

import java.security.MessageDigest;
public class OkEncryptUtil {
    public static final String toMD5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("md5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                sb.append(String.format("%02X", Byte.valueOf(digest[i])));
            }
            return sb.toString().toLowerCase();
        } catch (Exception unused) {
            return null;
        }
    }
}
