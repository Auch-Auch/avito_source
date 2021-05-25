package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class jv {
    private static final Object a = new Object();
    private static volatile jv b;
    @Nullable
    private x<String> c;
    @Nullable
    private fo d;

    private jv() {
    }

    @NonNull
    public static jv a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new jv();
                }
            }
        }
        return b;
    }

    @Nullable
    public final x<String> b() {
        x<String> xVar;
        synchronized (a) {
            xVar = this.c;
        }
        return xVar;
    }

    @Nullable
    public final fo c() {
        fo foVar;
        synchronized (a) {
            foVar = this.d;
        }
        return foVar;
    }

    public final void a(@NonNull x<String> xVar) {
        synchronized (a) {
            this.c = xVar;
        }
    }

    public final void a(@NonNull fo foVar) {
        synchronized (a) {
            this.d = foVar;
        }
    }
}
