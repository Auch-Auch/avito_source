package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.gpllibrary.a;
public class pw {
    @NonNull
    public final a.b a;
    public final long b;
    public final long c;

    public pw(@NonNull a.b bVar, long j, long j2) {
        this.a = bVar;
        this.b = j;
        this.c = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        pw pwVar = (pw) obj;
        if (this.b == pwVar.b && this.c == pwVar.c && this.a == pwVar.a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.b;
        long j2 = this.c;
        return (((this.a.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("GplArguments{priority=");
        L.append(this.a);
        L.append(", durationSeconds=");
        L.append(this.b);
        L.append(", intervalSeconds=");
        return a2.b.a.a.a.k(L, this.c, '}');
    }
}
