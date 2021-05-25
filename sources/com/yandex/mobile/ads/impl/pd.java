package com.yandex.mobile.ads.impl;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
public final class pd extends pa {
    @NonNull
    private final String a;
    @NonNull
    private final String b;
    @NonNull
    private final String c;

    public pd(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        super(str);
        this.a = str2;
        this.b = str3;
        this.c = str4;
    }

    @NonNull
    public final String b() {
        return this.a;
    }

    @NonNull
    public final String c() {
        return this.b;
    }

    @NonNull
    public final String d() {
        return this.c;
    }

    @Override // com.yandex.mobile.ads.impl.pa
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pd.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        pd pdVar = (pd) obj;
        if (this.a.equals(pdVar.a) && this.b.equals(pdVar.b)) {
            return this.c.equals(pdVar.c);
        }
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.pa
    public final int hashCode() {
        return this.c.hashCode() + a.B0(this.b, a.B0(this.a, super.hashCode() * 31, 31), 31);
    }
}
