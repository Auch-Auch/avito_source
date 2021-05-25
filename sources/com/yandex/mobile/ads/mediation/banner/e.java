package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.a;
import com.yandex.mobile.ads.impl.bd;
import com.yandex.mobile.ads.impl.bg;
import com.yandex.mobile.ads.impl.bi;
import com.yandex.mobile.ads.impl.bj;
import com.yandex.mobile.ads.impl.bm;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.x;
import com.yandex.mobile.ads.mediation.banner.MediatedBannerAdapter;
public final class e implements b {
    @NonNull
    private final MediatedBannerAdapter.MediatedBannerAdapterListener a;
    @NonNull
    private final bd<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> b;

    public e(@NonNull a aVar, @NonNull x<String> xVar, @NonNull bm bmVar) {
        fo s = aVar.s();
        f fVar = new f(s);
        bj bjVar = new bj(s, xVar);
        bd<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> bdVar = new bd<>(s, new d(), bjVar, new c(new bg(bmVar, fVar, bjVar)), new bi(aVar, bmVar));
        this.b = bdVar;
        this.a = new a(aVar, bdVar, new g(aVar.a(), bdVar));
    }

    @Override // com.yandex.mobile.ads.mediation.banner.b
    public final void a(@NonNull Context context) {
        this.b.a(context);
    }

    @Override // com.yandex.mobile.ads.mediation.banner.b
    public final void a(@NonNull Context context, @NonNull x<String> xVar) {
        this.b.a(context, (Context) this.a);
    }
}
