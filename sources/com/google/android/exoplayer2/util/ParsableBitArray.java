package com.google.android.exoplayer2.util;

import com.google.common.base.Charsets;
import java.nio.charset.Charset;
public final class ParsableBitArray {
    public int a;
    public int b;
    public int c;
    public byte[] data;

    public ParsableBitArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    public final void a() {
        int i;
        int i2 = this.a;
        Assertions.checkState(i2 >= 0 && (i2 < (i = this.c) || (i2 == i && this.b == 0)));
    }

    public int bitsLeft() {
        return ((this.c - this.a) * 8) - this.b;
    }

    public void byteAlign() {
        if (this.b != 0) {
            this.b = 0;
            this.a++;
            a();
        }
    }

    public int getBytePosition() {
        Assertions.checkState(this.b == 0);
        return this.a;
    }

    public int getPosition() {
        return (this.a * 8) + this.b;
    }

    public void putInt(int i, int i2) {
        if (i2 < 32) {
            i &= (1 << i2) - 1;
        }
        int min = Math.min(8 - this.b, i2);
        int i3 = this.b;
        int i4 = (8 - i3) - min;
        byte[] bArr = this.data;
        int i5 = this.a;
        bArr[i5] = (byte) (((65280 >> i3) | ((1 << i4) - 1)) & bArr[i5]);
        int i6 = i2 - min;
        bArr[i5] = (byte) (((i >>> i6) << i4) | bArr[i5]);
        int i7 = i5 + 1;
        while (i6 > 8) {
            this.data[i7] = (byte) (i >>> (i6 - 8));
            i6 -= 8;
            i7++;
        }
        int i8 = 8 - i6;
        byte[] bArr2 = this.data;
        bArr2[i7] = (byte) (bArr2[i7] & ((1 << i8) - 1));
        bArr2[i7] = (byte) (((i & ((1 << i6) - 1)) << i8) | bArr2[i7]);
        skipBits(i2);
        a();
    }

    public boolean readBit() {
        boolean z = (this.data[this.a] & (128 >> this.b)) != 0;
        skipBit();
        return z;
    }

    public int readBits(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.b += i;
        int i3 = 0;
        while (true) {
            i2 = this.b;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.b = i4;
            byte[] bArr = this.data;
            int i5 = this.a;
            this.a = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.data;
        int i6 = this.a;
        int i7 = (-1 >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.b = 0;
            this.a = i6 + 1;
        }
        a();
        return i7;
    }

    public long readBitsToLong(int i) {
        if (i <= 32) {
            return Util.toUnsignedLong(readBits(i));
        }
        return Util.toLong(readBits(i - 32), readBits(32));
    }

    public void readBytes(byte[] bArr, int i, int i2) {
        Assertions.checkState(this.b == 0);
        System.arraycopy(this.data, this.a, bArr, i, i2);
        this.a += i2;
        a();
    }

    public String readBytesAsString(int i) {
        return readBytesAsString(i, Charsets.UTF_8);
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public void setPosition(int i) {
        int i2 = i / 8;
        this.a = i2;
        this.b = i - (i2 * 8);
        a();
    }

    public void skipBit() {
        int i = this.b + 1;
        this.b = i;
        if (i == 8) {
            this.b = 0;
            this.a++;
        }
        a();
    }

    public void skipBits(int i) {
        int i2 = i / 8;
        int i3 = this.a + i2;
        this.a = i3;
        int i4 = (i - (i2 * 8)) + this.b;
        this.b = i4;
        if (i4 > 7) {
            this.a = i3 + 1;
            this.b = i4 - 8;
        }
        a();
    }

    public void skipBytes(int i) {
        Assertions.checkState(this.b == 0);
        this.a += i;
        a();
    }

    public String readBytesAsString(int i, Charset charset) {
        byte[] bArr = new byte[i];
        readBytes(bArr, 0, i);
        return new String(bArr, charset);
    }

    public void reset(ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.getData(), parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int i) {
        this.data = bArr;
        this.c = i;
    }

    public void reset(byte[] bArr, int i) {
        this.data = bArr;
        this.a = 0;
        this.b = 0;
        this.c = i;
    }

    public void readBits(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.data;
            int i4 = this.a;
            int i5 = i4 + 1;
            this.a = i5;
            byte b2 = bArr2[i4];
            int i6 = this.b;
            bArr[i] = (byte) (b2 << i6);
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | bArr[i]);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 != 0) {
            bArr[i3] = (byte) (bArr[i3] & (255 >> i7));
            int i8 = this.b;
            if (i8 + i7 > 8) {
                byte b3 = bArr[i3];
                byte[] bArr3 = this.data;
                int i9 = this.a;
                this.a = i9 + 1;
                bArr[i3] = (byte) (b3 | ((bArr3[i9] & 255) << i8));
                this.b = i8 - 8;
            }
            int i10 = this.b + i7;
            this.b = i10;
            byte[] bArr4 = this.data;
            int i11 = this.a;
            bArr[i3] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | bArr[i3]);
            if (i10 == 8) {
                this.b = 0;
                this.a = i11 + 1;
            }
            a();
        }
    }
}
