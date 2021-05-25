package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
public class yd {
    public final long a;

    public yd(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.a == ((yd) obj).a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return a.k(a.L("StatSending{disabledReportingInterval="), this.a, '}');
    }
}
