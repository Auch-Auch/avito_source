package com.google.android.gms.internal.mlkit_vision_common;
public final class zzj extends zzh<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzh zzc;

    public zzj(zzh zzh, int i, int i2) {
        this.zzc = zzh;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzd.zza(i, this.zzb);
        return (E) this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzh
    /* renamed from: zza */
    public final zzh<E> subList(int i, int i2) {
        zzd.zza(i, i2, this.zzb);
        zzh zzh = this.zzc;
        int i3 = this.zza;
        return (zzh) zzh.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zze
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }
}
