package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzaj extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzaf zza;

    public zzaj(zzaf zzaf) {
        this.zza = zzaf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zza2 = this.zza.zza(entry.getKey());
            if (zza2 != -1 && zzh.zza(this.zza.zzc[zza2], entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return this.zza.zzf();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.zza.zza()) {
            return false;
        }
        int zzi = this.zza.zzi();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object obj2 = this.zza.zze;
        zzaf zzaf = this.zza;
        int zza2 = zzam.zza(key, value, zzi, obj2, zzaf.zza, zzaf.zzb, zzaf.zzc);
        if (zza2 == -1) {
            return false;
        }
        this.zza.zza(zza2, zzi);
        zzaf.zzd(this.zza);
        this.zza.zzc();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
