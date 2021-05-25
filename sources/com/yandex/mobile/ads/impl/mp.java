package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
import com.yandex.mobile.ads.nativeads.ag;
import com.yandex.mobile.ads.nativeads.e;
public final class mp implements mq {
    @NonNull
    private final ag a;
    @NonNull
    private final e b;
    @NonNull
    private final ou c;
    @NonNull
    private final ef d = new ef();

    public mp(@NonNull ag agVar, @NonNull e eVar, @NonNull ou ouVar) {
        this.a = agVar;
        this.b = eVar;
        this.c = ouVar;
    }

    @Override // com.yandex.mobile.ads.impl.mq
    public final void a(@NonNull oq oqVar, @NonNull View view) {
        if (view.getTag() == null) {
            view.setTag(ef.a(oqVar.a()));
        }
    }

    @Override // com.yandex.mobile.ads.impl.mq
    public final void a(@NonNull oq oqVar, @NonNull mx mxVar) {
        ou d2 = oqVar.d();
        if (d2 == null) {
            d2 = this.c;
        }
        this.b.a(oqVar, d2, this.a, mxVar);
    }
}
