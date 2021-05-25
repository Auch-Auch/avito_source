package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
public class RecyclableBufferedInputStream extends FilterInputStream {
    public volatile byte[] a;
    public int b;
    public int c;
    public int d = -1;
    public int e;
    public final ArrayPool f;

    public static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public a(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        super(inputStream);
        this.f = arrayPool;
        this.a = (byte[]) arrayPool.get(65536, byte[].class);
    }

    public static IOException b() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i;
        int i2 = this.d;
        if (i2 == -1 || this.e - i2 >= (i = this.c)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.d = -1;
                this.e = 0;
                this.b = read;
            }
            return read;
        }
        if (i2 == 0 && i > bArr.length && this.b == bArr.length) {
            int length = bArr.length * 2;
            if (length <= i) {
                i = length;
            }
            byte[] bArr2 = (byte[]) this.f.get(i, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.a = bArr2;
            this.f.put(bArr);
            bArr = bArr2;
        } else if (i2 > 0) {
            System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
        }
        int i3 = this.e - this.d;
        this.e = i3;
        this.d = 0;
        this.b = 0;
        int read2 = inputStream.read(bArr, i3, bArr.length - i3);
        int i4 = this.e;
        if (read2 > 0) {
            i4 += read2;
        }
        this.b = i4;
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.a == null || inputStream == null) {
            b();
            throw null;
        }
        return (this.b - this.e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        if (this.a != null) {
            this.f.put(this.a);
            this.a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void fixMarkLimit() {
        this.c = this.a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.c = Math.max(this.c, i);
        this.d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            b();
            throw null;
        } else if (this.e >= this.b && a(inputStream, bArr) == -1) {
            return -1;
        } else {
            if (bArr == this.a || (bArr = this.a) != null) {
                int i = this.b;
                int i2 = this.e;
                if (i - i2 <= 0) {
                    return -1;
                }
                this.e = i2 + 1;
                return bArr[i2] & 255;
            }
            b();
            throw null;
        }
    }

    public synchronized void release() {
        if (this.a != null) {
            this.f.put(this.a);
            this.a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.a != null) {
            int i = this.d;
            if (-1 != i) {
                this.e = i;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.e + " markLimit: " + this.c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0;
        }
        byte[] bArr = this.a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i = this.b;
                int i2 = this.e;
                if (((long) (i - i2)) >= j) {
                    this.e = (int) (((long) i2) + j);
                    return j;
                }
                long j2 = ((long) i) - ((long) i2);
                this.e = i;
                if (this.d == -1 || j > ((long) this.c)) {
                    return j2 + inputStream.skip(j - j2);
                } else if (a(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    int i3 = this.b;
                    int i4 = this.e;
                    if (((long) (i3 - i4)) >= j - j2) {
                        this.e = (int) ((((long) i4) + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + ((long) i3)) - ((long) i4);
                    this.e = i3;
                    return j3;
                }
            } else {
                b();
                throw null;
            }
        } else {
            b();
            throw null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            b();
            throw null;
        } else if (i2 == 0) {
            return 0;
        } else {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i5 = this.e;
                int i6 = this.b;
                if (i5 < i6) {
                    int i7 = i6 - i5 >= i2 ? i2 : i6 - i5;
                    System.arraycopy(bArr2, i5, bArr, i, i7);
                    this.e += i7;
                    if (i7 == i2 || inputStream.available() == 0) {
                        return i7;
                    }
                    i += i7;
                    i3 = i2 - i7;
                } else {
                    i3 = i2;
                }
                while (true) {
                    int i8 = -1;
                    if (this.d == -1 && i3 >= bArr2.length) {
                        i4 = inputStream.read(bArr, i, i3);
                        if (i4 == -1) {
                            if (i3 != i2) {
                                i8 = i2 - i3;
                            }
                            return i8;
                        }
                    } else if (a(inputStream, bArr2) == -1) {
                        if (i3 != i2) {
                            i8 = i2 - i3;
                        }
                        return i8;
                    } else if (bArr2 == this.a || (bArr2 = this.a) != null) {
                        int i9 = this.b;
                        int i10 = this.e;
                        i4 = i9 - i10 >= i3 ? i3 : i9 - i10;
                        System.arraycopy(bArr2, i10, bArr, i, i4);
                        this.e += i4;
                    } else {
                        b();
                        throw null;
                    }
                    i3 -= i4;
                    if (i3 == 0) {
                        return i2;
                    }
                    if (inputStream.available() == 0) {
                        return i2 - i3;
                    }
                    i += i4;
                }
            } else {
                b();
                throw null;
            }
        }
    }
}
