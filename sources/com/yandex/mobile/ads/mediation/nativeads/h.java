package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.ea;
import com.yandex.mobile.ads.impl.ot;
import com.yandex.mobile.ads.impl.rn;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public final class h {
    @NonNull
    private final rn a = new rn();
    @NonNull
    private final c b = new c();
    @NonNull
    private final Point c;

    public h(@NonNull Context context) {
        this.c = ea.j(context);
    }

    @NonNull
    public static Map<String, Bitmap> a(@NonNull List<MediatedNativeAdImage> list) {
        Bitmap a3;
        HashMap hashMap = new HashMap();
        for (MediatedNativeAdImage mediatedNativeAdImage : list) {
            Drawable drawable = mediatedNativeAdImage.getDrawable();
            String url = mediatedNativeAdImage.getUrl();
            if (!(drawable == null || TextUtils.isEmpty(url) || (a3 = rn.a(drawable)) == null)) {
                hashMap.put(url, a3);
            }
        }
        return hashMap;
    }

    @NonNull
    public final Set<ot> b(@NonNull List<MediatedNativeAdImage> list) {
        HashSet hashSet = new HashSet();
        for (MediatedNativeAdImage mediatedNativeAdImage : list) {
            String url = mediatedNativeAdImage.getUrl();
            int width = mediatedNativeAdImage.getWidth();
            int height = mediatedNativeAdImage.getHeight();
            if (!TextUtils.isEmpty(url) && !c.a(width, height)) {
                ot otVar = new ot();
                otVar.a(url);
                otVar.a(this.c.x);
                otVar.b(this.c.y);
                hashSet.add(otVar);
            }
        }
        return hashSet;
    }
}
