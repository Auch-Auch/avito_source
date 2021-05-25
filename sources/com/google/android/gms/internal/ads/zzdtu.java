package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdtu<K> extends zzdtn<K> {
    private final transient zzdtg<K> zzhnc;
    private final transient zzdtk<K, ?> zzhno;

    public zzdtu(zzdtk<K, ?> zzdtk, zzdtg<K> zzdtg) {
        this.zzhno = zzdtk;
        this.zzhnc = zzdtg;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        return this.zzhno.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzhno.size();
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final int zza(Object[] objArr, int i) {
        return zzawr().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    /* renamed from: zzawn */
    public final zzdub<K> iterator() {
        return (zzdub) zzawr().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdtn, com.google.android.gms.internal.ads.zzdtf
    public final zzdtg<K> zzawr() {
        return this.zzhnc;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final boolean zzaws() {
        return true;
    }
}
