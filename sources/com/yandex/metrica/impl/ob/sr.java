package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
public class sr {
    @NonNull
    public final String a;
    public final boolean b;

    public sr(@NonNull String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        sr srVar = (sr) obj;
        if (this.b != srVar.b) {
            return false;
        }
        return this.a.equals(srVar.a);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + (this.b ? 1 : 0);
    }

    public String toString() {
        StringBuilder L = a.L("PermissionState{name='");
        a.k1(L, this.a, '\'', ", granted=");
        return a.A(L, this.b, '}');
    }
}
