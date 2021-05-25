package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
public class HC128Engine implements StreamCipher {
    public int[] a = new int[512];
    public int[] b = new int[512];
    public int c = 0;
    public byte[] d;
    public byte[] e;
    public boolean f;
    public byte[] g = new byte[4];
    public int h = 0;

    public static int c(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public static int d(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    public final byte a() {
        if (this.h == 0) {
            int e2 = e();
            byte[] bArr = this.g;
            bArr[0] = (byte) (e2 & 255);
            int i = e2 >> 8;
            bArr[1] = (byte) (i & 255);
            int i2 = i >> 8;
            bArr[2] = (byte) (i2 & 255);
            bArr[3] = (byte) ((i2 >> 8) & 255);
        }
        byte[] bArr2 = this.g;
        int i3 = this.h;
        byte b2 = bArr2[i3];
        this.h = 3 & (i3 + 1);
        return b2;
    }

    public final void b() {
        if (this.d.length == 16) {
            this.h = 0;
            this.c = 0;
            int[] iArr = new int[1280];
            for (int i = 0; i < 16; i++) {
                int i2 = i >> 2;
                iArr[i2] = ((this.d[i] & 255) << ((i & 3) * 8)) | iArr[i2];
            }
            System.arraycopy(iArr, 0, iArr, 4, 4);
            int i3 = 0;
            while (true) {
                byte[] bArr = this.e;
                if (i3 >= bArr.length || i3 >= 16) {
                    break;
                }
                int i4 = (i3 >> 2) + 8;
                iArr[i4] = ((bArr[i3] & 255) << ((i3 & 3) * 8)) | iArr[i4];
                i3++;
            }
            System.arraycopy(iArr, 8, iArr, 12, 4);
            for (int i5 = 16; i5 < 1280; i5++) {
                int i6 = iArr[i5 - 2];
                int d2 = ((i6 >>> 10) ^ (d(i6, 17) ^ d(i6, 19))) + iArr[i5 - 7];
                int i7 = iArr[i5 - 15];
                iArr[i5] = d2 + ((i7 >>> 3) ^ (d(i7, 7) ^ d(i7, 18))) + iArr[i5 - 16] + i5;
            }
            System.arraycopy(iArr, 256, this.a, 0, 512);
            System.arraycopy(iArr, 768, this.b, 0, 512);
            for (int i8 = 0; i8 < 512; i8++) {
                this.a[i8] = e();
            }
            for (int i9 = 0; i9 < 512; i9++) {
                this.b[i9] = e();
            }
            this.c = 0;
            return;
        }
        throw new IllegalArgumentException("The key must be 128 bits long");
    }

    public final int e() {
        int i;
        int i2;
        int i3 = this.c;
        int i4 = i3 & 511;
        if (i3 < 512) {
            int[] iArr = this.a;
            int i5 = iArr[i4];
            int i6 = iArr[(i4 - 3) & 511];
            int i7 = iArr[(i4 - 10) & 511];
            int i8 = iArr[(i4 - 511) & 511];
            int d2 = d(i6, 10);
            iArr[i4] = i5 + d(i7, 8) + (d(i8, 23) ^ d2);
            int[] iArr2 = this.a;
            int i9 = iArr2[(i4 - 12) & 511];
            int[] iArr3 = this.b;
            i = iArr3[i9 & 255] + iArr3[((i9 >> 16) & 255) + 256];
            i2 = iArr2[i4];
        } else {
            int[] iArr4 = this.b;
            int i10 = iArr4[i4];
            int i11 = iArr4[(i4 - 3) & 511];
            int i12 = iArr4[(i4 - 10) & 511];
            int i13 = iArr4[(i4 - 511) & 511];
            int c2 = c(i11, 10);
            iArr4[i4] = i10 + c(i12, 8) + (c(i13, 23) ^ c2);
            int[] iArr5 = this.b;
            int i14 = iArr5[(i4 - 12) & 511];
            int[] iArr6 = this.a;
            i = iArr6[i14 & 255] + iArr6[((i14 >> 16) & 255) + 256];
            i2 = iArr5[i4];
        }
        int i15 = i2 ^ i;
        this.c = (this.c + 1) & 1023;
        return i15;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "HC-128";
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.e = parametersWithIV.getIV();
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            this.e = new byte[0];
            cipherParameters2 = cipherParameters;
        }
        if (cipherParameters2 instanceof KeyParameter) {
            this.d = ((KeyParameter) cipherParameters2).getKey();
            b();
            this.f = true;
            return;
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("Invalid parameter passed to HC128 init - ")));
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        if (!this.f) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ a());
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        b();
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b2) {
        return (byte) (b2 ^ a());
    }
}
