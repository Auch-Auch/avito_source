package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.bd;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.impl.lw;
import com.yandex.mobile.ads.impl.oy;
import com.yandex.mobile.ads.impl.x;
import com.yandex.mobile.ads.mediation.nativeads.e;
import com.yandex.mobile.ads.mediation.nativeads.g;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import com.yandex.mobile.ads.nativeads.i;
import com.yandex.mobile.ads.nativeads.r;
import com.yandex.mobile.ads.nativeads.t;
import com.yandex.mobile.ads.nativeads.v;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class s implements MediatedNativeAdapterListener {
    @NonNull
    private final bd<MediatedNativeAdapter, MediatedNativeAdapterListener> a;
    @NonNull
    private final WeakReference<v> b;
    @NonNull
    private final f c;
    @NonNull
    private final i d;
    @NonNull
    private final g e;
    @NonNull
    private final Map<String, Object> f = new HashMap();
    @NonNull
    private final Map<String, Object> g = new HashMap();
    @NonNull
    private final i h;
    @NonNull
    private final h i;
    private boolean j;

    public s(@NonNull v vVar, @NonNull bd<MediatedNativeAdapter, MediatedNativeAdapterListener> bdVar) {
        Context n = vVar.n();
        this.a = bdVar;
        this.b = new WeakReference<>(vVar);
        this.c = new f();
        i iVar = new i(n);
        this.d = iVar;
        this.h = new i();
        h hVar = new h(n);
        this.i = hVar;
        this.e = new g(n, iVar, hVar);
    }

    private void a(@NonNull Context context, @NonNull hv.b bVar) {
        HashMap hashMap = new HashMap(this.f);
        hashMap.put("event_type", bVar.a());
        hashMap.put("ad_info", this.g);
        this.a.b(context, hashMap);
    }

    @Override // com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdClicked() {
        v vVar = this.b.get();
        if (vVar != null) {
            Context n = vVar.n();
            this.a.a(n, this.f);
            a(n, hv.b.CLICK);
        }
        this.c.a();
    }

    @Override // com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdClosed() {
        this.c.b();
    }

    @Override // com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {
        v vVar = this.b.get();
        if (vVar != null) {
            this.a.a(vVar.n(), adRequestError, (AdRequestError) this);
        }
    }

    @Override // com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdImpression() {
        if (!this.j) {
            this.j = true;
            v vVar = this.b.get();
            if (vVar != null) {
                Context n = vVar.n();
                this.a.c(n, this.f);
                a(n, hv.b.IMPRESSION_TRACKING_SUCCESS);
            }
            this.c.c();
        }
    }

    @Override // com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdLeftApplication() {
        this.c.d();
    }

    @Override // com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdOpened() {
        this.c.e();
    }

    @Override // com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAppInstallAdLoaded(@NonNull MediatedNativeAd mediatedNativeAd) {
        a(mediatedNativeAd, NativeAdType.APP_INSTALL);
    }

    @Override // com.yandex.mobile.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onContentAdLoaded(@NonNull MediatedNativeAd mediatedNativeAd) {
        a(mediatedNativeAd, NativeAdType.CONTENT);
    }

    private void a(@NonNull final MediatedNativeAd mediatedNativeAd, @NonNull NativeAdType nativeAdType) {
        final v vVar = this.b.get();
        if (vVar != null) {
            Context n = vVar.n();
            this.f.put("native_ad_type", nativeAdType.getValue());
            this.a.d(n, this.f);
            this.g.putAll(a(mediatedNativeAd));
            List<MediatedNativeAdImage> a3 = i.a(mediatedNativeAd);
            a(a3);
            this.e.a(mediatedNativeAd, nativeAdType, a3, new g.a() { // from class: com.yandex.mobile.ads.mediation.nativeads.s.1
                @Override // com.yandex.mobile.ads.mediation.nativeads.g.a
                public final void a(@NonNull x<oy> xVar) {
                    vVar.a(xVar, new t(new e(s.a(s.this)), new p(mediatedNativeAd), new lw(), new o()));
                }
            });
        }
    }

    private void a(@NonNull List<MediatedNativeAdImage> list) {
        this.d.a(h.a(list));
    }

    @NonNull
    private static Map<String, Object> a(@NonNull MediatedNativeAd mediatedNativeAd) {
        HashMap hashMap = new HashMap();
        hashMap.put("title", mediatedNativeAd.getMediatedNativeAdAssets().getTitle());
        return hashMap;
    }

    public static /* synthetic */ e.a a(s sVar) {
        return new e.a() { // from class: com.yandex.mobile.ads.mediation.nativeads.s.2
            @Override // com.yandex.mobile.ads.mediation.nativeads.e.a
            public final void a(@NonNull r rVar) {
                s.this.c.a(rVar);
            }
        };
    }
}
