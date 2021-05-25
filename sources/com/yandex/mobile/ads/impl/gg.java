package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.Callable;
public final class gg {
    @Nullable
    public static <T, S> S a(@NonNull Callable<S> callable, @Nullable T t) {
        if (t == null) {
            return null;
        }
        try {
            return callable.call();
        } catch (Throwable unused) {
            return null;
        }
    }
}
