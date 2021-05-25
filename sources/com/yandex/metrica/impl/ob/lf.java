package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.us;
public class lf implements nh<kz, us.b> {
    @NonNull
    private final le a;
    @NonNull
    private final lg b;

    public lf() {
        this(new le(new lj()), new lg());
    }

    @VisibleForTesting
    public lf(@NonNull le leVar, @NonNull lg lgVar) {
        this.a = leVar;
        this.b = lgVar;
    }

    @NonNull
    /* renamed from: a */
    public us.b b(@NonNull kz kzVar) {
        us.b bVar = new us.b();
        bVar.b = this.a.b(kzVar.a);
        String str = kzVar.b;
        if (str != null) {
            bVar.c = str;
        }
        bVar.d = this.b.a(kzVar.c).intValue();
        return bVar;
    }

    @NonNull
    public kz a(@NonNull us.b bVar) {
        throw new UnsupportedOperationException();
    }
}
