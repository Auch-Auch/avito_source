package com.google.android.gms.internal.mlkit_vision_common;
public final class zzdn {
    private final zzdw zza;
    private final byte[] zzb;

    private zzdn(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzdw.zza(bArr);
    }

    public final zzdf zza() {
        this.zza.zzb();
        return new zzdp(this.zzb);
    }

    public final zzdw zzb() {
        return this.zza;
    }

    public /* synthetic */ zzdn(int i, zzdi zzdi) {
        this(i);
    }
}
