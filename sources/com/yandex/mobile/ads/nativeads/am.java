package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.lp;
import com.yandex.mobile.ads.impl.mp;
import com.yandex.mobile.ads.impl.oq;
import com.yandex.mobile.ads.impl.ox;
public final class am implements bf {
    @NonNull
    private final ox a;
    @Nullable
    private ag b;

    public am(@NonNull ox oxVar) {
        this.a = oxVar;
    }

    @Override // com.yandex.mobile.ads.nativeads.bf
    public final void a(@NonNull ag agVar) {
        agVar.a();
    }

    @Override // com.yandex.mobile.ads.nativeads.bf
    public final void a(@NonNull ag agVar, @NonNull e eVar) {
        this.b = agVar;
        mp mpVar = new mp(agVar, eVar, this.a.a());
        for (oq oqVar : this.a.c()) {
            lm a3 = agVar.a(oqVar);
            if (a3 != null) {
                a3.a(oqVar.c());
                a3.a(oqVar, mpVar);
            }
        }
    }

    @Override // com.yandex.mobile.ads.nativeads.bf
    public final void a() {
        if (this.b != null) {
            for (oq oqVar : this.a.c()) {
                lm a3 = this.b.a(oqVar);
                if (a3 instanceof lp) {
                    ((lp) a3).c(oqVar.c());
                }
            }
        }
    }
}
