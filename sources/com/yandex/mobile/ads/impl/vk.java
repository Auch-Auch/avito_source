package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.avito.android.BuildConfig;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.video.VideoAdError;
import java.util.HashMap;
import java.util.Map;
public final class vk {
    @NonNull
    private final vl a;
    @NonNull
    private final ht b;

    public vk(@NonNull Context context, @NonNull vl vlVar) {
        this.a = vlVar;
        this.b = ht.a(context);
    }

    @NonNull
    private Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("block_id", c());
        return hashMap;
    }

    @NonNull
    private String c() {
        return String.format("R-V-%s-%s", this.a.a(), this.a.b());
    }

    public final void a() {
        Map<String, Object> b2 = b();
        b2.put("status", "success");
        this.b.a(new hv(hv.b.AD_LOADING_RESULT, b2));
    }

    public final void a(@NonNull VideoAdError videoAdError) {
        Map<String, Object> b2 = b();
        b2.put("failure_reason", videoAdError.getCode() == 3 ? "no_ads" : BuildConfig.ADJUST_DEFAULT_TRACKER);
        b2.put("status", "error");
        this.b.a(new hv(hv.b.AD_LOADING_RESULT, b2));
    }
}
