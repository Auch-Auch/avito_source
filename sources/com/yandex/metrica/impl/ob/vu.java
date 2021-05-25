package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class vu {
    @NonNull
    public final String a;
    public final long b;
    public final long c;

    private vu(@NonNull byte[] bArr) throws d {
        uw a3 = uw.a(bArr);
        this.a = a3.b;
        this.b = a3.d;
        this.c = a3.c;
    }

    @Nullable
    public static vu a(@NonNull byte[] bArr) throws d {
        if (dl.a(bArr)) {
            return null;
        }
        return new vu(bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || vu.class != obj.getClass()) {
            return false;
        }
        vu vuVar = (vu) obj;
        if (this.b == vuVar.b && this.c == vuVar.c) {
            return this.a.equals(vuVar.a);
        }
        return false;
    }

    public int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return (((this.a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder L = a.L("ReferrerInfo{installReferrer='");
        a.k1(L, this.a, '\'', ", referrerClickTimestampSeconds=");
        L.append(this.b);
        L.append(", installBeginTimestampSeconds=");
        return a.k(L, this.c, '}');
    }

    public byte[] a() {
        uw uwVar = new uw();
        uwVar.b = this.a;
        uwVar.d = this.b;
        uwVar.c = this.c;
        return e.a(uwVar);
    }

    public vu(@NonNull String str, long j, long j2) {
        this.a = str;
        this.b = j;
        this.c = j2;
    }
}
