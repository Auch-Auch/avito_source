package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class jr implements Runnable {
    private final int a;
    @Nullable
    private final String b;
    @NonNull
    private final jp c;

    public jr(int i, @Nullable String str, @NonNull jp jpVar) {
        this.a = i;
        this.b = str;
        this.c = jpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.b(this.a, this.b);
    }
}
