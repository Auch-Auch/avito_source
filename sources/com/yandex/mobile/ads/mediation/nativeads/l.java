package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.bd;
import com.yandex.mobile.ads.impl.bg;
import com.yandex.mobile.ads.impl.bh;
import com.yandex.mobile.ads.impl.bi;
import com.yandex.mobile.ads.impl.bj;
import com.yandex.mobile.ads.impl.bm;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.oy;
import com.yandex.mobile.ads.impl.x;
import com.yandex.mobile.ads.nativeads.v;
public final class l implements t {
    @NonNull
    private final MediatedNativeAdapterListener a;
    @NonNull
    private final bd<MediatedNativeAdapter, MediatedNativeAdapterListener> b;

    public l(@NonNull v vVar, @NonNull x<oy> xVar, @NonNull bm bmVar) {
        fo s = vVar.s();
        bh bhVar = new bh(s);
        bj bjVar = new bj(s, xVar);
        bd<MediatedNativeAdapter, MediatedNativeAdapterListener> bdVar = new bd<>(s, new k(), bjVar, new j(new bg(bmVar, bhVar, bjVar)), new bi(vVar, bmVar));
        this.b = bdVar;
        this.a = new s(vVar, bdVar);
    }

    @Override // com.yandex.mobile.ads.mediation.nativeads.t
    public final void a(@NonNull Context context, @NonNull x<oy> xVar) {
        this.b.a(context, (Context) this.a);
    }
}
