package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
public final class zztj extends PushbackInputStream {
    private final /* synthetic */ zzti zzbvo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zztj(zzti zzti, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zzbvo = zzti;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final synchronized void close() throws IOException {
        this.zzbvo.zzbvg.disconnect();
        super.close();
    }
}
