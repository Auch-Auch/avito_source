package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
public final class zzbl extends ThreadLocal<ByteBuffer> {
    public zzbl(zzbm zzbm) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.lang.ThreadLocal
    public final /* synthetic */ ByteBuffer initialValue() {
        return ByteBuffer.allocate(32);
    }
}
