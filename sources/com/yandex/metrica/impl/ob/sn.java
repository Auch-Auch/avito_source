package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
public class sn implements sm {
    private final boolean a;

    public sn(boolean z) {
        this.a = z;
    }

    @Override // com.yandex.metrica.impl.ob.sm
    public boolean a(@NonNull String str) {
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str) || "android.permission.ACCESS_COARSE_LOCATION".equals(str)) {
            return this.a;
        }
        return true;
    }

    public String toString() {
        return a.A(a.L("LocationFlagStrategy{mEnabled="), this.a, '}');
    }
}
