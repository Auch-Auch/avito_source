package com.google.android.gms.internal.vision;
public final class zzha {
    private final byte[] buffer;
    private final zzhl zztz;

    private zzha(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zztz = zzhl.zze(bArr);
    }

    public final zzgs zzfp() {
        this.zztz.zzgb();
        return new zzhc(this.buffer);
    }

    public final zzhl zzfq() {
        return this.zztz;
    }

    public /* synthetic */ zzha(int i, zzgv zzgv) {
        this(i);
    }
}
