package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.bl;
import com.yandex.mobile.ads.impl.lx;
import com.yandex.mobile.ads.impl.oy;
import com.yandex.mobile.ads.impl.x;
import com.yandex.mobile.ads.nativeads.bp;
import com.yandex.mobile.ads.nativeads.br;
import com.yandex.mobile.ads.nativeads.bs;
import com.yandex.mobile.ads.nativeads.t;
import com.yandex.mobile.ads.nativeads.v;
import java.lang.ref.WeakReference;
public final class u implements t {
    @NonNull
    private final WeakReference<v> a;
    @NonNull
    private final bl b;

    public u(@NonNull v vVar) {
        this.a = new WeakReference<>(vVar);
        this.b = new bl(vVar.s());
    }

    @Override // com.yandex.mobile.ads.mediation.nativeads.t
    public final void a(@NonNull Context context, @NonNull x<oy> xVar) {
        v vVar = this.a.get();
        if (vVar != null) {
            this.b.a(context, xVar);
            this.b.b(context, xVar);
            vVar.a(xVar, new t(new bp(), new bs(), new lx(), new br()));
        }
    }
}
