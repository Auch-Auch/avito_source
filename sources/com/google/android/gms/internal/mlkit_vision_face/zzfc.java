package com.google.android.gms.internal.mlkit_vision_face;

import java.util.NoSuchElementException;
public final class zzfc extends zzfe {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzez zzc;

    public zzfc(zzez zzez) {
        this.zzc = zzez;
        this.zzb = zzez.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzfi
    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
