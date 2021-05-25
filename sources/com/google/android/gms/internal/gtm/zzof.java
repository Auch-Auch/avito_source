package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public final class zzof extends zzoa<zzgz> {
    private static final Map<String, zzgz> zzaug;
    private zzgz zzaui;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzja.zzark);
        zzaug = Collections.unmodifiableMap(hashMap);
    }

    public zzof(zzgz zzgz) {
        this.zzaui = zzgz;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final String toString() {
        return this.zzaui.toString();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzoa
    public final /* synthetic */ zzgz value() {
        return this.zzaui;
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
        throw new IllegalStateException(a.s2(a.q0(str, 60), "Native Method ", str, " is not defined for type InstructionReference."));
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final Iterator<zzoa<?>> zzmf() {
        return zzmg();
    }
}
