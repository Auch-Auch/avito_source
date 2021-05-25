package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public final class ph {
    @NonNull
    private final String a;
    private final int b;
    private final int c;

    public ph(@NonNull String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ph.class != obj.getClass()) {
            return false;
        }
        ph phVar = (ph) obj;
        if (this.b == phVar.b && this.c == phVar.c) {
            return this.a.equals(phVar.a);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
    }
}
