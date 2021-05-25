package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
public class ada {
    @NonNull
    private final acz a;
    @Nullable
    private volatile act b;
    @Nullable
    private volatile Executor c;
    @Nullable
    private volatile act d;
    @Nullable
    private volatile act e;
    @Nullable
    private volatile acu f;
    @Nullable
    private volatile act g;
    @Nullable
    private volatile act h;
    @Nullable
    private volatile act i;
    @Nullable
    private volatile act j;

    public ada() {
        this(new acz());
    }

    @NonNull
    public act a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = this.a.a();
                }
            }
        }
        return this.b;
    }

    @NonNull
    public Executor b() {
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
    public act d() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.e = this.a.d();
                }
            }
        }
        return this.e;
    }

    @NonNull
    public acu e() {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    this.f = this.a.e();
                }
            }
        }
        return this.f;
    }

    @NonNull
    public act f() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.g = this.a.f();
                }
            }
        }
        return this.g;
    }

    @NonNull
    public act g() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.h = this.a.g();
                }
            }
        }
        return this.h;
    }

    @NonNull
    public act h() {
        if (this.i == null) {
            synchronized (this) {
                if (this.i == null) {
                    this.i = this.a.h();
                }
            }
        }
        return this.i;
    }

    @NonNull
    public act i() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = this.a.i();
                }
            }
        }
        return this.j;
    }

    @VisibleForTesting
    public ada(@NonNull acz acz) {
        this.a = acz;
    }

    @NonNull
    public acx a(@NonNull Runnable runnable) {
        return this.a.a(runnable);
    }
}
