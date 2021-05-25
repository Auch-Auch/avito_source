package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzet<K> extends zzej<K> {
    private final transient zzee<K> zzmv;
    private final transient zzef<K, ?> zznc;

    public zzet(zzef<K, ?> zzef, zzee<K> zzee) {
        this.zznc = zzef;
        this.zzmv = zzee;
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        return this.zznc.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zznc.size();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zza(Object[] objArr, int i) {
        return zzct().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    /* renamed from: zzcp */
    public final zzfa<K> iterator() {
        return (zzfa) zzct().iterator();
    }

    @Override // com.google.android.gms.internal.vision.zzej, com.google.android.gms.internal.vision.zzeb
    public final zzee<K> zzct() {
        return this.zzmv;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzcu() {
        return true;
    }
}
