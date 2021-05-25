package org.jsoup.internal;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import org.jsoup.helper.Validate;
public final class ConstrainableInputStream extends BufferedInputStream {
    public final boolean a;
    public final int b;
    public long c;
    public long d = 0;
    public int e;
    public boolean f;

    public ConstrainableInputStream(InputStream inputStream, int i, int i2) {
        super(inputStream, i);
        boolean z = true;
        Validate.isTrue(i2 >= 0);
        this.b = i2;
        this.e = i2;
        this.a = i2 == 0 ? false : z;
        this.c = System.nanoTime();
    }

    public static ConstrainableInputStream wrap(InputStream inputStream, int i, int i2) {
        if (inputStream instanceof ConstrainableInputStream) {
            return (ConstrainableInputStream) inputStream;
        }
        return new ConstrainableInputStream(inputStream, i, i2);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.f || (this.a && this.e <= 0)) {
            return -1;
        }
        boolean z = true;
        if (Thread.interrupted()) {
            this.f = true;
            return -1;
        }
        if (this.d == 0 || System.nanoTime() - this.c <= this.d) {
            z = false;
        }
        if (!z) {
            if (this.a && i2 > (i3 = this.e)) {
                i2 = i3;
            }
            try {
                int read = super.read(bArr, i, i2);
                this.e -= read;
                return read;
            } catch (SocketTimeoutException unused) {
                return 0;
            }
        } else {
            throw new SocketTimeoutException("Read timeout");
        }
    }

    public ByteBuffer readToByteBuffer(int i) throws IOException {
        boolean z = true;
        Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
        if (i <= 0) {
            z = false;
        }
        int i2 = 32768;
        if (z && i < 32768) {
            i2 = i;
        }
        byte[] bArr = new byte[i2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        while (true) {
            int read = read(bArr);
            if (read == -1) {
                break;
            }
            if (z) {
                if (read >= i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                }
                i -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.e = this.b - ((BufferedInputStream) this).markpos;
    }

    public ConstrainableInputStream timeout(long j, long j2) {
        this.c = j;
        this.d = j2 * 1000000;
        return this;
    }
}
