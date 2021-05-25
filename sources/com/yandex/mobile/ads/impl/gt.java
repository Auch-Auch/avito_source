package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.TimeUnit;
public final class gt implements gw {
    private static final long a = TimeUnit.SECONDS.toMillis(1);
    private static final Object b = new Object();
    private static volatile gt c;
    @NonNull
    private final Handler d = new Handler(Looper.getMainLooper());
    @NonNull
    private final gy e;
    @NonNull
    private final gx f;
    @Nullable
    private gs g;
    private boolean h;

    private gt(@NonNull Context context) {
        this.e = new gy(context);
        this.f = new gx();
    }

    @NonNull
    public static gt a(@NonNull Context context) {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new gt(context);
                }
            }
        }
        return c;
    }

    public final void b(@NonNull gz gzVar) {
        synchronized (b) {
            this.f.b(gzVar);
        }
    }

    private void b() {
        this.d.removeCallbacksAndMessages(null);
        this.h = false;
    }

    public final void a(@NonNull gz gzVar) {
        synchronized (b) {
            gs gsVar = this.g;
            if (gsVar != null) {
                gzVar.a(gsVar);
            } else {
                this.f.a(gzVar);
                if (!this.h) {
                    this.h = true;
                    this.d.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.gt.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            gt.this.a();
                        }
                    }, a);
                    this.e.a(this);
                }
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.gw
    public final void a(@NonNull gs gsVar) {
        synchronized (b) {
            this.g = gsVar;
            b();
            this.f.a(gsVar);
        }
    }

    @Override // com.yandex.mobile.ads.impl.gw
    public final void a() {
        synchronized (b) {
            b();
            this.f.a();
        }
    }
}
