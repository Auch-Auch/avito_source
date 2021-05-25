package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.uf;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.VastRequestConfiguration;
import com.yandex.mobile.ads.video.models.vmap.b;
import java.util.Random;
public final class ui {
    @NonNull
    public static ry<tu> a(@NonNull Context context, @NonNull fo foVar, @NonNull VastRequestConfiguration vastRequestConfiguration, @NonNull RequestListener<tu> requestListener) {
        b bVar = new b(vastRequestConfiguration);
        vo voVar = new vo(bVar);
        Uri.Builder appendQueryParameter = Uri.parse(bVar.a().a()).buildUpon().appendQueryParameter("charset", "UTF-8").appendQueryParameter("rnd", Integer.toString(new Random().nextInt(89999999) + 10000000));
        uh.a(appendQueryParameter, vastRequestConfiguration.getParameters());
        uh.a(appendQueryParameter, "video-session-id", bVar.d());
        uh.a(appendQueryParameter, "uuid", foVar.d());
        new ug(context, foVar).a(context, appendQueryParameter);
        return new um(context, appendQueryParameter.build().toString(), new uf.b(requestListener), vastRequestConfiguration, voVar);
    }
}
