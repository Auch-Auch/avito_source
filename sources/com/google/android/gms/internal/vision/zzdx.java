package com.google.android.gms.internal.vision;

import java.util.AbstractCollection;
import java.util.Iterator;
public final class zzdx extends AbstractCollection<V> {
    private final /* synthetic */ zzdp zzmo;

    public zzdx(zzdp zzdp) {
        this.zzmo = zzdp;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zzmo.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return this.zzmo.zzcl();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zzmo.size();
    }
}
