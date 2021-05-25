package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class fy {
    private static final Object a = new Object();
    @Nullable
    private static volatile fy b;
    @Nullable
    private fz c;
    @NonNull
    private sy d = new ta();
    @Nullable
    private Boolean e;
    private boolean f = true;
    private boolean g;

    private fy() {
    }

    public static fy a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new fy();
                }
            }
        }
        return b;
    }

    public final boolean b() {
        boolean z;
        synchronized (a) {
            z = this.f;
        }
        return z;
    }

    @NonNull
    public final synchronized sy c() {
        sy syVar;
        synchronized (a) {
            syVar = this.d;
        }
        return syVar;
    }

    public final boolean d() {
        boolean z;
        synchronized (a) {
            z = this.g;
        }
        return z;
    }

    @Nullable
    public final Boolean e() {
        Boolean bool;
        synchronized (a) {
            bool = this.e;
        }
        return bool;
    }

    public final void b(boolean z) {
        synchronized (a) {
            this.e = Boolean.valueOf(z);
        }
    }

    @Nullable
    public final fz a(@NonNull Context context) {
        fz fzVar;
        synchronized (a) {
            if (this.c == null) {
                this.c = id.b(context);
            }
            fzVar = this.c;
        }
        return fzVar;
    }

    public final void a(@NonNull Context context, @NonNull fz fzVar) {
        synchronized (a) {
            this.c = fzVar;
            id.a(context, fzVar);
        }
    }

    public final void a(boolean z) {
        synchronized (a) {
            this.g = z;
        }
    }
}
