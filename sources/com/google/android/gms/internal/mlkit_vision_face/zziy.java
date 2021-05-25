package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
public final class zziy extends AbstractList<String> implements zzgw, RandomAccess {
    private final zzgw zza;

    public zziy(zzgw zzgw) {
        this.zza = zzgw;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzja(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzix(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzgw
    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzgw
    public final List<?> zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzgw
    public final zzgw zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzgw
    public final void zza(zzez zzez) {
        throw new UnsupportedOperationException();
    }
}
