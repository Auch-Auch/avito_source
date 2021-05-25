package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.yandex.mobile.ads.impl.ox;
import com.yandex.mobile.ads.nativeads.ba;
import com.yandex.mobile.ads.nativeads.bo;
import com.yandex.mobile.ads.nativeads.template.NativeBannerView;
import com.yandex.mobile.ads.nativeads.template.c;
import java.util.Collections;
public abstract class n extends ba implements az, y {
    @NonNull
    public j a;
    @NonNull
    private final w b;
    @NonNull
    private final f c;
    @NonNull
    private final bo d;
    @NonNull
    private final ap e;

    public n(@NonNull Context context, @NonNull ox oxVar, @NonNull w wVar, @NonNull j jVar, @NonNull c cVar) {
        super(context, cVar);
        this.b = wVar;
        this.a = jVar;
        p a3 = cVar.a();
        this.c = f.a(a3.c().d());
        ap apVar = new ap(Collections.singletonList(oxVar), a3.a());
        NativeAdType b2 = oxVar.b();
        if (b2 != null) {
            apVar.a(b2.getValue());
        }
        this.e = apVar;
        a(apVar);
        this.d = new bo();
    }

    @Override // com.yandex.mobile.ads.nativeads.y
    public final void a(@NonNull NativeBannerView nativeBannerView) throws NativeAdException {
        c cVar = new c();
        nativeBannerView.a((NativeBannerView) this);
        a((n) nativeBannerView, (ak<n>) cVar, this.c, ba.a.TEMPLATE);
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeGenericAd
    public void addImageLoadingListener(NativeAdImageLoadingListener nativeAdImageLoadingListener) {
        this.b.a(nativeAdImageLoadingListener);
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeGenericAd
    public void bindNativeAd(@NonNull NativeAdViewBinder nativeAdViewBinder) throws NativeAdException {
        View nativeAdView = nativeAdViewBinder.getNativeAdView();
        this.d.a(nativeAdView, new bo.b() { // from class: com.yandex.mobile.ads.nativeads.n.1
            @Override // com.yandex.mobile.ads.nativeads.bo.b
            public final void a() {
                n.this.b();
            }

            @Override // com.yandex.mobile.ads.nativeads.bo.b
            public final void b() {
                n.this.c();
            }
        });
        a((n) nativeAdView, (ak<n>) new ai(nativeAdViewBinder), f.a(), ba.a.CUSTOM);
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeGenericAd
    public NativeAdAssets getAdAssets() {
        return this.b.d();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeGenericAd
    public NativeAdType getAdType() {
        return this.b.a();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeGenericAd
    public String getInfo() {
        return this.b.b();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeGenericAd
    public void loadImages() {
        this.b.c();
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeGenericAd
    public void removeImageLoadingListener(NativeAdImageLoadingListener nativeAdImageLoadingListener) {
        this.b.b(nativeAdImageLoadingListener);
    }

    public final void a(@NonNull u uVar, @NonNull ak akVar) throws NativeAdException {
        a((n) uVar, (ak<n>) akVar, f.a(), ba.a.CUSTOM);
    }

    private <T extends View> void a(@NonNull T t, @NonNull ak<T> akVar, @NonNull f fVar, @NonNull ba.a aVar) throws NativeAdException {
        this.e.a(aVar);
        a((n) t, this.a, (ak<n>) akVar, fVar);
    }

    @Override // com.yandex.mobile.ads.nativeads.ba
    public final void a(@NonNull Context context) {
        this.d.a(context);
        super.a(context);
    }
}
