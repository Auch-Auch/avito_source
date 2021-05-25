package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.Nullable;
import java.util.List;
public class rr {
    public final long a;
    public final boolean b;
    @Nullable
    public final List<qd> c;

    public rr(long j, boolean z, @Nullable List<qd> list) {
        this.a = j;
        this.b = z;
        this.c = list;
    }

    public String toString() {
        StringBuilder L = a.L("WakeupConfig{collectionDuration=");
        L.append(this.a);
        L.append(", aggressiveRelaunch=");
        L.append(this.b);
        L.append(", collectionIntervalRanges=");
        L.append(this.c);
        L.append('}');
        return L.toString();
    }
}
