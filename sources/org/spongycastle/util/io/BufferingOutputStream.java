package org.spongycastle.util.io;

import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.util.Arrays;
public class BufferingOutputStream extends OutputStream {
    public final OutputStream a;
    public final byte[] b;
    public int c;

    public BufferingOutputStream(OutputStream outputStream) {
        this.a = outputStream;
        this.b = new byte[4096];
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.a.write(this.b, 0, this.c);
        this.c = 0;
        Arrays.fill(this.b, (byte) 0);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2;
        byte[] bArr3 = this.b;
        int length = bArr3.length;
        int i3 = this.c;
        if (i2 < length - i3) {
            System.arraycopy(bArr, i, bArr3, i3, i2);
            this.c += i2;
            return;
        }
        int length2 = bArr3.length - i3;
        System.arraycopy(bArr, i, bArr3, i3, length2);
        this.c += length2;
        flush();
        int i4 = i + length2;
        int i5 = i2 - length2;
        while (true) {
            bArr2 = this.b;
            if (i5 < bArr2.length) {
                break;
            }
            this.a.write(bArr, i4, bArr2.length);
            byte[] bArr4 = this.b;
            i4 += bArr4.length;
            i5 -= bArr4.length;
        }
        if (i5 > 0) {
            System.arraycopy(bArr, i4, bArr2, this.c, i5);
            this.c += i5;
        }
    }

    public BufferingOutputStream(OutputStream outputStream, int i) {
        this.a = outputStream;
        this.b = new byte[i];
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.b;
        int i2 = this.c;
        int i3 = i2 + 1;
        this.c = i3;
        bArr[i2] = (byte) i;
        if (i3 == bArr.length) {
            flush();
        }
    }
}
