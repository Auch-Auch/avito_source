package com.yandex.mobile.ads.mediation.interstitial;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.bd;
import com.yandex.mobile.ads.impl.bg;
import com.yandex.mobile.ads.impl.bh;
import com.yandex.mobile.ads.impl.bi;
import com.yandex.mobile.ads.impl.bj;
import com.yandex.mobile.ads.impl.bm;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.in;
import com.yandex.mobile.ads.impl.kq;
import com.yandex.mobile.ads.impl.x;
import com.yandex.mobile.ads.mediation.interstitial.MediatedInterstitialAdapter;
public final class d implements kq {
    @NonNull
    private final bd<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> a;
    @NonNull
    private final c b;
    @NonNull
    private final MediatedInterstitialAdapter.MediatedInterstitialAdapterListener c;

    public d(@NonNull in inVar, @NonNull x xVar, @NonNull bm bmVar) {
        fo s = inVar.s();
        bh bhVar = new bh(s);
        bj bjVar = new bj(s, xVar);
        b bVar = new b(new bg(bmVar, bhVar, bjVar));
        bi biVar = new bi(inVar, bmVar);
        c cVar = new c();
        this.b = cVar;
        bd<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> bdVar = new bd<>(s, cVar, bjVar, bVar, biVar);
        this.a = bdVar;
        this.c = new a(inVar, bdVar);
    }

    @Override // com.yandex.mobile.ads.impl.kq
    public final void a(@NonNull Context context) {
        this.a.a(context);
    }

    @Override // com.yandex.mobile.ads.impl.kq
    public final void b() {
        MediatedInterstitialAdapter a3 = this.b.a();
        if (a3 != null) {
            a3.showInterstitial();
        }
    }

    @Override // com.yandex.mobile.ads.impl.kq
    public final boolean a() {
        return this.b.b();
    }

    @Override // com.yandex.mobile.ads.impl.kq
    public final void a(@NonNull Context context, @NonNull x<String> xVar) {
        this.a.a(context, (Context) this.c);
    }
}
