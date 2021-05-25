package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ot;
import com.yandex.mobile.ads.impl.pl;
import java.util.Map;
public final class d implements j {
    @NonNull
    private final Context a;

    public d(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.yandex.mobile.ads.nativeads.j
    @Nullable
    public final Bitmap a(@NonNull ot otVar) {
        pl.b a3 = pl.a(this.a).a();
        String c = otVar.c();
        if (c == null) {
            return null;
        }
        Bitmap a4 = a3.a(c);
        if (a4 == null || a4.getWidth() != 1 || a4.getHeight() != 1) {
            return a4;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a4, otVar.a(), otVar.b(), false);
        a3.a(c, createScaledBitmap);
        return createScaledBitmap;
    }

    @Override // com.yandex.mobile.ads.nativeads.j
    public final void a(@NonNull Map<String, Bitmap> map) {
    }
}
