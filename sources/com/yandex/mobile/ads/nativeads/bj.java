package com.yandex.mobile.ads.nativeads;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ot;
import java.util.Map;
public final class bj implements j {
    private Map<String, Bitmap> a;

    @Override // com.yandex.mobile.ads.nativeads.j
    public final void a(@NonNull Map<String, Bitmap> map) {
        this.a = map;
    }

    @Override // com.yandex.mobile.ads.nativeads.j
    @Nullable
    public final Bitmap a(@NonNull ot otVar) {
        String c = otVar.c();
        Map<String, Bitmap> map = this.a;
        if (map != null) {
            return map.get(c);
        }
        return null;
    }
}
