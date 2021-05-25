package com.google.android.gms.internal.vision;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdv extends AbstractSet<K> {
    private final /* synthetic */ zzdp zzmo;

    public zzdv(zzdp zzdp) {
        this.zzmo = zzdp;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zzmo.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zzmo.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<K> iterator() {
        return this.zzmo.zzcj();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@NullableDecl Object obj) {
        Map zzcf = this.zzmo.zzcf();
        if (zzcf != null) {
            return zzcf.keySet().remove(obj);
        }
        return zzdp.zza(this.zzmo, obj) != zzdp.zzcm();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzmo.size();
    }
}
