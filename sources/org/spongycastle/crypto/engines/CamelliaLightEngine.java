package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import okio.Utf8;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
public class CamelliaLightEngine implements BlockCipher {
    public static final int[] g = {-1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691};
    public static final byte[] h = {112, -126, 44, -20, -77, 39, -64, -27, -28, -123, 87, 53, -22, Ascii.FF, -82, 65, 35, -17, 107, -109, 69, Ascii.EM, -91, 33, -19, Ascii.SO, 79, 78, Ascii.GS, 101, -110, -67, -122, -72, -81, -113, 124, -21, Ascii.US, -50, 62, 48, -36, 95, 94, -59, Ascii.VT, Ascii.SUB, -90, -31, 57, -54, -43, 71, 93, 61, -39, 1, 90, -42, 81, 86, 108, 77, -117, Ascii.CR, -102, 102, -5, -52, -80, 45, 116, Ascii.DC2, 43, 32, -16, -79, -124, -103, -33, 76, -53, -62, 52, 126, 118, 5, 109, -73, -87, 49, -47, Ascii.ETB, 4, -41, Ascii.DC4, 88, 58, 97, -34, Ascii.ESC, 17, Ascii.FS, 50, Ascii.SI, -100, Ascii.SYN, 83, Ascii.CAN, -14, 34, -2, 68, -49, -78, -61, -75, 122, -111, 36, 8, -24, -88, 96, -4, 105, 80, -86, -48, -96, 125, -95, -119, 98, -105, 84, 91, Ascii.RS, -107, -32, -1, 100, -46, Ascii.DLE, -60, 0, 72, -93, -9, 117, -37, -118, 3, -26, -38, 9, Utf8.REPLACEMENT_BYTE, -35, -108, -121, 92, -125, 2, -51, 74, -112, 51, 115, 103, -10, -13, -99, Byte.MAX_VALUE, -65, -30, 82, -101, -40, 38, -56, 55, -58, 59, -127, -106, 111, 75, 19, -66, 99, 46, -23, 121, -89, -116, -97, 110, PSSSigner.TRAILER_IMPLICIT, -114, 41, -11, -7, -74, 47, -3, -76, 89, 120, -104, 6, 106, -25, 70, 113, -70, -44, 37, -85, 66, -120, -94, -115, -6, 114, 7, -71, 85, -8, -18, -84, 10, 54, 73, 42, 104, 60, 56, -15, -92, SignedBytes.MAX_POWER_OF_TWO, 40, -45, 123, -69, -55, 67, -63, Ascii.NAK, -29, -83, -12, 119, -57, Byte.MIN_VALUE, -98};
    public boolean a;
    public boolean b;
    public int[] c = new int[96];
    public int[] d = new int[8];
    public int[] e = new int[12];
    public int[] f = new int[4];

