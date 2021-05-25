package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.InterstitialEventListener;
import com.yandex.mobile.ads.impl.hv;
public final class jy implements im {
    @NonNull
    private final Object a = new Object();
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper());
    @NonNull
    private final ct c;
    @Nullable
    private InterstitialEventListener d;

    public jy(@NonNull Context context) {
        this.c = new ct(context);
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void c() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.jy.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (jy.this.a) {
                    if (jy.this.d != null) {
                        Cif.a(jy.this.d, "onAdImpressionTracked", new Object[0]);
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void d() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.jy.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (jy.this.a) {
                    if (jy.this.d != null) {
                        Cif.a(jy.this.d, "onAdapterImpressionTracked", new Object[0]);
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void e() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.jy.8
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (jy.this.a) {
                    if (jy.this.d != null) {
                        jy.this.d.onAdLeftApplication();
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void f() {
        this.c.a();
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.jy.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (jy.this.a) {
                    if (jy.this.d != null) {
                        jy.this.d.onInterstitialLoaded();
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void g() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.jy.9
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (jy.this.a) {
                    if (jy.this.d != null) {
                        jy.this.d.onAdOpened();
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void h() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.jy.6
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (jy.this.a) {
                    if (jy.this.d != null) {
                        jy.this.d.onInterstitialShown();
                    }
                }
            }
        });
    }

    @Nullable
    public final InterstitialEventListener i() {
        InterstitialEventListener interstitialEventListener;
        synchronized (this.a) {
            interstitialEventListener = this.d;
        }
        return interstitialEventListener;
    }

    public final void a(@NonNull fo foVar) {
        this.c.a(foVar);
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void b() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.jy.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (jy.this.a) {
                    if (jy.this.d != null) {
                        jy.this.d.onInterstitialDismissed();
                    }
                }
            }
        });
    }

    public final void a(@NonNull hv.a aVar) {
        this.c.a(aVar);
    }

    public final void a(@Nullable InterstitialEventListener interstitialEventListener) {
        synchronized (this.a) {
            this.d = interstitialEventListener;
        }
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void a(@NonNull final AdRequestError adRequestError) {
        this.c.a(adRequestError);
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.jy.4
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (jy.this.a) {
                    if (jy.this.d != null) {
                        jy.this.d.onInterstitialFailedToLoad(adRequestError);
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void a() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.jy.7
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (jy.this.a) {
                    if (jy.this.d != null) {
                        jy.this.d.onAdClosed();
                    }
                }
            }
        });
    }
}
