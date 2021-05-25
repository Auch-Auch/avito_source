package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
import com.yandex.mobile.ads.nativeads.ag;
import com.yandex.mobile.ads.nativeads.e;
public final class mo implements mq {
    @NonNull
    private final ag a;
    @NonNull
    private final e b;

    public mo(@NonNull ag agVar, @NonNull e eVar) {
        this.a = agVar;
        this.b = eVar;
    }

    @Override // com.yandex.mobile.ads.impl.mq
    public final void a(@NonNull oq oqVar, @NonNull View view) {
    }

    @Override // com.yandex.mobile.ads.impl.mq
    public final void a(@NonNull oq oqVar, @NonNull mx mxVar) {
        this.b.a(oqVar, oqVar.d(), this.a, mxVar);
    }
}
