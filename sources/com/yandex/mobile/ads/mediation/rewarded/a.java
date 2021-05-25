package com.yandex.mobile.ads.mediation.rewarded;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.bd;
import com.yandex.mobile.ads.impl.bg;
import com.yandex.mobile.ads.impl.bh;
import com.yandex.mobile.ads.impl.bi;
import com.yandex.mobile.ads.impl.bj;
import com.yandex.mobile.ads.impl.bm;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.kq;
import com.yandex.mobile.ads.impl.x;
import com.yandex.mobile.ads.rewarded.b;
public final class a implements kq {
    @NonNull
    private final bd<MediatedRewardedAdapter, MediatedRewardedAdapterListener> a;
    @NonNull
    private final c b;
    @NonNull
    private final MediatedRewardedAdapterListener c;

    public a(@NonNull b bVar, @NonNull x<String> xVar, @NonNull bm bmVar) {
        fo s = bVar.s();
        bh bhVar = new bh(s);
        bj bjVar = new bj(s, xVar);
        b bVar2 = new b(new bg(bmVar, bhVar, bjVar));
        bi biVar = new bi(bVar, bmVar);
        c cVar = new c();
        this.b = cVar;
        bd<MediatedRewardedAdapter, MediatedRewardedAdapterListener> bdVar = new bd<>(s, cVar, bjVar, bVar2, biVar);
        this.a = bdVar;
        this.c = new d(bVar, bdVar);
    }

    @Override // com.yandex.mobile.ads.impl.kq
    public final void a(@NonNull Context context) {
        this.a.a(context);
    }

    @Override // com.yandex.mobile.ads.impl.kq
    public final void b() {
        MediatedRewardedAdapter a3 = this.b.a();
        if (a3 != null) {
            a3.showRewardedAd();
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
