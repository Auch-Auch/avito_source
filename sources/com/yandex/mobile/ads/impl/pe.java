package com.yandex.mobile.ads.impl;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import java.util.List;
public final class pe extends pa {
    @NonNull
    private final String a;
    @NonNull
    private final List<pf> b;

    public pe(@NonNull String str, @NonNull String str2, @NonNull List<pf> list) {
        super(str);
        this.a = str2;
        this.b = list;
    }

    @NonNull
    public final String b() {
        return this.a;
    }

    @NonNull
    public final List<pf> c() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.pa
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pe.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        pe peVar = (pe) obj;
        if (!this.a.equals(peVar.a)) {
            return false;
        }
        return this.b.equals(peVar.b);
    }

    @Override // com.yandex.mobile.ads.impl.pa
    public final int hashCode() {
        return this.b.hashCode() + a.B0(this.a, super.hashCode() * 31, 31);
    }
}
