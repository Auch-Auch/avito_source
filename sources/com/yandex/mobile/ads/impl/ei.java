package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.VideoEventListener;
public final class ei implements ej {
    private static final Object a = new Object();
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper());
    @Nullable
    private VideoEventListener c;

    public final void a(@Nullable VideoEventListener videoEventListener) {
        synchronized (a) {
            this.c = videoEventListener;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ej
    public final void a() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.ei.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (ei.a) {
                    if (ei.this.c != null) {
                        ei.this.c.onVideoComplete();
                    }
                }
            }
        });
    }
}
