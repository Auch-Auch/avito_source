package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
public class ps {
    public final long a;
    public final long b;

    public ps(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ps psVar = (ps) obj;
        if (this.a == psVar.a && this.b == psVar.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        return (((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder L = a.L("ForcedCollectingArguments{durationSeconds=");
        L.append(this.a);
        L.append(", intervalSeconds=");
        return a.k(L, this.b, '}');
    }
}
