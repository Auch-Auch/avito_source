package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdEventListener;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.hv;
public final class c implements AdEventListener {
    @NonNull
    private final Object a = new Object();
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper());
    @NonNull
    private final ct c;
    @Nullable
    private AdEventListener d;

    public c(@NonNull Context context) {
        this.c = new ct(context);
    }

    @Nullable
    public final AdEventListener c() {
        return this.d;
    }

    @Override // com.yandex.mobile.ads.AdEventListener
    public final void onAdClosed() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.c.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (c.this.a) {
                    if (c.this.d != null) {
                        c.this.d.onAdClosed();
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.AdEventListener
    public final void onAdFailedToLoad(@NonNull final AdRequestError adRequestError) {
        this.c.a(adRequestError);
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.c.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (c.this.a) {
                    if (c.this.d != null) {
                        c.this.d.onAdFailedToLoad(adRequestError);
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.AdEventListener
    public final void onAdLeftApplication() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.c.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (c.this.a) {
                    if (c.this.d != null) {
                        c.this.d.onAdLeftApplication();
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.AdEventListener
    public final void onAdLoaded() {
        this.c.a();
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.c.6
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (c.this.a) {
                    if (c.this.d != null) {
                        c.this.d.onAdLoaded();
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.AdEventListener
    public final void onAdOpened() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.c.7
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (c.this.a) {
                    if (c.this.d != null) {
                        c.this.d.onAdOpened();
                    }
                }
            }
        });
    }

    public final void a(@NonNull fo foVar) {
        this.c.a(foVar);
    }

    public final void b() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.c.4
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (c.this.a) {
                    if (c.this.d != null) {
                        Cif.a(c.this.d, "onAdapterImpressionTracked", new Object[0]);
                    }
                }
            }
        });
    }

    public final void a(@NonNull hv.a aVar) {
        this.c.a(aVar);
    }

    public final void a() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.c.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (c.this.a) {
                    if (c.this.d != null) {
                        Cif.a(c.this.d, "onAdImpressionTracked", new Object[0]);
                    }
                }
            }
        });
    }

    public final void a(@Nullable AdEventListener adEventListener) {
        this.d = adEventListener;
    }
}
