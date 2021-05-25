package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.Cif;
import com.yandex.mobile.ads.impl.at;
import com.yandex.mobile.ads.impl.dj;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.impl.ou;
public final class r implements at.a {
    @NonNull
    private final dj a;
    @Nullable
    private NativeAdEventListener b;

    public r(@NonNull Context context, @NonNull fo foVar) {
        this.a = new dj(context, foVar);
    }

    public final void a(@Nullable NativeAdEventListener nativeAdEventListener) {
        this.b = nativeAdEventListener;
    }

    public final void b() {
        NativeAdEventListener nativeAdEventListener = this.b;
        if (nativeAdEventListener != null) {
            nativeAdEventListener.onAdClosed();
        }
        this.a.b();
    }

    public final void c() {
        NativeAdEventListener nativeAdEventListener = this.b;
        if (nativeAdEventListener != null) {
            Cif.a(nativeAdEventListener, "onAdImpressionTracked", new Object[0]);
        }
    }

    public final void d() {
        NativeAdEventListener nativeAdEventListener = this.b;
        if (nativeAdEventListener != null) {
            nativeAdEventListener.onAdLeftApplication();
        }
        this.a.c();
    }

    public final void e() {
        NativeAdEventListener nativeAdEventListener = this.b;
        if (nativeAdEventListener != null) {
            nativeAdEventListener.onAdOpened();
        }
        this.a.a();
    }

    @Override // com.yandex.mobile.ads.impl.at.a
    public final void f() {
        c();
    }

    @Override // com.yandex.mobile.ads.impl.at.a
    public final void g() {
        NativeAdEventListener nativeAdEventListener = this.b;
        if (nativeAdEventListener != null) {
            Cif.a(nativeAdEventListener, "onAdapterImpressionTracked", new Object[0]);
        }
    }

    public final void h() {
        NativeAdEventListener nativeAdEventListener = this.b;
        if (nativeAdEventListener instanceof ClosableNativeAdEventListener) {
            ((ClosableNativeAdEventListener) nativeAdEventListener).closeNativeAd();
        }
    }

    public final void i() {
        this.a.e();
    }

    public final void a(@NonNull hv.a aVar) {
        this.a.a(aVar);
    }

    public final void a() {
        this.a.d();
    }

    public final void a(@NonNull ou ouVar) {
        this.a.a(ouVar.b());
    }
}
