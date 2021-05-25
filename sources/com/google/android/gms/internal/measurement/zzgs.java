package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;
public final class zzgs extends zzgu {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzgt zzc;

    public zzgs(zzgt zzgt) {
        this.zzc = zzgt;
        this.zzb = zzgt.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzgy
    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
