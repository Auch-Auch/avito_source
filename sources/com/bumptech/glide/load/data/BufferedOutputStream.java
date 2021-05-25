package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;
public final class BufferedOutputStream extends OutputStream {
    @NonNull
    public final OutputStream a;
    public byte[] b;
    public ArrayPool c;
    public int d;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this.a = outputStream;
        this.c = arrayPool;
        this.b = (byte[]) arrayPool.get(65536, byte[].class);
    }

    /* JADX INFO: finally extract failed */
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.a.close();
            byte[] bArr = this.b;
            if (bArr != null) {
                this.c.put(bArr);
                this.b = null;
            }
        } catch (Throwable th) {
            this.a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        int i = this.d;
        if (i > 0) {
            this.a.write(this.b, 0, i);
            this.d = 0;
        }
        this.a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.b;
        int i2 = this.d;
        int i3 = i2 + 1;
        this.d = i3;
        bArr[i2] = (byte) i;
        if (i3 == bArr.length && i3 > 0) {
            this.a.write(bArr, 0, i3);
            this.d = 0;
        }
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.d;
            if (i6 != 0 || i4 < this.b.length) {
                int min = Math.min(i4, this.b.length - i6);
                System.arraycopy(bArr, i5, this.b, this.d, min);
                int i7 = this.d + min;
                this.d = i7;
                i3 += min;
                byte[] bArr2 = this.b;
                if (i7 == bArr2.length && i7 > 0) {
                    this.a.write(bArr2, 0, i7);
                    this.d = 0;
                    continue;
                }
            } else {
                this.a.write(bArr, i5, i4);
                return;
            }
        } while (i3 < i2);
    }
}
