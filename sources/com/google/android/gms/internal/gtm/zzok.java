package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public final class zzok extends zzoa<Map<String, zzoa<?>>> {
    private static final Map<String, zzgz> zzaug;
    private boolean zzaut = false;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzja.zzark);
        zzaug = Collections.unmodifiableMap(hashMap);
    }

    public zzok(Map<String, zzoa<?>> map) {
        this.zzaud = (Map) Preconditions.checkNotNull(map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzok) {
            return this.zzaud.entrySet().equals(((zzok) obj).value().entrySet());
        }
        return false;
    }

    public final boolean isImmutable() {
        return this.zzaut;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final String toString() {
        return this.zzaud.toString();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzoa
    public final /* synthetic */ Map<String, zzoa<?>> value() {
        return this.zzaud;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final zzoa<?> zzco(String str) {
        zzoa<?> zzco = super.zzco(str);
        return zzco == null ? zzog.zzaum : zzco;
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
        throw new IllegalStateException(a.s2(a.q0(str, 51), "Native Method ", str, " is not defined for type ListWrapper."));
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final Iterator<zzoa<?>> zzmf() {
        return zzmg();
    }

    public final void zzmi() {
        this.zzaut = true;
    }
}
