package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.mo;
import com.yandex.mobile.ads.impl.oq;
import java.util.List;
public final class ae implements bf {
    @Nullable
    private final List<oq> a;

    public ae(@Nullable List<oq> list) {
        this.a = list;
    }

    @Override // com.yandex.mobile.ads.nativeads.bf
    public final void a() {
    }

    @Override // com.yandex.mobile.ads.nativeads.bf
    public final void a(@NonNull ag agVar) {
    }

    @Override // com.yandex.mobile.ads.nativeads.bf
    public final void a(@NonNull ag agVar, @NonNull e eVar) {
        if (this.a != null) {
            mo moVar = new mo(agVar, eVar);
            for (oq oqVar : this.a) {
                lm a3 = agVar.a(oqVar);
                if (a3 != null) {
                    a3.a(oqVar.c());
                    a3.a(oqVar, moVar);
                }
            }
        }
        View a4 = agVar.d().a();
        if (a4 instanceof NativeAdUnitView) {
            eVar.a((NativeAdUnitView) a4);
        }
    }
}
