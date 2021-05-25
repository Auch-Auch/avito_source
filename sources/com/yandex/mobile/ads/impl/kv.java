package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public abstract class kv<T, V> {
    private static final ou a = null;

    @NonNull
    public static oq<T> a(@NonNull String str, @NonNull String str2, @NonNull T t) {
        return new oq<>(str, str2, t, a, false, false);
    }

    @NonNull
    public abstract oq<T> a(@NonNull String str, @NonNull V v);
}
