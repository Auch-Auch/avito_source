package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.tb;
public final class bz extends tb<fz> {
    @NonNull
    private final db<fz> a;

    public bz(@NonNull String str, @NonNull db<fz> dbVar, @NonNull tb.a<fz> aVar) {
        super(0, str, aVar);
        this.a = dbVar;
    }

    @Override // com.yandex.mobile.ads.impl.ry
    public final sa<fz> a(@NonNull rx rxVar) {
        int i;
        if (200 == rxVar.a) {
            fz a3 = this.a.a(rxVar);
            if (a3 != null) {
                return sa.a(a3, sp.a(rxVar));
            }
            i = 5;
        } else {
            i = 8;
        }
        return sa.a(new r(rxVar, i));
    }

    @Override // com.yandex.mobile.ads.impl.ry
    public final sl a(sl slVar) {
        return super.a((sl) r.b(slVar.a));
    }
}
