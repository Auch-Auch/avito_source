package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.io.InputStream;
public final class DataSourceInputStream extends InputStream {
    public final DataSource a;
    public final DataSpec b;
    public final byte[] c;
    public boolean d = false;
    public boolean e = false;
    public long f;

    public DataSourceInputStream(DataSource dataSource, DataSpec dataSpec) {
        this.a = dataSource;
        this.b = dataSpec;
        this.c = new byte[1];
    }

    public long bytesRead() {
        return this.f;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.e) {
            this.a.close();
            this.e = true;
        }
    }

    public void open() throws IOException {
        if (!this.d) {
            this.a.open(this.b);
            this.d = true;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Assertions.checkState(!this.e);
        if (!this.d) {
            this.a.open(this.b);
            this.d = true;
        }
        int read = this.a.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.f += (long) read;
        return read;
    }
}
