package com.google.android.gms.internal.measurement;
public final class zzhb {
    private final zzhi zza;
    private final byte[] zzb;

    private zzhb(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzhi.zza(bArr);
    }

    public final zzgt zza() {
        this.zza.zzb();
        return new zzhd(this.zzb);
    }

    public final zzhi zzb() {
        return this.zza;
    }

    public /* synthetic */ zzhb(int i, zzgs zzgs) {
        this(i);
    }
}
