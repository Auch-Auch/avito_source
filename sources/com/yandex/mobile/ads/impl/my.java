package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.yandex.mobile.ads.nativeads.a;
import com.yandex.mobile.ads.nativeads.ag;
public final class my {
    @NonNull
    private final oq a;
    @NonNull
    private final a b;
    @NonNull
    private final ag c;
    @Nullable
    private final ay d;

    public my(@NonNull oq oqVar, @NonNull a aVar, @NonNull ag agVar, @Nullable ay ayVar) {
        this.a = oqVar;
        this.b = aVar;
        this.c = agVar;
        this.d = ayVar;
    }

    @NonNull
    public final View.OnClickListener a(@NonNull ou ouVar) {
        return this.c.e().a(this.a, ouVar, this.b, this.c, this.d);
    }
}
