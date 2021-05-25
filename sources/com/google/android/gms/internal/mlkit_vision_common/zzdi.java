package com.google.android.gms.internal.mlkit_vision_common;

import java.util.NoSuchElementException;
public final class zzdi extends zzdk {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzdf zzc;

    public zzdi(zzdf zzdf) {
        this.zzc = zzdf;
        this.zzb = zzdf.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdo
    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