    public static void d(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 2;
        int i5 = i2 + 0;
        int i6 = i2 + 1;
        int i7 = 32 - i;
        iArr2[i4] = (iArr[i5] << i) | (iArr[i6] >>> i7);
        int i8 = i3 + 3;
        int i9 = i2 + 2;
        iArr2[i8] = (iArr[i6] << i) | (iArr[i9] >>> i7);
        int i10 = i3 + 0;
        int i11 = i2 + 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i11] >>> i7);
        int i12 = i3 + 1;
        iArr2[i12] = (iArr[i11] << i) | (iArr[i5] >>> i7);
        iArr[i5] = iArr2[i4];
        iArr[i6] = iArr2[i8];
        iArr[i9] = iArr2[i10];
        iArr[i11] = iArr2[i12];
    }

    public static void e(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 2;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        int i8 = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i8);
        int i9 = i3 + 3;
        int i10 = i2 + 3;
        iArr2[i9] = (iArr[i7] << i6) | (iArr[i10] >>> i8);
        int i11 = i3 + 0;
        int i12 = i2 + 0;
        iArr2[i11] = (iArr[i10] << i6) | (iArr[i12] >>> i8);
        int i13 = i3 + 1;
        iArr2[i13] = (iArr[i5] >>> i8) | (iArr[i12] << i6);
        iArr[i12] = iArr2[i4];
        iArr[i5] = iArr2[i9];
        iArr[i7] = iArr2[i11];
        iArr[i10] = iArr2[i13];
    }

    public static int h(int i, int i2) {
        return (i << i2) + (i >>> (32 - i2));
    }

    public static void i(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 0;
        int i5 = i2 + 0;
        int i6 = i2 + 1;
        int i7 = 32 - i;
        iArr2[i4] = (iArr[i5] << i) | (iArr[i6] >>> i7);
        int i8 = i3 + 1;
        int i9 = i2 + 2;
        iArr2[i8] = (iArr[i6] << i) | (iArr[i9] >>> i7);
        int i10 = i3 + 2;
        int i11 = i2 + 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i11] >>> i7);
        int i12 = i3 + 3;
        iArr2[i12] = (iArr[i11] << i) | (iArr[i5] >>> i7);
        iArr[i5] = iArr2[i4];
        iArr[i6] = iArr2[i8];
        iArr[i9] = iArr2[i10];
        iArr[i11] = iArr2[i12];
    }

    public static void j(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 0;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        int i8 = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i8);
        int i9 = i3 + 1;
        int i10 = i2 + 3;
        iArr2[i9] = (iArr[i7] << i6) | (iArr[i10] >>> i8);
        int i11 = i3 + 2;
        int i12 = i2 + 0;
        iArr2[i11] = (iArr[i10] << i6) | (iArr[i12] >>> i8);
        int i13 = i3 + 3;
        iArr2[i13] = (iArr[i5] >>> i8) | (iArr[i12] << i6);
        iArr[i12] = iArr2[i4];
        iArr[i5] = iArr2[i9];
        iArr[i7] = iArr2[i11];
        iArr[i10] = iArr2[i13];
    }

    public final int a(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = (i2 << 8) + (bArr[i3 + i] & 255);
        }
        return i2;
    }

    public final void b(int[] iArr, int[] iArr2, int i) {
        int i2 = iArr[0] ^ iArr2[i + 0];
        int m = m(i2 & 255) | (l((i2 >>> 8) & 255) << 8) | (k((i2 >>> 16) & 255) << 16);
        byte[] bArr = h;
        int i3 = iArr[1] ^ iArr2[i + 1];
        int h2 = h((k((i3 >>> 24) & 255) << 24) | (bArr[i3 & 255] & 255) | (m((i3 >>> 8) & 255) << 8) | (l((i3 >>> 16) & 255) << 16), 8);
        int i4 = (((bArr[(i2 >>> 24) & 255] & 255) << 24) | m) ^ h2;
        int h3 = h(h2, 8) ^ i4;
        int i5 = ((i4 >>> 8) + (i4 << 24)) ^ h3;
        iArr[2] = (h(h3, 16) ^ i5) ^ iArr[2];
        iArr[3] = h(i5, 8) ^ iArr[3];
        int i6 = iArr[2] ^ iArr2[i + 2];
        int m2 = ((bArr[(i6 >>> 24) & 255] & 255) << 24) | m(i6 & 255) | (l((i6 >>> 8) & 255) << 8) | (k((i6 >>> 16) & 255) << 16);
        int i7 = iArr2[i + 3] ^ iArr[3];
        int h4 = h((k((i7 >>> 24) & 255) << 24) | (bArr[i7 & 255] & 255) | (m((i7 >>> 8) & 255) << 8) | (l((i7 >>> 16) & 255) << 16), 8);
        int i8 = m2 ^ h4;
        int h5 = h(h4, 8) ^ i8;
        int i9 = ((i8 >>> 8) + (i8 << 24)) ^ h5;
        iArr[0] = (h(h5, 16) ^ i9) ^ iArr[0];
        iArr[1] = iArr[1] ^ h(i9, 8);
    }

    public final void c(int[] iArr, int[] iArr2, int i) {
        iArr[1] = iArr[1] ^ h(iArr[0] & iArr2[i + 0], 1);
        iArr[0] = iArr[0] ^ (iArr2[i + 1] | iArr[1]);
        iArr[2] = iArr[2] ^ (iArr2[i + 3] | iArr[3]);
        iArr[3] = h(iArr2[i + 2] & iArr[2], 1) ^ iArr[3];
    }

    public final void f(int i, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[(3 - i3) + i2] = (byte) i;
            i >>>= 8;
        }
    }

    public final byte g(byte b2, int i) {
        return (byte) (((b2 & 255) >>> (8 - i)) | (b2 << i));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Camellia";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            int[] iArr = new int[8];
            int[] iArr2 = new int[4];
            int[] iArr3 = new int[4];
            int[] iArr4 = new int[4];
            int length = key.length;
            if (length == 16) {
                this.b = true;
                iArr[0] = a(key, 0);
                iArr[1] = a(key, 4);
                iArr[2] = a(key, 8);
                iArr[3] = a(key, 12);
                iArr[7] = 0;
                iArr[6] = 0;
                iArr[5] = 0;
                iArr[4] = 0;
            } else if (length == 24) {
                iArr[0] = a(key, 0);
                iArr[1] = a(key, 4);
                iArr[2] = a(key, 8);
                iArr[3] = a(key, 12);
                iArr[4] = a(key, 16);
                iArr[5] = a(key, 20);
                iArr[6] = ~iArr[4];
                iArr[7] = ~iArr[5];
                this.b = false;
            } else if (length == 32) {
                iArr[0] = a(key, 0);
                iArr[1] = a(key, 4);
                iArr[2] = a(key, 8);
                iArr[3] = a(key, 12);
                iArr[4] = a(key, 16);
                iArr[5] = a(key, 20);
                iArr[6] = a(key, 24);
                iArr[7] = a(key, 28);
                this.b = false;
            } else {
                throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
            }
            for (int i = 0; i < 4; i++) {
                iArr2[i] = iArr[i] ^ iArr[i + 4];
            }
            b(iArr2, g, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                iArr2[i2] = iArr2[i2] ^ iArr[i2];
            }
            b(iArr2, g, 4);
            if (!this.b) {
                for (int i3 = 0; i3 < 4; i3++) {
                    iArr3[i3] = iArr2[i3] ^ iArr[i3 + 4];
                }
                b(iArr3, g, 8);
                if (z) {
                    int[] iArr5 = this.d;
                    iArr5[0] = iArr[0];
                    iArr5[1] = iArr[1];
                    iArr5[2] = iArr[2];
                    iArr5[3] = iArr[3];
                    j(45, iArr, 0, this.c, 16);
                    i(15, iArr, 0, this.e, 4);
                    i(17, iArr, 0, this.c, 32);
                    j(34, iArr, 0, this.c, 44);
                    i(15, iArr, 4, this.c, 4);
                    i(15, iArr, 4, this.e, 0);
                    i(30, iArr, 4, this.c, 24);
                    j(34, iArr, 4, this.c, 36);
                    i(15, iArr2, 0, this.c, 8);
                    i(30, iArr2, 0, this.c, 20);
                    int[] iArr6 = this.e;
                    iArr6[8] = iArr2[1];
                    iArr6[9] = iArr2[2];
                    iArr6[10] = iArr2[3];
                    iArr6[11] = iArr2[0];
                    j(49, iArr2, 0, this.c, 40);
                    int[] iArr7 = this.c;
                    iArr7[0] = iArr3[0];
                    iArr7[1] = iArr3[1];
                    iArr7[2] = iArr3[2];
                    iArr7[3] = iArr3[3];
                    i(30, iArr3, 0, iArr7, 12);
                    i(30, iArr3, 0, this.c, 28);
                    j(51, iArr3, 0, this.d, 4);
                } else {
                    int[] iArr8 = this.d;
                    iArr8[4] = iArr[0];
                    iArr8[5] = iArr[1];
                    iArr8[6] = iArr[2];
                    iArr8[7] = iArr[3];
                    e(45, iArr, 0, this.c, 28);
                    d(15, iArr, 0, this.e, 4);
                    d(17, iArr, 0, this.c, 12);
                    e(34, iArr, 0, this.c, 0);
                    d(15, iArr, 4, this.c, 40);
                    d(15, iArr, 4, this.e, 8);
                    d(30, iArr, 4, this.c, 20);
                    e(34, iArr, 4, this.c, 8);
                    d(15, iArr2, 0, this.c, 36);
                    d(30, iArr2, 0, this.c, 24);
                    int[] iArr9 = this.e;
                    iArr9[2] = iArr2[1];
                    iArr9[3] = iArr2[2];
                    iArr9[0] = iArr2[3];
                    iArr9[1] = iArr2[0];
                    e(49, iArr2, 0, this.c, 4);
                    int[] iArr10 = this.c;
                    iArr10[46] = iArr3[0];
                    iArr10[47] = iArr3[1];
                    iArr10[44] = iArr3[2];
                    iArr10[45] = iArr3[3];
                    d(30, iArr3, 0, iArr10, 32);
                    d(30, iArr3, 0, this.c, 16);
                    j(51, iArr3, 0, this.d, 0);
                }
            } else if (z) {
                int[] iArr11 = this.d;
                iArr11[0] = iArr[0];
                iArr11[1] = iArr[1];
                iArr11[2] = iArr[2];
                iArr11[3] = iArr[3];
                i(15, iArr, 0, this.c, 4);
                i(30, iArr, 0, this.c, 12);
                i(15, iArr, 0, iArr4, 0);
                int[] iArr12 = this.c;
                iArr12[18] = iArr4[2];
                iArr12[19] = iArr4[3];
                i(17, iArr, 0, this.e, 4);
                i(17, iArr, 0, this.c, 24);
                i(17, iArr, 0, this.c, 32);
                int[] iArr13 = this.c;
                iArr13[0] = iArr2[0];
                iArr13[1] = iArr2[1];
                iArr13[2] = iArr2[2];
                iArr13[3] = iArr2[3];
                i(15, iArr2, 0, iArr13, 8);
                i(15, iArr2, 0, this.e, 0);
                i(15, iArr2, 0, iArr4, 0);
                int[] iArr14 = this.c;
                iArr14[16] = iArr4[0];
                iArr14[17] = iArr4[1];
                i(15, iArr2, 0, iArr14, 20);
                j(34, iArr2, 0, this.c, 28);
                i(17, iArr2, 0, this.d, 4);
            } else {
                int[] iArr15 = this.d;
                iArr15[4] = iArr[0];
                iArr15[5] = iArr[1];
                iArr15[6] = iArr[2];
                iArr15[7] = iArr[3];
                d(15, iArr, 0, this.c, 28);
                d(30, iArr, 0, this.c, 20);
                d(15, iArr, 0, iArr4, 0);
                int[] iArr16 = this.c;
                iArr16[16] = iArr4[0];
                iArr16[17] = iArr4[1];
                d(17, iArr, 0, this.e, 0);
                d(17, iArr, 0, this.c, 8);
                d(17, iArr, 0, this.c, 0);
                int[] iArr17 = this.c;
                iArr17[34] = iArr2[0];
                iArr17[35] = iArr2[1];
                iArr17[32] = iArr2[2];
                iArr17[33] = iArr2[3];
                d(15, iArr2, 0, iArr17, 24);
                d(15, iArr2, 0, this.e, 4);
                d(15, iArr2, 0, iArr4, 0);
                int[] iArr18 = this.c;
                iArr18[18] = iArr4[2];
                iArr18[19] = iArr4[3];
                d(15, iArr2, 0, iArr18, 12);
                e(34, iArr2, 0, this.c, 4);
                i(17, iArr2, 0, this.d, 0);
            }
            this.a = true;
            return;
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    public final int k(int i) {
        return g(h[i], 1) & 255;
    }

    public final int l(int i) {
        return g(h[i], 7) & 255;
    }

    public final int m(int i) {
        return h[g((byte) i, 1) & 255] & 255;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException {
        if (!this.a) {
            throw new IllegalStateException("Camellia is not initialized");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.b) {
            for (int i3 = 0; i3 < 4; i3++) {
                this.f[i3] = a(bArr, (i3 * 4) + i);
                int[] iArr = this.f;
                iArr[i3] = iArr[i3] ^ this.d[i3];
            }
            b(this.f, this.c, 0);
            b(this.f, this.c, 4);
            b(this.f, this.c, 8);
            c(this.f, this.e, 0);
            b(this.f, this.c, 12);
            b(this.f, this.c, 16);
            b(this.f, this.c, 20);
            c(this.f, this.e, 4);
            b(this.f, this.c, 24);
            b(this.f, this.c, 28);
            b(this.f, this.c, 32);
            int[] iArr2 = this.f;
            int i4 = iArr2[2];
            int[] iArr3 = this.d;
            iArr2[2] = i4 ^ iArr3[4];
            iArr2[3] = iArr2[3] ^ iArr3[5];
            iArr2[0] = iArr2[0] ^ iArr3[6];
            iArr2[1] = iArr2[1] ^ iArr3[7];
            f(iArr2[2], bArr2, i2);
            f(this.f[3], bArr2, i2 + 4);
            f(this.f[0], bArr2, i2 + 8);
            f(this.f[1], bArr2, i2 + 12);
            return 16;
        } else {
            for (int i5 = 0; i5 < 4; i5++) {
                this.f[i5] = a(bArr, (i5 * 4) + i);
                int[] iArr4 = this.f;
                iArr4[i5] = iArr4[i5] ^ this.d[i5];
            }
            b(this.f, this.c, 0);
            b(this.f, this.c, 4);
            b(this.f, this.c, 8);
            c(this.f, this.e, 0);
            b(this.f, this.c, 12);
            b(this.f, this.c, 16);
            b(this.f, this.c, 20);
            c(this.f, this.e, 4);
            b(this.f, this.c, 24);
            b(this.f, this.c, 28);
            b(this.f, this.c, 32);
            c(this.f, this.e, 8);
            b(this.f, this.c, 36);
            b(this.f, this.c, 40);
            b(this.f, this.c, 44);
            int[] iArr5 = this.f;
            int i6 = iArr5[2];
            int[] iArr6 = this.d;
            iArr5[2] = i6 ^ iArr6[4];
            iArr5[3] = iArr5[3] ^ iArr6[5];
            iArr5[0] = iArr5[0] ^ iArr6[6];
            iArr5[1] = iArr5[1] ^ iArr6[7];
            f(iArr5[2], bArr2, i2);
            f(this.f[3], bArr2, i2 + 4);
            f(this.f[0], bArr2, i2 + 8);
            f(this.f[1], bArr2, i2 + 12);
            return 16;
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
