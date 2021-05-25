package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public final class zzoe extends zzoa<Double> {
    private static final Map<String, zzgz> zzaug;
    private Double zzauh;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzja.zzark);
        hashMap.put("toString", new zzkc());
        zzaug = Collections.unmodifiableMap(hashMap);
    }

    public zzoe(Double d) {
        Preconditions.checkNotNull(d);
        this.zzauh = d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzoe) {
            return this.zzauh.equals((Double) ((zzoe) obj).value());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final String toString() {
        return this.zzauh.toString();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzoa
    public final /* synthetic */ Double value() {
        return this.zzauh;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final boolean zzcp(String str) {
        return zzaug.containsKey(str);
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final zzgz zzcq(String str) {
        if (zzcp(str)) {
            return zzaug.get(str);
        }
        throw new IllegalStateException(a.s2(a.q0(str, 53), "Native Method ", str, " is not defined for type DoubleWrapper."));
    }
}
