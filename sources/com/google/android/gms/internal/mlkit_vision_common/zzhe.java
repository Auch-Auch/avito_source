package com.google.android.gms.internal.mlkit_vision_common;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
public final class zzhe extends AbstractList<String> implements zzfc, RandomAccess {
    private final zzfc zza;

    public zzhe(zzfc zzfc) {
        this.zza = zzfc;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzhg(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzhd(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfc
    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfc
    public final List<?> zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfc
    public final zzfc zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfc
    public final void zza(zzdf zzdf) {
        throw new UnsupportedOperationException();
    }
}
