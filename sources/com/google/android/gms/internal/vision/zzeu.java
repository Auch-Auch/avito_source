package com.google.android.gms.internal.vision;

import java.util.AbstractMap;
import java.util.Map;
public final class zzeu extends zzee<Map.Entry<K, V>> {
    private final /* synthetic */ zzer zznp;

    public zzeu(zzer zzer) {
        this.zznp = zzer;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzde.zzd(i, zzer.zza(this.zznp));
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(zzer.zzb(this.zznp)[i2], zzer.zzb(this.zznp)[i2 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return zzer.zza(this.zznp);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzcu() {
        return true;
    }
}
