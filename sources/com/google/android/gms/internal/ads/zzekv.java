package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
public abstract class zzekv extends zzeku implements zzbp {
    private int flags;
    private int version;

    public zzekv(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.zziqa) {
            zzbjj();
        }
        return this.version;
    }

    public final long zzr(ByteBuffer byteBuffer) {
        this.version = zzbq.zza(byteBuffer.get());
        this.flags = zzbq.zza(byteBuffer.get()) + (zzbq.zzg(byteBuffer) << 8) + 0;
        return 4;
    }
}
