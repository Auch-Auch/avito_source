package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.ct;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.impl.v;
import com.yandex.mobile.ads.nativeads.NativeAdLoader;
public final class x {
    private static final Object a = new Object();
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper());
    @NonNull
    private final ct c;
    @Nullable
    private NativeAdLoader.OnLoadListener d;
    @Nullable
    private NativeAdUnitLoadListener e;

    public x(@NonNull Context context) {
        this.c = new ct(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(@NonNull final AdRequestError adRequestError) {
        this.c.a(adRequestError);
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.nativeads.x.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (x.a) {
                    if (x.this.d != null) {
                        x.this.d.onAdFailedToLoad(adRequestError);
                    }
                    if (x.this.e != null) {
                        x.this.e.onNativeAdUnitFailedToLoad(adRequestError);
                    }
                }
            }
        });
    }

    public final void a(@NonNull fo foVar) {
        this.c.a(foVar);
    }

    public final void a(@NonNull hv.a aVar) {
        this.c.a(aVar);
    }

    public final void a(@Nullable NativeAdLoader.OnLoadListener onLoadListener) {
        synchronized (a) {
            this.d = onLoadListener;
        }
    }

    public final void a(@Nullable NativeAdUnitLoadListener nativeAdUnitLoadListener) {
        synchronized (a) {
            this.e = nativeAdUnitLoadListener;
        }
    }

    public final void a() {
        this.b.removeCallbacksAndMessages(null);
    }

    public final void a(@NonNull AdRequestError adRequestError) {
        b(adRequestError);
    }

    public final void a(@NonNull final NativeGenericAd nativeGenericAd) {
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.nativeads.x.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (x.a) {
                    if (x.this.d != null) {
                        NativeGenericAd nativeGenericAd2 = nativeGenericAd;
                        if (nativeGenericAd2 instanceof NativeContentAd) {
                            x.this.c.a();
                            x.this.d.onContentAdLoaded((NativeContentAd) nativeGenericAd);
                        } else if (nativeGenericAd2 instanceof NativeAppInstallAd) {
                            x.this.c.a();
                            x.this.d.onAppInstallAdLoaded((NativeAppInstallAd) nativeGenericAd);
                        } else if ((nativeGenericAd2 instanceof NativeImageAd) && (x.this.d instanceof NativeAdLoader.OnImageAdLoadListener)) {
                            x.this.c.a();
                            ((NativeAdLoader.OnImageAdLoadListener) x.this.d).onImageAdLoaded((NativeImageAd) nativeGenericAd);
                        } else if (!(nativeGenericAd instanceof bd) || !(x.this.d instanceof bi)) {
                            x.this.b(v.a);
                        } else {
                            x.this.c.a();
                            NativeAdLoader.OnLoadListener unused = x.this.d;
                        }
                    }
                }
            }
        });
    }

    public final void a(@NonNull final NativeAdUnit nativeAdUnit) {
        this.c.a();
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.nativeads.x.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (x.a) {
                    if (x.this.e != null) {
                        x.this.e.onNativeAdUnitLoaded(nativeAdUnit);
                    }
                }
            }
        });
    }
}
