package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
public class rk {
    public final boolean a;
    public final boolean b;

    public rk(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        rk rkVar = (rk) obj;
        if (this.a == rkVar.a && this.b == rkVar.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.a ? 1 : 0) * 31) + (this.b ? 1 : 0);
    }

    public String toString() {
        StringBuilder L = a.L("ProviderAccessFlags{lastKnownEnabled=");
        L.append(this.a);
        L.append(", scanningEnabled=");
        return a.A(L, this.b, '}');
    }
}
