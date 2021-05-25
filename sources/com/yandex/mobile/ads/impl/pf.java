package com.yandex.mobile.ads.impl;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
public final class pf {
    @NonNull
    private final String a;
    @NonNull
    private final String b;
    @Nullable
    private final Map<String, Object> c;

    public pf(@NonNull String str, @NonNull String str2, @Nullable Map<String, Object> map) {
        this.a = str;
        this.b = str2;
        this.c = map;
    }

    @NonNull
    public final String a() {
        return this.a;
    }

    @NonNull
    public final String b() {
        return this.b;
    }

    @Nullable
    public final Map<String, Object> c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && pf.class == obj.getClass()) {
            pf pfVar = (pf) obj;
            if (!this.a.equals(pfVar.a) || !this.b.equals(pfVar.b)) {
                return false;
            }
            Map<String, Object> map = this.c;
            Map<String, Object> map2 = pfVar.c;
            if (map != null) {
                return map.equals(map2);
            }
            if (map2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int B0 = a.B0(this.b, this.a.hashCode() * 31, 31);
        Map<String, Object> map = this.c;
        return B0 + (map != null ? map.hashCode() : 0);
    }
}
