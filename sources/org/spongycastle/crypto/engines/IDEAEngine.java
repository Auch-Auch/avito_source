package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import com.facebook.internal.NativeProtocol;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
public class IDEAEngine implements BlockCipher {
    public static final int BLOCK_SIZE = 8;
    public int[] a = null;

    public int a(int i) {
        return (0 - i) & 65535;
    }

    public final int b(byte[] bArr, int i) {
        return ((bArr[i] << 8) & 65280) + (bArr[i + 1] & 255);
    }

    public final int[] c(byte[] bArr) {
        int i;
        int[] iArr = new int[52];
        int i2 = 0;
        if (bArr.length < 16) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
            bArr = bArr2;
        }
        while (true) {
            if (i2 >= 8) {
                break;
            }
            iArr[i2] = b(bArr, i2 * 2);
            i2++;
        }
        for (i = 8; i < 52; i++) {
            int i3 = i & 7;
            if (i3 < 6) {
                iArr[i] = (((iArr[i - 7] & 127) << 9) | (iArr[i - 6] >> 7)) & 65535;
            } else if (i3 == 6) {
                iArr[i] = (((iArr[i - 7] & 127) << 9) | (iArr[i - 14] >> 7)) & 65535;
            } else {
                iArr[i] = (((iArr[i - 15] & 127) << 9) | (iArr[i - 14] >> 7)) & 65535;
            }
        }
        return iArr;
    }

    public final int d(int i, int i2) {
        int i3;
        if (i == 0) {
            i3 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY - i2;
        } else if (i2 == 0) {
            i3 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY - i;
        } else {
            int i4 = i * i2;
            int i5 = i4 & 65535;
            int i6 = i4 >>> 16;
            i3 = (i5 - i6) + (i5 < i6 ? 1 : 0);
        }
        return i3 & 65535;
    }

    public final int e(int i) {
        if (i < 2) {
            return i;
        }
        int i2 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY / i;
        int i3 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY % i;
        int i4 = 1;
        while (i3 != 1) {
            int i5 = i / i3;
            i %= i3;
            i4 = ((i5 * i2) + i4) & 65535;
            if (i == 1) {
                return i4;
            }
            int i6 = i3 / i;
            i3 %= i;
            i2 = ((i6 * i4) + i2) & 65535;
        }
        return (1 - i2) & 65535;
    }

    public final void f(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "IDEA";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        int[] iArr;
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (z) {
                iArr = c(key);
            } else {
                int[] c = c(key);
                int[] iArr2 = new int[52];
                int e = e(c[0]);
                int i = 1;
                int a3 = a(c[1]);
                int a4 = a(c[2]);
                iArr2[51] = e(c[3]);
                iArr2[50] = a4;
                iArr2[49] = a3;
                int i2 = 48;
                iArr2[48] = e;
                int i3 = 4;
                while (i < 8) {
                    int i4 = i3 + 1;
                    int i5 = c[i3];
                    int i6 = i4 + 1;
                    int i7 = i2 - 1;
                    iArr2[i7] = c[i4];
                    int i8 = i7 - 1;
                    iArr2[i8] = i5;
                    int i9 = i6 + 1;
                    int e2 = e(c[i6]);
                    int i10 = i9 + 1;
                    int a5 = a(c[i9]);
                    int i11 = i10 + 1;
                    int a6 = a(c[i10]);
                    int i12 = i8 - 1;
                    iArr2[i12] = e(c[i11]);
                    int i13 = i12 - 1;
                    iArr2[i13] = a5;
                    int i14 = i13 - 1;
                    iArr2[i14] = a6;
                    i2 = i14 - 1;
                    iArr2[i2] = e2;
                    i++;
                    i3 = i11 + 1;
                }
                int i15 = i3 + 1;
                int i16 = c[i3];
                int i17 = i15 + 1;
                int i18 = i2 - 1;
                iArr2[i18] = c[i15];
                int i19 = i18 - 1;
                iArr2[i19] = i16;
                int i20 = i17 + 1;
                int e3 = e(c[i17]);
                int i21 = i20 + 1;
                int a8 = a(c[i20]);
                int i22 = i21 + 1;
                int a9 = a(c[i21]);
                int i23 = i19 - 1;
                iArr2[i23] = e(c[i22]);
                int i24 = i23 - 1;
                iArr2[i24] = a9;
                int i25 = i24 - 1;
                iArr2[i25] = a8;
                iArr2[i25 - 1] = e3;
                iArr = iArr2;
            }
            this.a = iArr;
            return;
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to IDEA init - ")));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = this.a;
        if (iArr == null) {
            throw new IllegalStateException("IDEA engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            int b = b(bArr, i);
            int b2 = b(bArr, i + 2);
            int b3 = b(bArr, i + 4);
            int b4 = b(bArr, i + 6);
            int i3 = 0;
            int i4 = b3;
            int i5 = b2;
            int i6 = b;
            int i7 = 0;
            while (i3 < 8) {
                int i8 = i7 + 1;
                int d = d(i6, iArr[i7]);
                int i9 = i8 + 1;
                int i10 = (i5 + iArr[i8]) & 65535;
                int i11 = i9 + 1;
                int i12 = (i4 + iArr[i9]) & 65535;
                int i13 = i11 + 1;
                int d2 = d(b4, iArr[i11]);
                int i14 = i13 + 1;
                int d3 = d(i12 ^ d, iArr[i13]);
                int d4 = d(((i10 ^ d2) + d3) & 65535, iArr[i14]);
                int i15 = (d3 + d4) & 65535;
                b4 = d2 ^ i15;
                i4 = i15 ^ i10;
                i3++;
                i5 = i12 ^ d4;
                i6 = d ^ d4;
                i7 = i14 + 1;
            }
            int i16 = i7 + 1;
            int d5 = d(i6, iArr[i7]);
            bArr2[i2] = (byte) (d5 >>> 8);
            bArr2[i2 + 1] = (byte) d5;
            int i17 = i16 + 1;
            f(i4 + iArr[i16], bArr2, i2 + 2);
            f(i5 + iArr[i17], bArr2, i2 + 4);
            f(d(b4, iArr[i17 + 1]), bArr2, i2 + 6);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
