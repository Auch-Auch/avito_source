package com.google.android.gms.internal.mlkit_vision_face;
public final class zzfh {
    private final zzfq zza;
    private final byte[] zzb;

    private zzfh(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzfq.zza(bArr);
    }

    public final zzez zza() {
        this.zza.zzb();
        return new zzfj(this.zzb);
    }

    public final zzfq zzb() {
        return this.zza;
    }

    public /* synthetic */ zzfh(int i, zzfc zzfc) {
        this(i);
    }
}
