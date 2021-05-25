package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import okio.Utf8;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
public final class TwofishEngine implements BlockCipher {
    public static final byte[][] j = {new byte[]{-87, 103, -77, -24, 4, -3, -93, 118, -102, -110, Byte.MIN_VALUE, 120, -28, -35, -47, 56, Ascii.CR, -58, 53, -104, Ascii.CAN, -9, -20, 108, 67, 117, 55, 38, -6, 19, -108, 72, -14, -48, -117, 48, -124, 84, -33, 35, Ascii.EM, 91, 61, 89, -13, -82, -94, -126, 99, 1, -125, 46, -39, 81, -101, 124, -90, -21, -91, -66, Ascii.SYN, Ascii.FF, -29, 97, -64, -116, 58, -11, 115, 44, 37, Ascii.VT, -69, 78, -119, 107, 83, 106, -76, -15, -31, -26, -67, 69, -30, -12, -74, 102, -52, -107, 3, 86, -44, Ascii.FS, Ascii.RS, -41, -5, -61, -114, -75, -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, 98, 113, -127, 121, 9, -83, 36, -51, -7, -40, -27, -59, -71, 77, 68, 8, -122, -25, -95, Ascii.GS, -86, -19, 6, 112, -78, -46, 65, 123, -96, 17, 49, -62, 39, -112, 32, -10, 96, -1, -106, 92, -79, -85, -98, -100, 82, Ascii.ESC, 95, -109, 10, -17, -111, -123, 73, -18, 45, 79, -113, 59, 71, -121, 109, 70, -42, 62, 105, 100, 42, -50, -53, 47, -4, -105, 5, 122, -84, Byte.MAX_VALUE, -43, Ascii.SUB, 75, Ascii.SO, -89, 90, 40, Ascii.DC4, Utf8.REPLACEMENT_BYTE, 41, -120, 60, 76, 2, -72, -38, -80, Ascii.ETB, 85, Ascii.US, -118, 125, 87, -57, -115, 116, -73, -60, -97, 114, 126, Ascii.NAK, 34, Ascii.DC2, 88, 7, -103, 52, 110, 80, -34, 104, 101, PSSSigner.TRAILER_IMPLICIT, -37, -8, -56, -88, 43, SignedBytes.MAX_POWER_OF_TWO, -36, -2, 50, -92, -54, Ascii.DLE, 33, -16, -45, 93, Ascii.SI, 0, 111, -99, 54, 66, 74, 94, -63, -32}, new byte[]{117, -13, -58, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, -42, 50, -40, -3, 55, 113, -15, -31, 48, Ascii.SI, -8, Ascii.ESC, -121, -6, 6, Utf8.REPLACEMENT_BYTE, 94, -70, -82, 91, -118, 0, PSSSigner.TRAILER_IMPLICIT, -99, 109, -63, -79, Ascii.SO, Byte.MIN_VALUE, 93, -46, -43, -96, -124, 7, Ascii.DC4, -75, -112, 44, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, -80, -67, 90, -4, 96, 98, -106, 108, 66, -9, Ascii.DLE, 124, 40, 39, -116, 19, -107, -100, -57, 36, 70, 59, 112, -54, -29, -123, -53, 17, -48, -109, -72, -90, -125, 32, -1, -97, 119, -61, -52, 3, 111, 8, -65, SignedBytes.MAX_POWER_OF_TWO, -25, 43, -30, 121, Ascii.FF, -86, -126, 65, 58, -22, -71, -28, -102, -92, -105, 126, -38, 122, Ascii.ETB, 102, -108, -95, Ascii.GS, 61, -16, -34, -77, Ascii.VT, 114, -89, Ascii.FS, -17, -47, 83, 62, -113, 51, 38, 95, -20, 118, 42, 73, -127, -120, -18, 33, -60, Ascii.SUB, -21, -39, -59, 57, -103, -51, -83, 49, -117, 1, Ascii.CAN, 35, -35, Ascii.US, 78, 45, -7, 72, 79, -14, 101, -114, 120, 92, 88, Ascii.EM, -115, -27, -104, 87, 103, Byte.MAX_VALUE, 5, 100, -81, 99, -74, -2, -11, -73, 60, -91, -50, -23, 104, 68, -32, 77, 67, 105, 41, 46, -84, Ascii.NAK, 89, -88, 10, -98, 110, 71, -33, 52, 53, 106, -49, -36, 34, -55, -64, -101, -119, -44, -19, -85, Ascii.DC2, -94, Ascii.CR, 82, -69, 2, 47, -87, -41, 97, Ascii.RS, -76, 80, 4, -10, -62, Ascii.SYN, 37, -122, 86, 85, 9, -66, -111}};
    public boolean a = false;
    public int[] b = new int[256];
    public int[] c = new int[256];
    public int[] d = new int[256];
    public int[] e = new int[256];
    public int[] f;
    public int[] g;
    public int h = 0;
    public byte[] i = null;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002f: APUT  (r3v0 int[]), (0 ??[int, short, byte, char]), (r7v2 int) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0038: APUT  
      (r4v0 int[])
      (0 ??[int, short, byte, char])
      (wrap: int : 0x0036: ARITH  (r8v2 int) = (wrap: int : 0x0035: ARITH  (r8v1 int) = (wrap: int : 0x0031: INVOKE  (r8v0 int) = (r10v0 'this' org.spongycastle.crypto.engines.TwofishEngine A[IMMUTABLE_TYPE, THIS]), (r7v2 int) type: VIRTUAL call: org.spongycastle.crypto.engines.TwofishEngine.f(int):int) ^ (r7v2 int)) & (255 int))
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0040: APUT  
      (r2v6 int[])
      (0 ??[int, short, byte, char])
      (wrap: int : 0x003e: ARITH  (r7v4 int) = (wrap: int : 0x003a: INVOKE  (r7v3 int) = (r10v0 'this' org.spongycastle.crypto.engines.TwofishEngine A[IMMUTABLE_TYPE, THIS]), (r7v2 int) type: VIRTUAL call: org.spongycastle.crypto.engines.TwofishEngine.g(int):int) & (255 int))
     */
    public TwofishEngine() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        for (int i2 = 0; i2 < 256; i2++) {
            byte[][] bArr = j;
            int i3 = bArr[0][i2] & 255;
            iArr[0] = i3;
            iArr2[0] = (f(i3) ^ i3) & 255;
            iArr3[0] = g(i3) & 255;
            int i4 = bArr[1][i2] & 255;
            iArr[1] = i4;
            iArr2[1] = (f(i4) ^ i4) & 255;
            iArr3[1] = g(i4) & 255;
            this.b[i2] = iArr[1] | (iArr2[1] << 8) | (iArr3[1] << 16) | (iArr3[1] << 24);
            this.c[i2] = iArr3[0] | (iArr3[0] << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            this.d[i2] = (iArr3[1] << 24) | iArr2[1] | (iArr3[1] << 8) | (iArr[1] << 16);
            this.e[i2] = iArr2[0] | (iArr[0] << 8) | (iArr3[0] << 16) | (iArr2[0] << 24);
        }
    }

