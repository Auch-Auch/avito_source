package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
public final class zzbt extends zzeku {
    private ByteBuffer zzdd;

    public zzbt(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzeku
    public final void zzl(ByteBuffer byteBuffer) {
        this.zzdd = byteBuffer;
        byteBuffer.position(byteBuffer.remaining() + byteBuffer.position());
    }
}
