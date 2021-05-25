package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.avito.android.BuildConfig;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.video.VastRequestConfiguration;
import com.yandex.mobile.ads.video.models.vmap.b;
import java.util.HashMap;
public final class vo implements hw<VastRequestConfiguration, tu> {
    @NonNull
    private final b a;

    public vo(@NonNull b bVar) {
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.yandex.mobile.ads.impl.sa, int, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(@Nullable sa<tu> saVar, int i, @NonNull VastRequestConfiguration vastRequestConfiguration) {
        HashMap hashMap = new HashMap();
        String b = this.a.b();
        String c = this.a.c();
        if (TextUtils.isEmpty(c)) {
            c = BuildConfig.ADJUST_DEFAULT_TRACKER;
        }
        hashMap.put("page_id", c);
        if (TextUtils.isEmpty(b)) {
            b = BuildConfig.ADJUST_DEFAULT_TRACKER;
        }
        hashMap.put("imp_id", b);
        if (i != -1) {
            hashMap.put("code", Integer.valueOf(i));
        }
        return new hv(hv.b.VAST_RESPONSE, hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.hw
    public final /* synthetic */ hv a(VastRequestConfiguration vastRequestConfiguration) {
        HashMap hashMap = new HashMap();
        String b = this.a.b();
        String c = this.a.c();
        if (TextUtils.isEmpty(c)) {
            c = BuildConfig.ADJUST_DEFAULT_TRACKER;
        }
        hashMap.put("page_id", c);
        if (TextUtils.isEmpty(b)) {
            b = BuildConfig.ADJUST_DEFAULT_TRACKER;
        }
        hashMap.put("imp_id", b);
        return new hv(hv.b.VAST_REQUEST, hashMap);
    }
}
