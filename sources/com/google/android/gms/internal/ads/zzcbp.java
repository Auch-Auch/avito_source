package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
public final class zzcbp implements zzelo<Set<String>> {
    private final zzelx<zzcdg> zzfok;

    public zzcbp(zzelx<zzcdg> zzelx) {
        this.zzfok = zzelx;
    }

    public static Set<String> zza(zzcdg zzcdg) {
        Set set;
        if (zzcdg.zzamf() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzelu.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzfok.get());
    }
}
