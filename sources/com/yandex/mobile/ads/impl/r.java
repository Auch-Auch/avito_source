package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class r extends sl {
    private static final long serialVersionUID = 9076708591501334094L;
    private final int b;

    public r(rx rxVar, int i) {
        super(rxVar);
        this.b = i;
    }

    private static boolean a(int i) {
        return i >= 500 && i <= 599;
    }

    @NonNull
    public static r b(@Nullable rx rxVar) {
        int i = rxVar != null ? rxVar.a : -1;
        return new r(rxVar, a(i) ? 9 : -1 == i ? 7 : 8);
    }

    public final int a() {
        return this.b;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && r.class == obj.getClass() && this.b == ((r) obj).b;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.b;
    }

    public static r a(rx rxVar) {
        int i = rxVar != null ? rxVar.a : -1;
        if (204 == i) {
            return new r(rxVar, 6);
        }
        if (403 == i) {
            return new r(rxVar, 10);
        }
        if (404 == i) {
            return new r(rxVar, 4);
        }
        if (a(i)) {
            return new r(rxVar, 9);
        }
        if (-1 == i) {
            return new r(rxVar, 7);
        }
        return new r(rxVar, 8);
    }

    public r() {
        this.b = 11;
    }
}