    public final void a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        bArr[i3 + 1] = (byte) (i2 >> 8);
        bArr[i3 + 2] = (byte) (i2 >> 16);
        bArr[i3 + 3] = (byte) (i2 >> 24);
    }

    public final int b(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public final int c(int i2, int[] iArr) {
        int i3;
        int i4;
        int i5 = i2 & 255;
        int i6 = (i2 >>> 8) & 255;
        int i7 = (i2 >>> 16) & 255;
        int i8 = (i2 >>> 24) & 255;
        int i9 = iArr[0];
        int i10 = iArr[1];
        int i11 = iArr[2];
        int i12 = iArr[3];
        int i13 = this.h & 3;
        if (i13 == 0) {
            byte[][] bArr = j;
            i5 = (bArr[1][i5] & 255) ^ (i12 & 255);
            i6 = (bArr[0][i6] & 255) ^ ((i12 >>> 8) & 255);
            i7 = (bArr[0][i7] & 255) ^ ((i12 >>> 16) & 255);
            i8 = (bArr[1][i8] & 255) ^ ((i12 >>> 24) & 255);
        } else if (i13 != 1) {
            if (i13 != 2) {
                if (i13 != 3) {
                    return 0;
                }
            }
            int[] iArr2 = this.b;
            byte[][] bArr2 = j;
            i3 = (iArr2[(bArr2[0][(bArr2[0][i5] & 255) ^ (i10 & 255)] & 255) ^ (i9 & 255)] ^ this.c[(bArr2[0][(bArr2[1][i6] & 255) ^ ((i10 >>> 8) & 255)] & 255) ^ ((i9 >>> 8) & 255)]) ^ this.d[(bArr2[1][(bArr2[0][i7] & 255) ^ ((i10 >>> 16) & 255)] & 255) ^ ((i9 >>> 16) & 255)];
            i4 = this.e[(bArr2[1][(bArr2[1][i8] & 255) ^ ((i10 >>> 24) & 255)] & 255) ^ ((i9 >>> 24) & 255)];
            return i3 ^ i4;
        } else {
            int[] iArr3 = this.b;
            byte[][] bArr3 = j;
            i3 = (iArr3[(bArr3[0][i5] & 255) ^ (i9 & 255)] ^ this.c[(bArr3[0][i6] & 255) ^ ((i9 >>> 8) & 255)]) ^ this.d[(bArr3[1][i7] & 255) ^ ((i9 >>> 16) & 255)];
            i4 = this.e[(bArr3[1][i8] & 255) ^ ((i9 >>> 24) & 255)];
            return i3 ^ i4;
        }
        byte[][] bArr4 = j;
        i5 = (bArr4[1][i5] & 255) ^ (i11 & 255);
        i6 = (bArr4[1][i6] & 255) ^ ((i11 >>> 8) & 255);
        i7 = (bArr4[0][i7] & 255) ^ ((i11 >>> 16) & 255);
        i8 = (bArr4[0][i8] & 255) ^ ((i11 >>> 24) & 255);
        int[] iArr2 = this.b;
        byte[][] bArr2 = j;
        i3 = (iArr2[(bArr2[0][(bArr2[0][i5] & 255) ^ (i10 & 255)] & 255) ^ (i9 & 255)] ^ this.c[(bArr2[0][(bArr2[1][i6] & 255) ^ ((i10 >>> 8) & 255)] & 255) ^ ((i9 >>> 8) & 255)]) ^ this.d[(bArr2[1][(bArr2[0][i7] & 255) ^ ((i10 >>> 16) & 255)] & 255) ^ ((i9 >>> 16) & 255)];
        i4 = this.e[(bArr2[1][(bArr2[1][i8] & 255) ^ ((i10 >>> 24) & 255)] & 255) ^ ((i9 >>> 24) & 255)];
        return i3 ^ i4;
    }

    public final int d(int i2) {
        int[] iArr = this.g;
        return iArr[(((i2 >>> 24) & 255) * 2) + 513] ^ ((iArr[((i2 & 255) * 2) + 0] ^ iArr[(((i2 >>> 8) & 255) * 2) + 1]) ^ iArr[(((i2 >>> 16) & 255) * 2) + 512]);
    }

    public final int e(int i2) {
        int[] iArr = this.g;
        return iArr[(((i2 >>> 16) & 255) * 2) + 513] ^ ((iArr[(((i2 >>> 24) & 255) * 2) + 0] ^ iArr[((i2 & 255) * 2) + 1]) ^ iArr[(((i2 >>> 8) & 255) * 2) + 512]);
    }

    public final int f(int i2) {
        int i3 = 0;
        int i4 = (i2 >> 2) ^ ((i2 & 2) != 0 ? 180 : 0);
        if ((i2 & 1) != 0) {
            i3 = 90;
        }
        return i4 ^ i3;
    }

    public final int g(int i2) {
        return f(i2) ^ (((i2 >> 1) ^ ((i2 & 1) != 0 ? 180 : 0)) ^ i2);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Twofish";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    public final int h(int i2) {
        int i3 = (i2 >>> 24) & 255;
        int i4 = 0;
        int i5 = ((i3 << 1) ^ ((i3 & 128) != 0 ? 333 : 0)) & 255;
        int i6 = i3 >>> 1;
        if ((i3 & 1) != 0) {
            i4 = 166;
        }
        int i7 = (i6 ^ i4) ^ i5;
        return ((((i2 << 8) ^ (i7 << 24)) ^ (i5 << 16)) ^ (i7 << 8)) ^ i3;
    }

    public final void i(byte[] bArr) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.f = new int[40];
        int i10 = this.h;
        if (i10 < 1) {
            throw new IllegalArgumentException("Key size less than 64 bits");
        } else if (i10 <= 4) {
            char c2 = 0;
            for (int i11 = 0; i11 < this.h; i11++) {
                int i12 = i11 * 8;
                iArr[i11] = b(bArr, i12);
                iArr2[i11] = b(bArr, i12 + 4);
                int i13 = (this.h - 1) - i11;
                int i14 = iArr[i11];
                int i15 = iArr2[i11];
                for (int i16 = 0; i16 < 4; i16++) {
                    i15 = h(i15);
                }
                int i17 = i14 ^ i15;
                for (int i18 = 0; i18 < 4; i18++) {
                    i17 = h(i17);
                }
                iArr3[i13] = i17;
            }
            for (int i19 = 0; i19 < 20; i19++) {
                int i20 = 33686018 * i19;
                int c3 = c(i20, iArr);
                int c4 = c(i20 + 16843009, iArr2);
                int i21 = (c4 >>> 24) | (c4 << 8);
                int i22 = c3 + i21;
                int[] iArr4 = this.f;
                int i23 = i19 * 2;
                iArr4[i23] = i22;
                int i24 = i22 + i21;
                iArr4[i23 + 1] = (i24 << 9) | (i24 >>> 23);
            }
            int i25 = iArr3[0];
            int i26 = iArr3[1];
            int i27 = 2;
            int i28 = iArr3[2];
            int i29 = 3;
            int i30 = iArr3[3];
            this.g = new int[1024];
            int i31 = 0;
            while (i31 < 256) {
                int i32 = this.h & i29;
                if (i32 != 0) {
                    if (i32 == 1) {
                        int[] iArr5 = this.g;
                        int i33 = i31 * 2;
                        int[] iArr6 = this.b;
                        byte[][] bArr2 = j;
                        iArr5[i33] = iArr6[(bArr2[c2][i31] & 255) ^ (i25 & 255)];
                        iArr5[i33 + 1] = this.c[((i25 >>> 8) & 255) ^ (bArr2[c2][i31] & 255)];
                        iArr5[i33 + 512] = this.d[(bArr2[1][i31] & 255) ^ ((i25 >>> 16) & 255)];
                        iArr5[i33 + 513] = this.e[(bArr2[1][i31] & 255) ^ ((i25 >>> 24) & 255)];
                    } else if (i32 == i27) {
                        i5 = i31;
                        i4 = i5;
                        i3 = i4;
                        i2 = i3;
                        int[] iArr7 = this.g;
                        int i34 = i31 * 2;
                        int[] iArr8 = this.b;
                        byte[][] bArr3 = j;
                        iArr7[i34] = iArr8[(bArr3[c2][(i26 & 255) ^ (bArr3[c2][i4] & 255)] & 255) ^ (i25 & 255)];
                        iArr7[i34 + 1] = this.c[(bArr3[c2][((i26 >>> 8) & 255) ^ (bArr3[1][i3] & 255)] & 255) ^ ((i25 >>> 8) & 255)];
                        iArr7[i34 + 512] = this.d[(bArr3[1][(bArr3[0][i2] & 255) ^ ((i26 >>> 16) & 255)] & 255) ^ ((i25 >>> 16) & 255)];
                        iArr7[i34 + 513] = this.e[(bArr3[1][(bArr3[1][i5] & 255) ^ ((i26 >>> 24) & 255)] & 255) ^ ((i25 >>> 24) & 255)];
                        i31++;
                        i27 = 2;
                        c2 = 0;
                        i29 = 3;
                    } else if (i32 == i29) {
                        i9 = i31;
                        i8 = i9;
                        i7 = i8;
                        i6 = i7;
                    }
                    i31++;
                    i27 = 2;
                    c2 = 0;
                    i29 = 3;
                } else {
                    byte[][] bArr4 = j;
                    i8 = (bArr4[1][i31] & 255) ^ (i30 & 255);
                    i7 = (bArr4[c2][i31] & 255) ^ ((i30 >>> 8) & 255);
                    i6 = (bArr4[c2][i31] & 255) ^ ((i30 >>> 16) & 255);
                    i9 = (bArr4[1][i31] & 255) ^ ((i30 >>> 24) & 255);
                }
                byte[][] bArr5 = j;
                i4 = (bArr5[1][i8] & 255) ^ (i28 & 255);
                i3 = (bArr5[1][i7] & 255) ^ ((i28 >>> 8) & 255);
                i2 = (bArr5[c2][i6] & 255) ^ ((i28 >>> 16) & 255);
                i5 = (bArr5[c2][i9] & 255) ^ ((i28 >>> 24) & 255);
                int[] iArr7 = this.g;
                int i34 = i31 * 2;
                int[] iArr8 = this.b;
                byte[][] bArr3 = j;
                iArr7[i34] = iArr8[(bArr3[c2][(i26 & 255) ^ (bArr3[c2][i4] & 255)] & 255) ^ (i25 & 255)];
                iArr7[i34 + 1] = this.c[(bArr3[c2][((i26 >>> 8) & 255) ^ (bArr3[1][i3] & 255)] & 255) ^ ((i25 >>> 8) & 255)];
                iArr7[i34 + 512] = this.d[(bArr3[1][(bArr3[0][i2] & 255) ^ ((i26 >>> 16) & 255)] & 255) ^ ((i25 >>> 16) & 255)];
                iArr7[i34 + 513] = this.e[(bArr3[1][(bArr3[1][i5] & 255) ^ ((i26 >>> 24) & 255)] & 255) ^ ((i25 >>> 24) & 255)];
                i31++;
                i27 = 2;
                c2 = 0;
                i29 = 3;
            }
        } else {
            throw new IllegalArgumentException("Key size larger than 256 bits");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.a = z;
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.i = key;
            this.h = key.length / 8;
            i(key);
            return;
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to Twofish init - ")));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        if (this.i == null) {
            throw new IllegalStateException("Twofish not initialised");
        } else if (i2 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + 16 <= bArr2.length) {
            int i4 = 0;
            if (this.a) {
                int b2 = b(bArr, i2) ^ this.f[0];
                int b3 = this.f[1] ^ b(bArr, i2 + 4);
                int b4 = b(bArr, i2 + 8) ^ this.f[2];
                int b5 = b(bArr, i2 + 12) ^ this.f[3];
                int i5 = 8;
                for (int i6 = 16; i4 < i6; i6 = 16) {
                    int d2 = d(b2);
                    int e2 = e(b3);
                    int[] iArr = this.f;
                    int i7 = i5 + 1;
                    int i8 = b4 ^ ((d2 + e2) + iArr[i5]);
                    b4 = (i8 >>> 1) | (i8 << 31);
                    int i9 = i7 + 1;
                    b5 = ((b5 >>> 31) | (b5 << 1)) ^ (((e2 * 2) + d2) + iArr[i7]);
                    int d3 = d(b4);
                    int e3 = e(b5);
                    int[] iArr2 = this.f;
                    int i10 = i9 + 1;
                    int i11 = b2 ^ ((d3 + e3) + iArr2[i9]);
                    b2 = (i11 << 31) | (i11 >>> 1);
                    b3 = ((b3 << 1) | (b3 >>> 31)) ^ (((e3 * 2) + d3) + iArr2[i10]);
                    i4 += 2;
                    i5 = i10 + 1;
                }
                a(this.f[4] ^ b4, bArr2, i3);
                a(b5 ^ this.f[5], bArr2, i3 + 4);
                a(this.f[6] ^ b2, bArr2, i3 + 8);
                a(this.f[7] ^ b3, bArr2, i3 + 12);
                return 16;
            }
            int b6 = b(bArr, i2) ^ this.f[4];
            int b8 = b(bArr, i2 + 4) ^ this.f[5];
            int b9 = this.f[6] ^ b(bArr, i2 + 8);
            int b10 = b(bArr, i2 + 12) ^ this.f[7];
            int i12 = 39;
            for (int i13 = 0; i13 < 16; i13 += 2) {
                int d4 = d(b6);
                int e4 = e(b8);
                int[] iArr3 = this.f;
                int i14 = i12 - 1;
                int i15 = b10 ^ (((e4 * 2) + d4) + iArr3[i12]);
                int i16 = i14 - 1;
                b9 = ((b9 >>> 31) | (b9 << 1)) ^ ((d4 + e4) + iArr3[i14]);
                b10 = (i15 << 31) | (i15 >>> 1);
                int d5 = d(b9);
                int e5 = e(b10);
                int[] iArr4 = this.f;
                int i17 = i16 - 1;
                int i18 = b8 ^ (((e5 * 2) + d5) + iArr4[i16]);
                i12 = i17 - 1;
                b6 = ((b6 >>> 31) | (b6 << 1)) ^ ((d5 + e5) + iArr4[i17]);
                b8 = (i18 << 31) | (i18 >>> 1);
            }
            a(this.f[0] ^ b9, bArr2, i3);
            a(b10 ^ this.f[1], bArr2, i3 + 4);
            a(this.f[2] ^ b6, bArr2, i3 + 8);
            a(this.f[3] ^ b8, bArr2, i3 + 12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.i;
        if (bArr != null) {
            i(bArr);
        }
    }
}
