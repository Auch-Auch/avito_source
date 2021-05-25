package com.google.android.gms.internal.mlkit_common;

import java.util.NoSuchElementException;
public final class zzeo extends zzeq {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzep zzc;

    public zzeo(zzep zzep) {
        this.zzc = zzep;
        this.zzb = zzep.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeu
    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
