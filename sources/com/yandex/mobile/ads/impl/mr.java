package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.j;
public final class mr {
    @NonNull
    private final j a;
    @NonNull
    private final rj b = new rj();

    public mr(@NonNull j jVar) {
        this.a = jVar;
    }

    public final boolean a(@Nullable Drawable drawable, @NonNull ot otVar) {
        Bitmap a3 = this.a.a(otVar);
        if (drawable == null || a3 == null) {
            return false;
        }
        return rj.a(drawable).a(drawable, a3);
    }
}
