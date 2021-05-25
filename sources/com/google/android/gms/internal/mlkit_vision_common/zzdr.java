package com.google.android.gms.internal.mlkit_vision_common;
public abstract class zzdr {
    private int zza;
    private int zzb;
    private boolean zzc;

    private zzdr() {
        this.zza = 100;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = false;
    }

    public static zzdr zza(byte[] bArr, int i, int i2, boolean z) {
        zzdt zzdt = new zzdt(bArr, i2);
        try {
            zzdt.zza(i2);
            return zzdt;
        } catch (zzer e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zza();

    public abstract int zza(int i) throws zzer;
}
