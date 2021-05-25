package com.yandex.mobile.ads.nativeads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.ab;
import com.yandex.mobile.ads.impl.af;
import com.yandex.mobile.ads.impl.ag;
import com.yandex.mobile.ads.impl.bx;
import com.yandex.mobile.ads.impl.db;
import com.yandex.mobile.ads.impl.lj;
import com.yandex.mobile.ads.impl.nj;
import com.yandex.mobile.ads.impl.nk;
import com.yandex.mobile.ads.impl.oy;
import com.yandex.mobile.ads.impl.pn;
import com.yandex.mobile.ads.impl.qq;
import com.yandex.mobile.ads.impl.rb;
import com.yandex.mobile.ads.impl.u;
import com.yandex.mobile.ads.impl.x;
import com.yandex.mobile.ads.nativeads.NativeAdLoader;
public final class v extends ab<oy> {
    @NonNull
    private final nj h = new a();
    @NonNull
    private final nk i;
    @NonNull
    private final lj j;
    @NonNull
    private final rb k;
    @NonNull
    private final x l;
    @Nullable
    private db<oy> m;

    @VisibleForTesting
    public class a implements nj {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.nj
        public final void a(@NonNull AdRequestError adRequestError) {
            v.this.onAdFailedToLoad(adRequestError);
        }

        @Override // com.yandex.mobile.ads.impl.nj
        public final void a(@NonNull NativeGenericAd nativeGenericAd) {
            v.this.t();
            v.this.l.a(nativeGenericAd);
        }

        @Override // com.yandex.mobile.ads.impl.nj
        public final void a(@NonNull NativeAdUnit nativeAdUnit) {
            v.this.t();
            v.this.l.a(nativeAdUnit);
        }
    }

    public v(@NonNull Context context, @NonNull NativeAdLoaderConfiguration nativeAdLoaderConfiguration, @NonNull x xVar) {
        super(context, b.NATIVE);
        this.l = xVar;
        a_(nativeAdLoaderConfiguration.getBlockId());
        this.f.a(nativeAdLoaderConfiguration.getImageSizes());
        this.f.b(nativeAdLoaderConfiguration.shouldLoadImagesAutomatically());
        this.f.b(qq.a(context).a());
        this.i = new nk(context, s(), nativeAdLoaderConfiguration);
        this.j = new lj();
        rb rbVar = new rb();
        this.k = rbVar;
        xVar.a(rbVar);
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public final boolean d(@Nullable AdRequest adRequest) {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.ab
    @SuppressLint({"VisibleForTests"})
    public final boolean o() {
        return p();
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public final void a(@NonNull x<oy> xVar) {
        this.k.a(xVar);
        if (!m()) {
            lj.a(xVar).a(this).a(this.b, xVar);
        }
    }

    public final void a(@NonNull x<oy> xVar, @NonNull t tVar) {
        if (!m()) {
            this.i.a(this.b, xVar, tVar, this.h);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ab
    @NonNull
    public final bx<oy> a(String str, String str2) {
        return new pn(this.b, this.m, this.f, str, str2, this);
    }

    public final void a(@Nullable AdRequest adRequest, @NonNull db<oy> dbVar, @NonNull af afVar, @NonNull ag agVar) {
        this.m = dbVar;
        if (dbVar.a()) {
            this.f.a(afVar);
            this.f.a(agVar);
            a(adRequest);
            return;
        }
        onAdFailedToLoad(com.yandex.mobile.ads.impl.v.j);
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public final synchronized void a(@Nullable AdRequest adRequest) {
        b(adRequest);
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public final void a(@NonNull AdRequestError adRequestError) {
        this.l.a(adRequestError);
    }

    public final void a(@Nullable NativeAdLoader.OnLoadListener onLoadListener) {
        this.l.a(onLoadListener);
    }

    public final void a(@Nullable NativeAdUnitLoadListener nativeAdUnitLoadListener) {
        this.l.a(nativeAdUnitLoadListener);
    }

    public final void a() {
        super.w();
        super.x();
        this.c.a();
        this.e.a();
        this.l.a();
        c(u.a);
    }
}
