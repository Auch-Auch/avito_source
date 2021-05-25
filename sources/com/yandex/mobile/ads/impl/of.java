package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.nativeads.a;
import com.yandex.mobile.ads.nativeads.ag;
import com.yandex.mobile.ads.nativeads.b;
import com.yandex.mobile.ads.nativeads.bl;
import com.yandex.mobile.ads.nativeads.r;
public final class of implements a {
    @NonNull
    private final x a;
    @NonNull
    private final fo b;
    @NonNull
    private final r c;
    @NonNull
    private final oi d;
    @NonNull
    private final b e;
    @NonNull
    private final bl f;
    @Nullable
    private hv.a g;

    public of(@NonNull Context context, @NonNull x xVar, @NonNull fo foVar, @NonNull r rVar, @NonNull bl blVar) {
        this.a = xVar;
        this.b = foVar;
        this.c = rVar;
        this.f = blVar;
        this.d = new oi(new dg(context, foVar));
        this.e = new b(rVar);
    }

    public final void a(@NonNull hv.a aVar) {
        this.g = aVar;
    }

    @Override // com.yandex.mobile.ads.nativeads.a
    public final void a(@NonNull Context context, @NonNull ou ouVar, @NonNull ag agVar) {
        this.c.a(ouVar);
        dg dgVar = new dg(context, this.b);
        y a3 = this.e.a();
        cr crVar = new cr(context, this.a, this.b, this.g);
        oh ohVar = new oh(dgVar, this.a, this.f.a(context, this.b, a3), crVar);
        ol olVar = new ol(this.b, crVar, ohVar, agVar, this.c);
        this.d.a(ouVar.c());
        olVar.a(context, ouVar.a());
        ohVar.a(ouVar.d());
    }
}
