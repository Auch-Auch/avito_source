package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;
public class ISAACEngine implements StreamCipher {
    public int[] a = null;
    public int[] b = null;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public byte[] g = new byte[1024];
    public byte[] h = null;
    public boolean i = false;

    public final void a() {
        int i2 = this.d;
        int i3 = this.e + 1;
        this.e = i3;
        this.d = i2 + i3;
        for (int i4 = 0; i4 < 256; i4++) {
            int[] iArr = this.a;
            int i5 = iArr[i4];
            int i6 = i4 & 3;
            if (i6 == 0) {
                int i7 = this.c;
                this.c = i7 ^ (i7 << 13);
            } else if (i6 == 1) {
                int i8 = this.c;
                this.c = i8 ^ (i8 >>> 6);
            } else if (i6 == 2) {
                int i9 = this.c;
                this.c = i9 ^ (i9 << 2);
            } else if (i6 == 3) {
                int i10 = this.c;
                this.c = i10 ^ (i10 >>> 16);
            }
            int i11 = this.c + iArr[(i4 + 128) & 255];
            this.c = i11;
            int i12 = iArr[(i5 >>> 2) & 255] + i11 + this.d;
            iArr[i4] = i12;
            int[] iArr2 = this.b;
            int i13 = iArr[(i12 >>> 10) & 255] + i5;
            this.d = i13;
            iArr2[i4] = i13;
        }
    }

    public final void b(int[] iArr) {
        iArr[0] = iArr[0] ^ (iArr[1] << 11);
        iArr[3] = iArr[3] + iArr[0];
        iArr[1] = iArr[1] + iArr[2];
        iArr[1] = iArr[1] ^ (iArr[2] >>> 2);
        iArr[4] = iArr[4] + iArr[1];
        iArr[2] = iArr[2] + iArr[3];
        iArr[2] = iArr[2] ^ (iArr[3] << 8);
        iArr[5] = iArr[5] + iArr[2];
        iArr[3] = iArr[3] + iArr[4];
        iArr[3] = iArr[3] ^ (iArr[4] >>> 16);
        iArr[6] = iArr[6] + iArr[3];
        iArr[4] = iArr[4] + iArr[5];
        iArr[4] = iArr[4] ^ (iArr[5] << 10);
        iArr[7] = iArr[7] + iArr[4];
        iArr[5] = iArr[5] + iArr[6];
        iArr[5] = (iArr[6] >>> 4) ^ iArr[5];
        iArr[0] = iArr[0] + iArr[5];
        iArr[6] = iArr[6] + iArr[7];
        iArr[6] = iArr[6] ^ (iArr[7] << 8);
        iArr[1] = iArr[1] + iArr[6];
        iArr[7] = iArr[7] + iArr[0];
        iArr[7] = iArr[7] ^ (iArr[0] >>> 9);
        iArr[2] = iArr[2] + iArr[7];
        iArr[0] = iArr[0] + iArr[1];
    }

    public final void c(byte[] bArr) {
        this.h = bArr;
        if (this.a == null) {
            this.a = new int[256];
        }
        if (this.b == null) {
            this.b = new int[256];
        }
        for (int i2 = 0; i2 < 256; i2++) {
            int[] iArr = this.a;
            this.b[i2] = 0;
            iArr[i2] = 0;
        }
        this.e = 0;
        this.d = 0;
        this.c = 0;
        this.f = 0;
        int length = bArr.length + (bArr.length & 3);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i3 = 0; i3 < length; i3 += 4) {
            this.b[i3 >>> 2] = Pack.littleEndianToInt(bArr2, i3);
        }
        int[] iArr2 = new int[8];
        for (int i4 = 0; i4 < 8; i4++) {
            iArr2[i4] = -1640531527;
        }
        for (int i5 = 0; i5 < 4; i5++) {
            b(iArr2);
        }
        int i6 = 0;
        while (i6 < 2) {
            for (int i7 = 0; i7 < 256; i7 += 8) {
                for (int i8 = 0; i8 < 8; i8++) {
                    iArr2[i8] = iArr2[i8] + (i6 < 1 ? this.b[i7 + i8] : this.a[i7 + i8]);
                }
                b(iArr2);
                for (int i9 = 0; i9 < 8; i9++) {
                    this.a[i7 + i9] = iArr2[i9];
                }
            }
            i6++;
        }
        a();
        this.i = true;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ISAAC";
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            c(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to ISAAC init - ")));
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        if (!this.i) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i2 + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i4 + i3 <= bArr2.length) {
            for (int i5 = 0; i5 < i3; i5++) {
                if (this.f == 0) {
                    a();
                    this.g = Pack.intToBigEndian(this.b);
                }
                byte[] bArr3 = this.g;
                int i6 = this.f;
                bArr2[i5 + i4] = (byte) (bArr3[i6] ^ bArr[i5 + i2]);
                this.f = (i6 + 1) & 1023;
            }
            return i3;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        c(this.h);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b2) {
        if (this.f == 0) {
            a();
            this.g = Pack.intToBigEndian(this.b);
        }
        byte[] bArr = this.g;
        int i2 = this.f;
        byte b3 = (byte) (b2 ^ bArr[i2]);
        this.f = (i2 + 1) & 1023;
        return b3;
    }
}
