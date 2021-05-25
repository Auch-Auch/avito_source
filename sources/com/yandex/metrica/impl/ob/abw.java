package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
public class abw {
    @Nullable
    public static <T> T a(@Nullable T t, @Nullable T t2) {
        return t == null ? t2 : t;
    }

    @NonNull
    public static String a(@Nullable String str, @NonNull String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    @NonNull
    public static <T> T b(@Nullable T t, @NonNull T t2) {
        return (T) c(t, t2);
    }

    @NonNull
    private static <T> T c(@Nullable T t, @NonNull T t2) {
        return t == null ? t2 : t;
    }

    public static long a(@Nullable Long l, @NonNull TimeUnit timeUnit, long j) {
        return l == null ? j : timeUnit.toMillis(l.longValue());
    }
}
