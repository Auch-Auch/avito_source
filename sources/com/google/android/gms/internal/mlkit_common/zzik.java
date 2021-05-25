package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
public final class zzik extends AbstractList<String> implements zzgi, RandomAccess {
    private final zzgi zza;

    public zzik(zzgi zzgi) {
        this.zza = zzgi;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgi
    public final zzgi a_() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzim(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzin(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgi
    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgi
    public final List<?> zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgi
    public final void zza(zzep zzep) {
        throw new UnsupportedOperationException();
    }
}
