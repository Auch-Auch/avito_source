package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VastRequestConfiguration;
public final class ua {
    @NonNull
    public static tz a(@NonNull Context context, @NonNull VastRequestConfiguration vastRequestConfiguration, @NonNull RequestListener<tu> requestListener) {
        return new tz(context, new vj(vastRequestConfiguration), requestListener);
    }
}
