package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public final class zzod extends zzoa<Boolean> {
    private static final Map<String, zzgz> zzaug;
    private final Boolean zzauf;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzja.zzark);
        hashMap.put("toString", new zzkc());
        zzaug = Collections.unmodifiableMap(hashMap);
    }

    public zzod(Boolean bool) {
        Preconditions.checkNotNull(bool);
        this.zzauf = bool;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzod) && ((Boolean) ((zzod) obj).value()) == this.zzauf);
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final String toString() {
        return this.zzauf.toString();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzoa
    public final /* synthetic */ Boolean value() {
        return this.zzauf;
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
        throw new IllegalStateException(a.s2(a.q0(str, 54), "Native Method ", str, " is not defined for type BooleanWrapper."));
    }
}
