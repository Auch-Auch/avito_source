package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
public final class cb {
    @Nullable
    public static String a(@NonNull String str) {
        return a(str.getBytes());
    }

    @Nullable
    private static String a(@NonNull byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 2);
        } catch (Throwable unused) {
            return null;
        }
    }
}
