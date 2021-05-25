package com.google.android.gms.internal.measurement;
public final class zzev extends zzeq<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzeq zzc;

    public zzev(zzeq zzeq, int i, int i2) {
        this.zzc = zzeq;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdq.zza(i, this.zzb);
        return (E) this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    /* renamed from: zza */
    public final zzeq<E> subList(int i, int i2) {
        zzdq.zza(i, i2, this.zzb);
        zzeq zzeq = this.zzc;
        int i3 = this.zza;
        return (zzeq) zzeq.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzf() {
        return this.zzc.zzf() + this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzg() {
        return this.zzc.zzf() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return true;
    }
}
