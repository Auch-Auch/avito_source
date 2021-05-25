package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
@VisibleForTesting
public final class zzba extends FilterInputStream {
    private final long zzcp;
    private long zzcq;

    public zzba(InputStream inputStream, long j) {
        super(inputStream);
        this.zzcp = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.zzcq++;
        }
        return read;
    }

    public final long zzp() {
        return this.zzcp - this.zzcq;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.zzcq += (long) read;
        }
        return read;
    }
}
