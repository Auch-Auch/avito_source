package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.uf;
import com.yandex.mobile.ads.video.RequestListener;
import com.yandex.mobile.ads.video.models.vmap.Vmap;
import java.util.Map;
public final class uj {
    @NonNull
    private final cj a = new cj();
    @NonNull
    private final vq b = new vq();

    @NonNull
    public final ry<Vmap> a(@NonNull Context context, @NonNull fo foVar, @NonNull to toVar, @NonNull RequestListener<Vmap> requestListener) {
        String a3 = toVar.a();
        String c = toVar.c();
        String b2 = toVar.b();
        Map<String, String> a4 = cj.a(toVar.d());
        String d = foVar.d();
        String f = foVar.f();
        if (TextUtils.isEmpty(f)) {
            f = "https://mobile.yandexadexchange.net";
        }
        Uri.Builder appendQueryParameter = Uri.parse(f).buildUpon().appendPath(a3).appendPath("vmap").appendPath(c).appendQueryParameter("video-category-id", b2).appendQueryParameter("uuid", d);
        if (a4 != null) {
            for (Map.Entry<String, String> entry : a4.entrySet()) {
                appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        new ug(context, foVar).a(context, appendQueryParameter);
        return new uq(context, appendQueryParameter.build().toString(), new uf.b(requestListener), toVar, this.b);
    }
}
