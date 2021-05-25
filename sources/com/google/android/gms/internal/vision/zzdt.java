package com.google.android.gms.internal.vision;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdt extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzdp zzmo;

    public zzdt(zzdp zzdp) {
        this.zzmo = zzdp;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zzmo.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        Map zzcf = this.zzmo.zzcf();
        if (zzcf != null) {
            return zzcf.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzb = zzdp.zzb(this.zzmo, entry.getKey());
            if (zzb != -1 && zzcz.equal(this.zzmo.zzmj[zzb], entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return this.zzmo.zzck();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        Map zzcf = this.zzmo.zzcf();
        if (zzcf != null) {
            return zzcf.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.zzmo.zzce()) {
            return false;
        }
        int zzb = zzdp.zzb(this.zzmo);
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object zzc = zzdp.zzc(this.zzmo);
        zzdp zzdp = this.zzmo;
        int zza = zzea.zza(key, value, zzb, zzc, zzdp.zzmh, zzdp.zzmi, zzdp.zzmj);
        if (zza == -1) {
            return false;
        }
        this.zzmo.zzf(zza, zzb);
        zzdp.zzd(this.zzmo);
        this.zzmo.zzch();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzmo.size();
    }
}
