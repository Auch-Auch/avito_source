package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VastRequestConfiguration;
import com.yandex.mobile.ads.video.models.vmap.Vmap;
public final class tn {
    @NonNull
    private final tp a = new tp();
    @NonNull
    private gm b;

    public tn(@NonNull Context context) {
        this.b = gk.a(context);
    }

    public final void a(@Nullable String str, @Nullable String str2) {
        this.b = new gp(str, str2, this.b);
    }

    public final void a(@NonNull Context context, @NonNull to toVar, @NonNull RequestListener<Vmap> requestListener) {
        tq.a(context).a(context, toVar, this.b, requestListener);
    }

    public final void a(@NonNull Context context, @NonNull VastRequestConfiguration vastRequestConfiguration, @NonNull RequestListener<tu> requestListener) {
        tq.a(context).a(context, vastRequestConfiguration, this.b, requestListener);
    }
}
