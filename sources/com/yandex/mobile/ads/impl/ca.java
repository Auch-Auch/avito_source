package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
public final class ca {
    @NonNull
    public static String a(@NonNull byte[] bArr) {
        try {
            return c(bArr);
        } catch (Exception unused) {
            return new String(bArr);
        }
    }

    @Nullable
    private static String b(@NonNull byte[] bArr) {
        try {
            return c(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @NonNull
    private static String c(@NonNull byte[] bArr) throws UnsupportedEncodingException {
        return new String(Base64.decode(bArr, 0), "UTF-8");
    }

    @Nullable
    public static String a(@NonNull String str) {
        return b(str.getBytes());
    }
}
