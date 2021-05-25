package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import java.util.Collections;
import java.util.Map;
public final class zzno {
    private final Map<String, zznx> zzats;
    private final zznx zzatt;

    private zzno(Map<String, zznx> map, zznx zznx) {
        this.zzats = Collections.unmodifiableMap(map);
        this.zzatt = zznx;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzats);
        String valueOf2 = String.valueOf(this.zzatt);
        return a.t2(valueOf2.length() + valueOf.length() + 32, "Properties: ", valueOf, " pushAfterEvaluate: ", valueOf2);
    }

    public final Map<String, zznx> zzlu() {
        return this.zzats;
    }
}
