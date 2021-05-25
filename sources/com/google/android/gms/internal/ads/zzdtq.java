package com.google.android.gms.internal.ads;
public final class zzdtq<E> extends zzdtg<E> {
    public static final zzdtg<Object> zzhnm = new zzdtq(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzhnn;

    public zzdtq(Object[] objArr, int i) {
        this.zzhnn = objArr;
        this.size = i;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdsv.zzs(i, this.size);
        return (E) this.zzhnn[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdtg, com.google.android.gms.internal.ads.zzdtf
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzhnn, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final Object[] zzawo() {
        return this.zzhnn;
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
}
