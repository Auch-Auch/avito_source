package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
public class PooledByteArrayBufferedInputStream extends InputStream {
    public final InputStream a;
    public final byte[] b;
    public final ResourceReleaser<byte[]> c;
    public int d = 0;
    public int e = 0;
    public boolean f = false;

    public PooledByteArrayBufferedInputStream(InputStream inputStream, byte[] bArr, ResourceReleaser<byte[]> resourceReleaser) {
        this.a = (InputStream) Preconditions.checkNotNull(inputStream);
        this.b = (byte[]) Preconditions.checkNotNull(bArr);
        this.c = (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser);
    }

    public final boolean a() throws IOException {
        if (this.e < this.d) {
            return true;
        }
        int read = this.a.read(this.b);
        if (read <= 0) {
            return false;
        }
        this.d = read;
        this.e = 0;
        return true;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        Preconditions.checkState(this.e <= this.d);
        b();
        return this.a.available() + (this.d - this.e);
    }

    public final void b() throws IOException {
        if (this.f) {
            throw new IOException("stream already closed");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f) {
            this.f = true;
            this.c.release(this.b);
            super.close();
        }
    }

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        if (!this.f) {
            FLog.e("PooledByteInputStream", "Finalized without closing");
            close();
        }
        super.finalize();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        Preconditions.checkState(this.e <= this.d);
        b();
        if (!a()) {
            return -1;
        }
        byte[] bArr = this.b;
        int i = this.e;
        this.e = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        Preconditions.checkState(this.e <= this.d);
        b();
        int i = this.d;
        int i2 = this.e;
        long j2 = (long) (i - i2);
        if (j2 >= j) {
            this.e = (int) (((long) i2) + j);
            return j;
        }
        this.e = i;
        return this.a.skip(j - j2) + j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Preconditions.checkState(this.e <= this.d);
        b();
        if (!a()) {
            return -1;
        }
        int min = Math.min(this.d - this.e, i2);
        System.arraycopy(this.b, this.e, bArr, i, min);
        this.e += min;
        return min;
    }
}
