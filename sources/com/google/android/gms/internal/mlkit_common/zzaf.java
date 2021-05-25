package com.google.android.gms.internal.mlkit_common;
public final class zzaf<E> extends zzaa<E> {
    private final zzad<E> zza;

    public zzaf(zzad<E> zzad, int i) {
        super(zzad.size(), i);
        this.zza = zzad;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaa
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
