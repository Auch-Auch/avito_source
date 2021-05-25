package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.mobile.ads.nativeads.NativeAdLoaderConfiguration;
import com.yandex.mobile.ads.nativeads.bj;
import com.yandex.mobile.ads.nativeads.d;
import com.yandex.mobile.ads.nativeads.i;
import com.yandex.mobile.ads.nativeads.p;
import com.yandex.mobile.ads.nativeads.t;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
public final class nk {
    @NonNull
    private final Executor a = Executors.newSingleThreadExecutor(new dz("YandexMobileAds.BaseController"));
    @NonNull
    private final fo b;
    @NonNull
    private final nl c;
    @NonNull
    private final no d;
    @NonNull
    private final NativeAdLoaderConfiguration e;

    @VisibleForTesting
    public class a implements Runnable {
        @NonNull
        private final t b;
        @NonNull
        private final WeakReference<Context> c;
        @NonNull
        private final x<oy> d;
        @NonNull
        private final nj e;

        public a(Context context, @NonNull x<oy> xVar, @NonNull t tVar, @NonNull nj njVar) {
            this.d = xVar;
            this.b = tVar;
            this.c = new WeakReference<>(context);
            this.e = njVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context = this.c.get();
            if (context != null) {
                try {
                    oy p = this.d.p();
                    if (p == null) {
                        this.e.a(v.e);
                    } else if (id.a(p.c())) {
                        this.e.a(v.j);
                    } else {
                        p pVar = new p(p, this.d, nk.this.b);
                        nj njVar = this.e;
                        if (nk.this.e.shouldLoadImagesAutomatically()) {
                            nk.this.d.a(context, pVar, new bj(), this.b, njVar);
                        } else {
                            nk.this.c.a(context, pVar, new d(context), this.b, njVar);
                        }
                    }
                } catch (Exception unused) {
                    this.e.a(v.e);
                }
            }
        }
    }

    public nk(@NonNull Context context, @NonNull fo foVar, @NonNull NativeAdLoaderConfiguration nativeAdLoaderConfiguration) {
        this.b = foVar;
        this.e = nativeAdLoaderConfiguration;
        nl nlVar = new nl(foVar);
        this.c = nlVar;
        this.d = new no(nlVar, new i(context));
    }

    public final void a(@NonNull Context context, @NonNull x<oy> xVar, @NonNull t tVar, @NonNull nj njVar) {
        this.a.execute(new a(context, xVar, tVar, njVar));
    }
}
