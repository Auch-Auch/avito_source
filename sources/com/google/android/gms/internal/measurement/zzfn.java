package com.google.android.gms.internal.measurement;
public final class zzfn<E> extends zzeq<E> {
    public static final zzeq<Object> zza = new zzfn(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzfn(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdq.zza(i, this.zzc);
        return (E) this.zzb[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq, com.google.android.gms.internal.measurement.zzer
    public final int zzb(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final Object[] zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzf() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzg() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return false;
    }
}
