package com.google.android.gms.internal.mlkit_vision_common;
public final class zzg<E> extends zzf<E> {
    private final zzh<E> zza;

    public zzg(zzh<E> zzh, int i) {
        super(zzh.size(), i);
        this.zza = zzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzf
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
