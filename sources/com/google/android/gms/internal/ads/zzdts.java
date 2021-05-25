package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzdts<K, V> extends zzdtn<Map.Entry<K, V>> {
    private final transient int size;
    private final transient zzdtk<K, V> zzhno;
    private final transient Object[] zzhnp;
    private final transient int zzhnq = 0;

    public zzdts(zzdtk<K, V> zzdtk, Object[] objArr, int i, int i2) {
        this.zzhno = zzdtk;
        this.zzhnp = objArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zzhno.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final int zza(Object[] objArr, int i) {
        return zzawr().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    /* renamed from: zzawn */
    public final zzdub<Map.Entry<K, V>> iterator() {
        return (zzdub) zzawr().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final boolean zzaws() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdtn
    public final zzdtg<Map.Entry<K, V>> zzawz() {
        return new zzdtv(this);
    }
}
