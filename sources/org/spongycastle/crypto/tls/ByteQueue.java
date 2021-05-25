package org.spongycastle.crypto.tls;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
public class ByteQueue {
    public byte[] a;
    public int b;
    public int c;
    public boolean d;

    public ByteQueue() {
        this(1024);
    }

    public static int nextTwoPow(int i) {
        int i2 = i | (i >> 1);
        int i3 = i2 | (i2 >> 2);
        int i4 = i3 | (i3 >> 4);
        int i5 = i4 | (i4 >> 8);
        return (i5 | (i5 >> 16)) + 1;
    }

    public void addData(byte[] bArr, int i, int i2) {
        if (!this.d) {
            int i3 = this.b;
            int i4 = this.c;
            if (i3 + i4 + i2 > this.a.length) {
                int nextTwoPow = nextTwoPow(i4 + i2);
                byte[] bArr2 = this.a;
                if (nextTwoPow > bArr2.length) {
                    byte[] bArr3 = new byte[nextTwoPow];
                    System.arraycopy(bArr2, this.b, bArr3, 0, this.c);
                    this.a = bArr3;
                } else {
                    System.arraycopy(bArr2, this.b, bArr2, 0, this.c);
                }
                this.b = 0;
            }
            System.arraycopy(bArr, i, this.a, this.b + this.c, i2);
            this.c += i2;
            return;
        }
        throw new IllegalStateException("Cannot add data to read-only buffer");
    }

    public int available() {
        return this.c;
    }

    public void copyTo(OutputStream outputStream, int i) throws IOException {
        if (i <= this.c) {
            outputStream.write(this.a, this.b, i);
            return;
        }
        StringBuilder M = a.M("Cannot copy ", i, " bytes, only got ");
        M.append(this.c);
        throw new IllegalStateException(M.toString());
    }

    public void read(byte[] bArr, int i, int i2, int i3) {
        if (bArr.length - i < i2) {
            StringBuilder L = a.L("Buffer size of ");
            L.append(bArr.length);
            L.append(" is too small for a read of ");
            L.append(i2);
            L.append(" bytes");
            throw new IllegalArgumentException(L.toString());
        } else if (this.c - i3 >= i2) {
            System.arraycopy(this.a, this.b + i3, bArr, i, i2);
        } else {
            throw new IllegalStateException("Not enough data to read");
        }
    }

    public ByteArrayInputStream readFrom(int i) {
        int i2 = this.c;
        if (i <= i2) {
            int i3 = this.b;
            this.c = i2 - i;
            this.b = i3 + i;
            return new ByteArrayInputStream(this.a, i3, i);
        }
        StringBuilder M = a.M("Cannot read ", i, " bytes, only got ");
        M.append(this.c);
        throw new IllegalStateException(M.toString());
    }

    public void removeData(int i) {
        int i2 = this.c;
        if (i <= i2) {
            this.c = i2 - i;
            this.b += i;
            return;
        }
        StringBuilder M = a.M("Cannot remove ", i, " bytes, only got ");
        M.append(this.c);
        throw new IllegalStateException(M.toString());
    }

    public void shrink() {
        int i = this.c;
        if (i == 0) {
            this.a = TlsUtils.EMPTY_BYTES;
            this.b = 0;
            return;
        }
        int nextTwoPow = nextTwoPow(i);
        byte[] bArr = this.a;
        if (nextTwoPow < bArr.length) {
            byte[] bArr2 = new byte[nextTwoPow];
            System.arraycopy(bArr, this.b, bArr2, 0, this.c);
            this.a = bArr2;
            this.b = 0;
        }
    }

    public ByteQueue(int i) {
        this.b = 0;
        this.c = 0;
        this.d = false;
        this.a = i == 0 ? TlsUtils.EMPTY_BYTES : new byte[i];
    }

    public void removeData(byte[] bArr, int i, int i2, int i3) {
        read(bArr, i, i2, i3);
        removeData(i3 + i2);
    }

    public ByteQueue(byte[] bArr, int i, int i2) {
        this.b = 0;
        this.c = 0;
        this.d = false;
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = true;
    }

    public byte[] removeData(int i, int i2) {
        byte[] bArr = new byte[i];
        removeData(bArr, 0, i, i2);
        return bArr;
    }
}
