package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzfr<K> extends zzey<K> {
    private final transient zzeu<K, ?> zza;
    private final transient zzeq<K> zzb;

    public zzfr(zzeu<K, ?> zzeu, zzeq<K> zzeq) {
        this.zza = zzeu;
        this.zzb = zzeq;
    }

    @Override // com.google.android.gms.internal.measurement.zzer, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    /* renamed from: zzb */
    public final zzfz<K> iterator() {
        return (zzfz) zzc().iterator();
    }

    @Override // com.google.android.gms.internal.measurement.zzey, com.google.android.gms.internal.measurement.zzer
    public final zzeq<K> zzc() {
        return this.zzb;
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
