package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
public final class zzbi extends ByteArrayOutputStream {
    private final zzat zzch;

    public zzbi(zzat zzat, int i) {
        this.zzch = zzat;
        ((ByteArrayOutputStream) this).buf = zzat.zzf(Math.max(i, 256));
    }

    private final void zzg(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i > ((ByteArrayOutputStream) this).buf.length) {
            byte[] zzf = this.zzch.zzf((i2 + i) << 1);
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, zzf, 0, ((ByteArrayOutputStream) this).count);
            this.zzch.zza(((ByteArrayOutputStream) this).buf);
            ((ByteArrayOutputStream) this).buf = zzf;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzch.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    @Override // java.lang.Object
    public final void finalize() {
        this.zzch.zza(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzg(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        zzg(1);
        super.write(i);
    }
}
