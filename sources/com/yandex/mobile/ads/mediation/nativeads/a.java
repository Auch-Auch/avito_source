package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ot;
import java.util.Map;
public final class a {
    @NonNull
    private final c a;
    @NonNull
    private final b b;

    public a(@NonNull Context context, @NonNull c cVar) {
        this.a = cVar;
        this.b = new b(context);
    }

    @Nullable
    public final ot a(@NonNull Map<String, Bitmap> map, @Nullable MediatedNativeAdImage mediatedNativeAdImage) {
        if (mediatedNativeAdImage != null) {
            String url = mediatedNativeAdImage.getUrl();
            int width = mediatedNativeAdImage.getWidth();
            int height = mediatedNativeAdImage.getHeight();
            if (c.a(width, height)) {
                return a(width, height, url, this.b.a(width, height));
            }
            Bitmap bitmap = map.get(url);
            if (bitmap != null) {
                int width2 = bitmap.getWidth();
                int height2 = bitmap.getHeight();
                return a(width2, height2, url, this.b.a(width2, height2));
            }
        }
        return null;
    }

    @NonNull
    private static ot a(int i, int i2, @NonNull String str, @NonNull String str2) {
        ot otVar = new ot();
        otVar.a(str);
        otVar.a(i);
        otVar.b(i2);
        otVar.b(str2);
        return otVar;
    }
}
