package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
public final class kg implements kd {
    @NonNull
    private final x a;
    @NonNull
    private final View b;
    @NonNull
    private final Handler c = new Handler(Looper.getMainLooper());
    @NonNull
    private final kh d;
    private boolean e;

    public kg(@NonNull x xVar, @NonNull View view, @NonNull kh khVar) {
        this.a = xVar;
        this.b = view;
        view.setVisibility(8);
        this.d = khVar;
    }

    private void e() {
        this.c.removeCallbacksAndMessages(null);
    }

    @Override // com.yandex.mobile.ads.impl.kd
    public final void b() {
        this.c.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.kg.1
            @Override // java.lang.Runnable
            public final void run() {
                kg.this.b.setVisibility(0);
            }
        }, 200);
    }

    @Override // com.yandex.mobile.ads.impl.kd
    public final void c() {
        e();
    }

    @Override // com.yandex.mobile.ads.impl.kd
    public final boolean d() {
        return this.e && this.a.z();
    }

    @Override // com.yandex.mobile.ads.impl.kd
    @NonNull
    public final View a() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.kd
    public final void a(boolean z) {
        this.e = z;
        e();
        this.b.setVisibility(z ? 8 : 0);
    }
}
