package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public final class dk {
    @NonNull
    private final String a;
    private final long b;

    public dk(@NonNull String str, long j) {
        this.a = str;
        this.b = j;
    }

    @NonNull
    public final String a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || dk.class != obj.getClass()) {
            return false;
        }
        dk dkVar = (dk) obj;
        if (this.b != dkVar.b) {
            return false;
        }
        return this.a.equals(dkVar.a);
    }

    public final int hashCode() {
        long j = this.b;
        return (this.a.hashCode() * 31) + ((int) (j ^ (j >>> 32)));
    }
}
