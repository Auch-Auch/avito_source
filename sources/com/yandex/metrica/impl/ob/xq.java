package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
public class xq {
    public final int a;
    public final int b;

    public xq(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        xq xqVar = (xq) obj;
        if (this.a == xqVar.a && this.b == xqVar.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        StringBuilder L = a.L("RetryPolicyConfig{maxIntervalSeconds=");
        L.append(this.a);
        L.append(", exponentialMultiplier=");
        return a.i(L, this.b, '}');
    }
}
