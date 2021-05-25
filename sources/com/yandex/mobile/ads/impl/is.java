package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.to;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VastRequestConfiguration;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import com.yandex.mobile.ads.video.models.vmap.Vmap;
import java.util.List;
import java.util.Map;
public class is {
    @NonNull
    private final tn a;
    @NonNull
    private final tp b = new tp();

    public is(@NonNull Context context) {
        this.a = new tn(context);
    }

    public void liad(@NonNull Context context, @NonNull String str, @NonNull String str2, @Nullable Map<String, String> map, @NonNull RequestListener<Vmap> requestListener) {
        this.a.a(context, new to.a("v2", str, str2).a(map).a(), requestListener);
    }

    public void lvad(@NonNull Context context, @NonNull VastRequestConfiguration vastRequestConfiguration, @NonNull RequestListener<List<VideoAd>> requestListener) {
        this.a.a(context, vastRequestConfiguration, new tk(requestListener));
    }

    public void me(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.a.a(str, str2);
    }
}
