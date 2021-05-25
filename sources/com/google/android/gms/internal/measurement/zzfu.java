package com.google.android.gms.internal.measurement;
public final class zzfu<E> extends zzey<E> {
    private final transient E zza;
    private transient int zzb;

    public zzfu(E e) {
        this.zza = (E) zzdq.zza(e);
    }

    @Override // com.google.android.gms.internal.measurement.zzer, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzey, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zza.hashCode();
        this.zzb = hashCode;
        return hashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean zza() {
        return this.zzb != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    /* renamed from: zzb */
    public final zzfz<E> iterator() {
        return new zzfh(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final zzeq<E> zzd() {
        return zzeq.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return false;
    }

    public zzfu(E e, int i) {
        this.zza = e;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzb(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }
}
