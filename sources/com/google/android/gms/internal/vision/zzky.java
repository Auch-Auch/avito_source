package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
public final class zzky extends AbstractList<String> implements zziu, RandomAccess {
    private final zziu zzace;

    public zzky(zziu zziu) {
        this.zzace = zziu;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zzace.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzla(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzlb(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.zzace.size();
    }

    @Override // com.google.android.gms.internal.vision.zziu
    public final Object zzbt(int i) {
        return this.zzace.zzbt(i);
    }

    @Override // com.google.android.gms.internal.vision.zziu
    public final void zzc(zzgs zzgs) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.vision.zziu
    public final List<?> zzhs() {
        return this.zzace.zzhs();
    }

    @Override // com.google.android.gms.internal.vision.zziu
    public final zziu zzht() {
        return this;
    }
}
