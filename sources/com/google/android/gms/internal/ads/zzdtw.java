package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdtw<E> extends zzdtn<E> {
    public static final zzdtw<Object> zzhnu = new zzdtw<>(new Object[0], 0, null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient int zzahr;
    private final transient Object[] zzhnv;
    private final transient Object[] zzhnw;

    public zzdtw(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzhnv = objArr;
        this.zzhnw = objArr2;
        this.mask = i2;
        this.zzahr = i;
        this.size = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzhnw;
        if (obj == null || objArr == null) {
            return false;
        }
        int zzel = zzdtc.zzel(obj.hashCode());
        while (true) {
            int i = zzel & this.mask;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzel = i + 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtn, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        return this.zzahr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzhnv, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    /* renamed from: zzawn */
    public final zzdub<E> iterator() {
        return (zzdub) zzawr().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final Object[] zzawo() {
        return this.zzhnv;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final int zzawp() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final int zzawq() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final boolean zzaws() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdtn
    public final boolean zzawy() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdtn
    public final zzdtg<E> zzawz() {
        return zzdtg.zzb(this.zzhnv, this.size);
    }
}
