package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Locale;
import java.util.regex.Pattern;
public final class dh {
    public static final Pattern a = Pattern.compile("[^0-9a-zA-Z,`’\\.\\+\\-'\\s\"]");
    public static final Pattern b = Pattern.compile("\\s+");

    public static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static String b(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String c(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    @NonNull
    public static byte[] d(@Nullable String str) {
        return str == null ? new byte[0] : str.getBytes();
    }

    public static byte[] e(@NonNull String str) {
        if (str.length() % 2 == 0) {
            int length = str.length();
            byte[] bArr = new byte[(length / 2)];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
            }
            return bArr;
        }
        throw new IllegalArgumentException("Input string must contain an even number of characters");
    }

    public static boolean a(String... strArr) {
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] c(@Nullable String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8");
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }

    public static int d(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2 == null ? 0 : -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    public static String a(String str) {
        return b(str, "");
    }

    public static String a(@NonNull byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append("0123456789abcdef".charAt((b2 & 240) >> 4));
            sb.append("0123456789abcdef".charAt(b2 & Ascii.SI));
        }
        return sb.toString();
    }

    public static final String b(String... strArr) {
        return TextUtils.join(",", strArr);
    }

    public static String b(@NonNull byte[] bArr) {
        return a(bArr).toUpperCase(Locale.US).replaceAll("(.{2})(?=.+)", "$1:");
    }
}
