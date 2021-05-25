package com.facebook.common.memory;

import a2.b.a.a.a;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
public class PooledByteBufferInputStream extends InputStream {
    @VisibleForTesting
    public final PooledByteBuffer a;
    @VisibleForTesting
    public int b = 0;
    @VisibleForTesting
    public int c = 0;

    public PooledByteBufferInputStream(PooledByteBuffer pooledByteBuffer) {
        Preconditions.checkArgument(!pooledByteBuffer.isClosed());
        this.a = (PooledByteBuffer) Preconditions.checkNotNull(pooledByteBuffer);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.size() - this.b;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.c = this.b;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() <= 0) {
            return -1;
        }
        PooledByteBuffer pooledByteBuffer = this.a;
        int i = this.b;
        this.b = i + 1;
        return pooledByteBuffer.read(i) & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.b = this.c;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        Preconditions.checkArgument(j >= 0);
        int min = Math.min((int) j, available());
        this.b += min;
        return (long) min;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder L = a.L("length=");
            L.append(bArr.length);
            L.append("; regionStart=");
            L.append(i);
            L.append("; regionLength=");
            L.append(i2);
            throw new ArrayIndexOutOfBoundsException(L.toString());
        }
        int available = available();
        if (available <= 0) {
            return -1;
        }
        if (i2 <= 0) {
            return 0;
        }
        int min = Math.min(available, i2);
        this.a.read(this.b, bArr, i, min);
        this.b += min;
        return min;
    }
}
