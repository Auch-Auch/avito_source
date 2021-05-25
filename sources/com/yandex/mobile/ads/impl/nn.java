package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
import com.yandex.mobile.ads.nativeads.bf;
import com.yandex.mobile.ads.nativeads.j;
import com.yandex.mobile.ads.nativeads.o;
import com.yandex.mobile.ads.nativeads.p;
import com.yandex.mobile.ads.nativeads.t;
import com.yandex.mobile.ads.nativeads.w;
import java.util.List;
public final class nn implements nh {
    @NonNull
    private final nt a = new nt();

    @Override // com.yandex.mobile.ads.impl.nh
    public final void a(@NonNull Context context, @NonNull p pVar, @NonNull j jVar, @NonNull t tVar, @NonNull nj njVar) {
        NativeGenericAd nativeGenericAd;
        ox oxVar;
        ns a3;
        List<ox> c = pVar.c().c();
        if (c == null || c.isEmpty() || (oxVar = c.get(0)) == null || (a3 = nt.a(oxVar.b())) == null) {
            nativeGenericAd = null;
        } else {
            bf a4 = tVar.b().a(oxVar);
            nativeGenericAd = a3.a(context, oxVar, new w(context, oxVar, jVar, a4), jVar, o.a(pVar, o.a(pVar, oxVar), a4, tVar));
        }
        if (nativeGenericAd != null) {
            njVar.a(nativeGenericAd);
        } else {
            njVar.a(v.a);
        }
    }
}
