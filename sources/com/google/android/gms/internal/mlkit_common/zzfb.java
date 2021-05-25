package com.google.android.gms.internal.mlkit_common;
public abstract class zzfb {
    private int zza;
    private int zzb;
    private boolean zzc;

    private zzfb() {
        this.zza = 100;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = false;
    }

    public static zzfb zza(byte[] bArr, int i, int i2, boolean z) {
        zzfd zzfd = new zzfd(bArr, i2);
        try {
            zzfd.zza(i2);
            return zzfd;
        } catch (zzgb e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zza();

    public abstract int zza(int i) throws zzgb;
}
