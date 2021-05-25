package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Map;
public final class zzfo extends zzeq<Map.Entry<K, V>> {
    private final /* synthetic */ zzfp zza;

    public zzfo(zzfp zzfp) {
        this.zza = zzfp;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzdq.zza(i, this.zza.zzd);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zza.zzb[i2], this.zza.zzb[i2 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return true;
    }
}
