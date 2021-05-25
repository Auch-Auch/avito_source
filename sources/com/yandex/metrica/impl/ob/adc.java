package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public abstract class adc<T> implements adn<T> {
    @NonNull
    public final abl a;
    private final int b;
    private final String c;

    public adc(int i, @NonNull String str, @NonNull abl abl) {
        this.b = i;
        this.c = str;
        this.a = abl;
    }

    @VisibleForTesting(otherwise = 3)
    public int a() {
        return this.b;
    }

    @VisibleForTesting(otherwise = 3)
    @NonNull
    public String b() {
        return this.c;
    }
}
