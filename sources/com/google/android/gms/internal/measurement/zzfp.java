package com.google.android.gms.internal.measurement;

import java.util.Map;
public final class zzfp<K, V> extends zzey<Map.Entry<K, V>> {
    private final transient zzeu<K, V> zza;
    private final transient Object[] zzb;
    private final transient int zzc = 0;
    private final transient int zzd;

    public zzfp(zzeu<K, V> zzeu, Object[] objArr, int i, int i2) {
        this.zza = zzeu;
        this.zzb = objArr;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzer, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    /* renamed from: zzb */
    public final zzfz<Map.Entry<K, V>> iterator() {
        return (zzfz) zzc().iterator();
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final zzeq<Map.Entry<K, V>> zzd() {
        return new zzfo(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzb(Object[] objArr, int i) {
        return zzc().zzb(objArr, i);
    }
}
