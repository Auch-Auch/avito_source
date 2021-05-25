package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class acr {
    @NonNull
    private final acq a;
    @Nullable
    private volatile acu b;
    @Nullable
    private volatile act c;
    @Nullable
    private volatile act d;
    @Nullable
    private volatile Handler e;

    public acr() {
        this(new acq());
    }

    @NonNull
    public act a() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = this.a.b();
                }
            }
        }
        return this.c;
    }

    @NonNull
    public acu b() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = this.a.d();
                }
            }
        }
        return this.b;
    }

    @NonNull
    public act c() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = this.a.c();
                }
            }
        }
        return this.d;
    }

    @NonNull
    public Handler d() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.e = this.a.a();
                }
            }
        }
        return this.e;
    }

    @VisibleForTesting
    public acr(@NonNull acq acq) {
        this.a = acq;
    }
}
