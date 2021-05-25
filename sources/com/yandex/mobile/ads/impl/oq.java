package com.yandex.mobile.ads.impl;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class oq<T> {
    @NonNull
    private final T a;
    @NonNull
    private final String b;
    @NonNull
    private final String c;
    @Nullable
    private final ou d;
    private final boolean e;
    private final boolean f;

    public oq(@NonNull String str, @NonNull String str2, @NonNull T t, @Nullable ou ouVar, boolean z, boolean z2) {
        this.b = str;
        this.c = str2;
        this.a = t;
        this.d = ouVar;
        this.f = z;
        this.e = z2;
    }

    @NonNull
    public final String a() {
        return this.b;
    }

    @NonNull
    public final String b() {
        return this.c;
    }

    @NonNull
    public final T c() {
        return this.a;
    }

    @Nullable
    public final ou d() {
        return this.d;
    }

    public final boolean e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && oq.class == obj.getClass()) {
            oq oqVar = (oq) obj;
            if (this.e != oqVar.e || this.f != oqVar.f || !this.a.equals(oqVar.a) || !this.b.equals(oqVar.b) || !this.c.equals(oqVar.c)) {
                return false;
            }
            ou ouVar = this.d;
            ou ouVar2 = oqVar.d;
            if (ouVar != null) {
                return ouVar.equals(ouVar2);
            }
            if (ouVar2 == null) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        return this.e;
    }

    public final int hashCode() {
        int B0 = a.B0(this.c, a.B0(this.b, this.a.hashCode() * 31, 31), 31);
        ou ouVar = this.d;
        return ((((B0 + (ouVar != null ? ouVar.hashCode() : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0);
    }
}
