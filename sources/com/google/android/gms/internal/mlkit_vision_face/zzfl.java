package com.google.android.gms.internal.mlkit_vision_face;
public abstract class zzfl {
    private int zza;
    private int zzb;
    private boolean zzc;

    private zzfl() {
        this.zza = 100;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = false;
    }

    public static zzfl zza(byte[] bArr, int i, int i2, boolean z) {
        zzfn zzfn = new zzfn(bArr, i2);
        try {
            zzfn.zza(i2);
            return zzfn;
        } catch (zzgl e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zza();

    public abstract int zza(int i) throws zzgl;
}
