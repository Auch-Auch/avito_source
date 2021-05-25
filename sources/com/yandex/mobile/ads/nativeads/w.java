package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.yandex.mobile.ads.impl.oq;
import com.yandex.mobile.ads.impl.or;
import com.yandex.mobile.ads.impl.ot;
import com.yandex.mobile.ads.impl.ov;
import com.yandex.mobile.ads.impl.ow;
import com.yandex.mobile.ads.impl.ox;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
public final class w {
    @NonNull
    private final ox a;
    @NonNull
    private final j b;
    @NonNull
    private final i c;
    @NonNull
    private final bf d;
    @NonNull
    private final Set<NativeAdImageLoadingListener> e = new CopyOnWriteArraySet();

    public w(@NonNull Context context, @NonNull ox oxVar, @NonNull j jVar, @NonNull bf bfVar) {
        this.a = oxVar;
        this.b = jVar;
        this.d = bfVar;
        this.c = new i(context);
    }

    public final void c() {
        this.c.a(this.c.a(Collections.singletonList(this.a)), new k() { // from class: com.yandex.mobile.ads.nativeads.w.1
            @Override // com.yandex.mobile.ads.nativeads.k
            public final void a(@NonNull Map<String, Bitmap> map) {
                w.this.d.a();
                for (NativeAdImageLoadingListener nativeAdImageLoadingListener : w.this.e) {
                    if (nativeAdImageLoadingListener != null) {
                        nativeAdImageLoadingListener.onFinishLoadingImages();
                    }
                }
            }
        });
    }

    public final NativeAdAssets d() {
        l lVar = new l();
        List<oq> c2 = this.a.c();
        HashMap hashMap = new HashMap();
        for (oq oqVar : c2) {
            hashMap.put(oqVar.a(), oqVar);
        }
        ow owVar = (ow) a((oq) hashMap.get("media"));
        lVar.a((String) a((oq) hashMap.get("age")));
        lVar.b((String) a((oq) hashMap.get(SDKConstants.PARAM_A2U_BODY)));
        lVar.c((String) a((oq) hashMap.get("call_to_action")));
        lVar.a((or) a((oq) hashMap.get("close_button")));
        lVar.d((String) a((oq) hashMap.get("domain")));
        lVar.a((ot) a((oq) hashMap.get("favicon")), this.b);
        lVar.b((ot) a((oq) hashMap.get("icon")), this.b);
        ov ovVar = null;
        lVar.c(owVar != null ? owVar.b() : null, this.b);
        if (owVar != null) {
            ovVar = owVar.a();
        }
        lVar.a(ovVar);
        lVar.e((String) a((oq) hashMap.get("price")));
        lVar.f((String) a((oq) hashMap.get("rating")));
        lVar.g((String) a((oq) hashMap.get("review_count")));
        lVar.h((String) a((oq) hashMap.get("sponsored")));
        lVar.i((String) a((oq) hashMap.get("title")));
        lVar.j((String) a((oq) hashMap.get("warning")));
        return lVar;
    }

    public final NativeAdType a() {
        return this.a.b();
    }

    public final String b() {
        return this.a.g();
    }

    public final void a(NativeAdImageLoadingListener nativeAdImageLoadingListener) {
        this.e.add(nativeAdImageLoadingListener);
    }

    public final void b(NativeAdImageLoadingListener nativeAdImageLoadingListener) {
        this.e.remove(nativeAdImageLoadingListener);
    }

    @VisibleForTesting
    @Nullable
    private static <T> T a(@Nullable oq<T> oqVar) {
        if (oqVar != null) {
            return oqVar.c();
        }
        return null;
    }
}
