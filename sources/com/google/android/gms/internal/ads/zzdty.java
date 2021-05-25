package com.google.android.gms.internal.ads;
public final class zzdty<E> extends zzdtn<E> {
    private final transient E zzhnx;
    private transient int zzhny;

    public zzdty(E e) {
        this.zzhnx = (E) zzdsv.checkNotNull(e);
    }

    @Override // com.google.android.gms.internal.ads.zzdtf, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zzhnx.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdtn, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        int i = this.zzhny;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zzhnx.hashCode();
        this.zzhny = hashCode;
        return hashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public final String toString() {
        String obj = this.zzhnx.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zzhnx;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    /* renamed from: zzawn */
    public final zzdub<E> iterator() {
        return new zzdtp(this.zzhnx);
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final boolean zzaws() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdtn
    public final boolean zzawy() {
        return this.zzhny != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdtn
    public final zzdtg<E> zzawz() {
        return zzdtg.zzac(this.zzhnx);
    }

    public zzdty(E e, int i) {
        this.zzhnx = e;
        this.zzhny = i;
    }
}
