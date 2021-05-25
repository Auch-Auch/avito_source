package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class jq {
    @NonNull
    private final jp a;
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper());
    @NonNull
    private final kc c = new kc();
    @NonNull
    private final jo d = new jo();
    private boolean e;

    public jq(@NonNull jp jpVar) {
        this.a = jpVar;
    }

    public final void a(int i, String str) {
        this.e = true;
        this.b.removeCallbacks(this.d);
        this.b.post(new jr(i, str, this.a));
    }

    public final void b() {
        this.b.removeCallbacksAndMessages(null);
        this.d.a(null);
    }

    public final void a() {
        if (!this.e) {
            this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.jq.1
                @Override // java.lang.Runnable
                public final void run() {
                    jq.this.b.postDelayed(jq.this.d, 10000);
                }
            });
        }
    }

    public final void a(@Nullable er erVar) {
        this.d.a(erVar);
    }
}
