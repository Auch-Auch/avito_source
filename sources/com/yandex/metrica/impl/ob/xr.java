package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
public class xr {
    public final long a;
    public final long b;
    public final long c;
    public final long d;

    public xr(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        xr xrVar = (xr) obj;
        if (this.a == xrVar.a && this.b == xrVar.b && this.c == xrVar.c && this.d == xrVar.d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        long j3 = this.c;
        long j4 = this.d;
        return (((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        StringBuilder L = a.L("SdkFingerprintingConfig{minCollectingInterval=");
        L.append(this.a);
        L.append(", minFirstCollectingDelay=");
        L.append(this.b);
        L.append(", minCollectingDelayAfterLaunch=");
        L.append(this.c);
        L.append(", minRequestRetryInterval=");
        return a.k(L, this.d, '}');
    }
}
