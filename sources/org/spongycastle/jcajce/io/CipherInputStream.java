package org.spongycastle.jcajce.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.spongycastle.crypto.io.InvalidCipherTextIOException;
public class CipherInputStream extends FilterInputStream {
    public final Cipher a;
    public final byte[] b = new byte[512];
    public boolean c = false;
    public byte[] d;
    public int e;
    public int f;

    public CipherInputStream(InputStream inputStream, Cipher cipher) {
        super(inputStream);
        this.a = cipher;
    }

    public final byte[] a() throws InvalidCipherTextIOException {
        try {
            this.c = true;
            return this.a.doFinal();
        } catch (GeneralSecurityException e2) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e2);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.e - this.f;
    }

    public final int b() throws IOException {
        if (this.c) {
            return -1;
        }
        this.f = 0;
        this.e = 0;
        while (true) {
            int i = this.e;
            if (i != 0) {
                return i;
            }
            int read = ((FilterInputStream) this).in.read(this.b);
            if (read == -1) {
                byte[] a3 = a();
                this.d = a3;
                if (a3 == null || a3.length == 0) {
                    return -1;
                }
                int length = a3.length;
                this.e = length;
                return length;
            }
            byte[] update = this.a.update(this.b, 0, read);
            this.d = update;
            if (update != null) {
                this.e = update.length;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
            this.f = 0;
            this.e = 0;
        } finally {
            if (!this.c) {
                a();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f >= this.e && b() < 0) {
            return -1;
        }
        byte[] bArr = this.d;
        int i = this.f;
        this.f = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0;
        }
        int min = (int) Math.min(j, (long) available());
        this.f += min;
        return (long) min;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f >= this.e && b() < 0) {
            return -1;
        }
        int min = Math.min(i2, available());
        System.arraycopy(this.d, this.f, bArr, i, min);
        this.f += min;
        return min;
    }
}
