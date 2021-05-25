package org.spongycastle.crypto.tls;

import java.io.InputStream;
public class ByteQueueInputStream extends InputStream {
    public ByteQueue a = new ByteQueue();

    public void addBytes(byte[] bArr) {
        this.a.addData(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public int peek(byte[] bArr) {
        int min = Math.min(this.a.available(), bArr.length);
        this.a.read(bArr, 0, min, 0);
        return min;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.a.available() == 0) {
            return -1;
        }
        return this.a.removeData(1, 0)[0] & 255;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        int min = Math.min((int) j, this.a.available());
        this.a.removeData(min);
        return (long) min;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int min = Math.min(this.a.available(), i2);
        this.a.removeData(bArr, i, min, 0);
        return min;
    }
}
