package com.google.android.gms.internal.measurement;

import java.util.AbstractCollection;
import java.util.Iterator;
public final class zzen extends AbstractCollection<V> {
    private final /* synthetic */ zzef zza;

    public zzen(zzef zzef) {
        this.zza = zzef;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return this.zza.zzg();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
