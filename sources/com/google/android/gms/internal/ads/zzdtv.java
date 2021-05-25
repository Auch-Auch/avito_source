package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;
public final class zzdtv extends zzdtg<Map.Entry<K, V>> {
    private final /* synthetic */ zzdts zzhnt;

    public zzdtv(zzdts zzdts) {
        this.zzhnt = zzdts;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzdsv.zzs(i, this.zzhnt.size);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzhnt.zzhnp[i2], this.zzhnt.zzhnp[i2 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzhnt.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final boolean zzaws() {
        return true;
    }
}
