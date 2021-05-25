package com.yandex.mobile.ads.rewarded;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.Cif;
import com.yandex.mobile.ads.impl.ct;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.impl.im;
public final class a implements im {
    @NonNull
    private final Object a = new Object();
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper());
    @Nullable
    private RewardedAdEventListener c;
    @NonNull
    private final ct d;

    public a(@NonNull Context context) {
        this.d = new ct(context);
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void c() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.rewarded.a.7
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.this.a) {
                    if (a.this.c != null) {
                        Cif.a(a.this.c, "onAdImpressionTracked", new Object[0]);
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void d() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.rewarded.a.8
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.this.a) {
                    if (a.this.c != null) {
                        Cif.a(a.this.c, "onAdapterImpressionTracked", new Object[0]);
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void e() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.rewarded.a.9
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.this.a) {
                    if (a.this.c != null) {
                        a.this.c.onAdLeftApplication();
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void f() {
        this.d.a();
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.rewarded.a.4
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.this.a) {
                    if (a.this.c != null) {
                        a.this.c.onAdLoaded();
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void g() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.rewarded.a.10
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.this.a) {
                    if (a.this.c != null) {
                        a.this.c.onAdOpened();
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void h() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.rewarded.a.5
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.this.a) {
                    if (a.this.c != null) {
                        a.this.c.onAdShown();
                    }
                }
            }
        });
    }

    public final void a(@NonNull fo foVar) {
        this.d.a(foVar);
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void b() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.rewarded.a.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.this.a) {
                    if (a.this.c != null) {
                        a.this.c.onAdDismissed();
                    }
                }
            }
        });
    }

    public final void a(@NonNull hv.a aVar) {
        this.d.a(aVar);
    }

    public final void a(@Nullable RewardedAdEventListener rewardedAdEventListener) {
        synchronized (this.a) {
            this.c = rewardedAdEventListener;
        }
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void a(@NonNull final AdRequestError adRequestError) {
        this.d.a(adRequestError);
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.rewarded.a.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.this.a) {
                    if (a.this.c != null) {
                        a.this.c.onAdFailedToLoad(adRequestError);
                    }
                }
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.im
    public final void a() {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.rewarded.a.6
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.this.a) {
                    if (a.this.c != null) {
                        a.this.c.onAdClosed();
                    }
                }
            }
        });
    }

    public final void a(@NonNull final Reward reward) {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.rewarded.a.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (a.this.a) {
                    if (a.this.c != null) {
                        a.this.c.onRewarded(reward);
                    }
                }
            }
        });
    }
}
