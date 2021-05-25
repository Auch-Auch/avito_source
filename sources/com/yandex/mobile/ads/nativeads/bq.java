package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ah;
import com.yandex.mobile.ads.impl.au;
import com.yandex.mobile.ads.impl.ay;
import com.yandex.mobile.ads.impl.bo;
import com.yandex.mobile.ads.impl.cn;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.impl.nu;
import com.yandex.mobile.ads.impl.x;
import java.util.List;
public final class bq implements bm {
    @NonNull
    private final ay a;
    @NonNull
    private final ah b;
    @NonNull
    private final nu c;
    @NonNull
    private final cn d;

    public bq(@NonNull ay ayVar, @NonNull cn cnVar, @NonNull nu nuVar, @NonNull ah ahVar) {
        this.a = ayVar;
        this.d = cnVar;
        this.c = nuVar;
        this.b = ahVar;
    }

    @Override // com.yandex.mobile.ads.nativeads.bm
    public final void a(@NonNull Context context, @NonNull ah.b bVar, @Nullable ag agVar) {
        this.d.b();
        this.a.a();
        this.b.a(bVar, context);
        if (agVar != null) {
            this.c.a(context, agVar);
        }
    }

    @Override // com.yandex.mobile.ads.nativeads.bm
    public final void a(@NonNull Context context, @NonNull ah.b bVar) {
        this.d.c();
        this.a.b();
        this.b.b(bVar, context);
        this.c.a();
    }

    @Override // com.yandex.mobile.ads.nativeads.bm
    public final void a(@NonNull x xVar, @NonNull List<bo> list) {
        this.a.a(xVar, list);
    }

    @Override // com.yandex.mobile.ads.nativeads.bm
    public final void a(@NonNull ag agVar) {
        this.c.a(agVar);
    }

    @Override // com.yandex.mobile.ads.nativeads.bm
    public final void a(@NonNull au auVar) {
        this.a.a(auVar);
    }

    @Override // com.yandex.mobile.ads.nativeads.bm
    public final void a(@NonNull hv.a aVar) {
        this.d.a(aVar);
    }
}
