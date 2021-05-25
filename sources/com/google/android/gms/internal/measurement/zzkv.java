package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
public final class zzkv extends AbstractList<String> implements zziu, RandomAccess {
    private final zziu zza;

    public zzkv(zziu zziu) {
        this.zza = zziu;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzkx(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzky(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final void zza(zzgt zzgt) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final List<?> zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final zziu zze() {
        return this;
    }
}
