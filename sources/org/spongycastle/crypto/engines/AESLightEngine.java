package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Array;
import okio.Utf8;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.util.Pack;
public class AESLightEngine implements BlockCipher {
    public static final byte[] h = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.NAK, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, Ascii.DC2, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.SUB, Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, Ascii.DLE, -1, -13, -46, -51, Ascii.FF, 19, -20, 95, -105, 68, Ascii.ETB, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, Ascii.DC4, -34, 94, Ascii.VT, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, Ascii.FS, -90, -76, -58, -24, -35, 116, Ascii.US, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, Ascii.SO, 97, 53, 87, -71, -122, -63, Ascii.GS, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, Ascii.RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, Ascii.CR, -65, -26, 66, 104, 65, -103, 45, Ascii.SI, -80, 84, -69, Ascii.SYN};
    public static final byte[] i = {82, 9, 106, -43, 48, 54, -91, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, Ascii.VT, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, Ascii.SYN, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, Ascii.NAK, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, Ascii.RS, -113, -54, Utf8.REPLACEMENT_BYTE, Ascii.SI, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, Ascii.FS, 117, -33, 110, 71, -15, Ascii.SUB, 113, Ascii.GS, 41, -59, -119, 111, -73, 98, Ascii.SO, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, Ascii.US, -35, -88, 51, -120, 7, -57, 49, -79, Ascii.DC2, Ascii.DLE, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, Byte.MAX_VALUE, -87, Ascii.EM, -75, 74, Ascii.CR, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, Ascii.ETB, 43, 4, 126, -70, 119, -42, 38, -31, 105, Ascii.DC4, 99, 85, 33, Ascii.FF, 125};
    public static final int[] j = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
    public int a;
    public int[][] b = null;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;

    public static int a(int i2) {
        int d2 = d(i2, 8) ^ i2;
        int i3 = i2 ^ (((2139062143 & d2) << 1) ^ (((-2139062144 & d2) >>> 7) * 27));
        int i4 = -1061109568 & i3;
        int i5 = i4 ^ (i4 >>> 1);
        int i6 = d2 ^ ((((1061109567 & i3) << 2) ^ (i5 >>> 2)) ^ (i5 >>> 5));
        return i3 ^ (i6 ^ d(i6, 16));
    }

    public static int b(int i2) {
        int d2 = d(i2, 8);
        int i3 = i2 ^ d2;
        return ((((i3 & -2139062144) >>> 7) * 27) ^ ((2139062143 & i3) << 1)) ^ (d2 ^ d(i3, 16));
    }

    public static int d(int i2, int i3) {
        return (i2 << (-i3)) | (i2 >>> i3);
    }

    public static int e(int i2) {
        byte[] bArr = h;
        return (bArr[(i2 >> 24) & 255] << Ascii.CAN) | (bArr[i2 & 255] & 255) | ((bArr[(i2 >> 8) & 255] & 255) << 8) | ((bArr[(i2 >> 16) & 255] & 255) << 16);
    }

    public final void c(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = this.c;
        bArr[i2] = (byte) i4;
        int i5 = i3 + 1;
        bArr[i3] = (byte) (i4 >> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i4 >> 16);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i4 >> 24);
        int i8 = i7 + 1;
        int i9 = this.d;
        bArr[i7] = (byte) i9;
        int i10 = i8 + 1;
        bArr[i8] = (byte) (i9 >> 8);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i9 >> 16);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i9 >> 24);
        int i13 = i12 + 1;
        int i14 = this.e;
        bArr[i12] = (byte) i14;
        int i15 = i13 + 1;
        bArr[i13] = (byte) (i14 >> 8);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i14 >> 16);
        int i17 = i16 + 1;
        bArr[i16] = (byte) (i14 >> 24);
        int i18 = i17 + 1;
        int i19 = this.f;
        bArr[i17] = (byte) i19;
        int i20 = i18 + 1;
        bArr[i18] = (byte) (i19 >> 8);
        bArr[i20] = (byte) (i19 >> 16);
        bArr[i20 + 1] = (byte) (i19 >> 24);
    }

    public final void f(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = bArr[i2] & 255;
        this.c = i4;
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        this.c = i6;
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & 255) << 16);
        this.c = i8;
        int i9 = i7 + 1;
        this.c = i8 | (bArr[i7] << Ascii.CAN);
        int i10 = i9 + 1;
        int i11 = bArr[i9] & 255;
        this.d = i11;
        int i12 = i10 + 1;
        int i13 = ((bArr[i10] & 255) << 8) | i11;
        this.d = i13;
        int i14 = i12 + 1;
        int i15 = i13 | ((bArr[i12] & 255) << 16);
        this.d = i15;
        int i16 = i14 + 1;
        this.d = i15 | (bArr[i14] << Ascii.CAN);
        int i17 = i16 + 1;
        int i18 = bArr[i16] & 255;
        this.e = i18;
        int i19 = i17 + 1;
        int i20 = ((bArr[i17] & 255) << 8) | i18;
        this.e = i20;
        int i21 = i19 + 1;
        int i22 = i20 | ((bArr[i19] & 255) << 16);
        this.e = i22;
        int i23 = i21 + 1;
        this.e = i22 | (bArr[i21] << Ascii.CAN);
        int i24 = i23 + 1;
        int i25 = bArr[i23] & 255;
        this.f = i25;
        int i26 = i24 + 1;
        int i27 = ((bArr[i24] & 255) << 8) | i25;
        this.f = i27;
        int i28 = i27 | ((bArr[i26] & 255) << 16);
        this.f = i28;
        this.f = (bArr[i26 + 1] << Ascii.CAN) | i28;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "AES";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            int length = key.length;
            if (length < 16 || length > 32 || (length & 7) != 0) {
                throw new IllegalArgumentException("Key length not 128/192/256 bits.");
            }
            int i2 = length >> 2;
            int i3 = i2 + 6;
            this.a = i3;
            int[] iArr = new int[2];
            iArr[1] = 4;
            iArr[0] = i3 + 1;
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
            if (i2 == 4) {
                int littleEndianToInt = Pack.littleEndianToInt(key, 0);
                iArr2[0][0] = littleEndianToInt;
                int littleEndianToInt2 = Pack.littleEndianToInt(key, 4);
                iArr2[0][1] = littleEndianToInt2;
                int littleEndianToInt3 = Pack.littleEndianToInt(key, 8);
                iArr2[0][2] = littleEndianToInt3;
                int littleEndianToInt4 = Pack.littleEndianToInt(key, 12);
                iArr2[0][3] = littleEndianToInt4;
                for (int i4 = 1; i4 <= 10; i4++) {
                    littleEndianToInt ^= e(d(littleEndianToInt4, 8)) ^ j[i4 - 1];
                    iArr2[i4][0] = littleEndianToInt;
                    littleEndianToInt2 ^= littleEndianToInt;
                    iArr2[i4][1] = littleEndianToInt2;
                    littleEndianToInt3 ^= littleEndianToInt2;
                    iArr2[i4][2] = littleEndianToInt3;
                    littleEndianToInt4 ^= littleEndianToInt3;
                    iArr2[i4][3] = littleEndianToInt4;
                }
            } else if (i2 == 6) {
                int littleEndianToInt5 = Pack.littleEndianToInt(key, 0);
                iArr2[0][0] = littleEndianToInt5;
                int littleEndianToInt6 = Pack.littleEndianToInt(key, 4);
                iArr2[0][1] = littleEndianToInt6;
                int littleEndianToInt7 = Pack.littleEndianToInt(key, 8);
                iArr2[0][2] = littleEndianToInt7;
                int littleEndianToInt8 = Pack.littleEndianToInt(key, 12);
                iArr2[0][3] = littleEndianToInt8;
                int littleEndianToInt9 = Pack.littleEndianToInt(key, 16);
                iArr2[1][0] = littleEndianToInt9;
                int littleEndianToInt10 = Pack.littleEndianToInt(key, 20);
                iArr2[1][1] = littleEndianToInt10;
                int e2 = littleEndianToInt5 ^ (e(d(littleEndianToInt10, 8)) ^ 1);
                iArr2[1][2] = e2;
                int i5 = littleEndianToInt6 ^ e2;
                iArr2[1][3] = i5;
                int i6 = littleEndianToInt7 ^ i5;
                iArr2[2][0] = i6;
                int i7 = littleEndianToInt8 ^ i6;
                iArr2[2][1] = i7;
                int i8 = littleEndianToInt9 ^ i7;
                iArr2[2][2] = i8;
                int i9 = littleEndianToInt10 ^ i8;
                iArr2[2][3] = i9;
                int i10 = 2;
                for (int i11 = 3; i11 < 12; i11 += 3) {
                    int e3 = e(d(i9, 8)) ^ i10;
                    int i12 = i10 << 1;
                    int i13 = e2 ^ e3;
                    iArr2[i11][0] = i13;
                    int i14 = i5 ^ i13;
                    iArr2[i11][1] = i14;
                    int i15 = i6 ^ i14;
                    iArr2[i11][2] = i15;
                    int i16 = i7 ^ i15;
                    iArr2[i11][3] = i16;
                    int i17 = i8 ^ i16;
                    int i18 = i11 + 1;
                    iArr2[i18][0] = i17;
                    int i19 = i9 ^ i17;
                    iArr2[i18][1] = i19;
                    int e4 = e(d(i19, 8)) ^ i12;
                    i10 = i12 << 1;
                    e2 = i13 ^ e4;
                    iArr2[i18][2] = e2;
                    i5 = i14 ^ e2;
                    iArr2[i18][3] = i5;
                    i6 = i15 ^ i5;
                    int i20 = i11 + 2;
                    iArr2[i20][0] = i6;
                    i7 = i16 ^ i6;
                    iArr2[i20][1] = i7;
                    i8 = i17 ^ i7;
                    iArr2[i20][2] = i8;
                    i9 = i19 ^ i8;
                    iArr2[i20][3] = i9;
                }
                int e5 = (e(d(i9, 8)) ^ i10) ^ e2;
                iArr2[12][0] = e5;
                int i21 = e5 ^ i5;
                iArr2[12][1] = i21;
                int i22 = i21 ^ i6;
                iArr2[12][2] = i22;
                iArr2[12][3] = i22 ^ i7;
            } else if (i2 == 8) {
                int littleEndianToInt11 = Pack.littleEndianToInt(key, 0);
                iArr2[0][0] = littleEndianToInt11;
                int littleEndianToInt12 = Pack.littleEndianToInt(key, 4);
                iArr2[0][1] = littleEndianToInt12;
                int littleEndianToInt13 = Pack.littleEndianToInt(key, 8);
                iArr2[0][2] = littleEndianToInt13;
                int littleEndianToInt14 = Pack.littleEndianToInt(key, 12);
                iArr2[0][3] = littleEndianToInt14;
                int littleEndianToInt15 = Pack.littleEndianToInt(key, 16);
                iArr2[1][0] = littleEndianToInt15;
                int littleEndianToInt16 = Pack.littleEndianToInt(key, 20);
                iArr2[1][1] = littleEndianToInt16;
                int littleEndianToInt17 = Pack.littleEndianToInt(key, 24);
                iArr2[1][2] = littleEndianToInt17;
                int littleEndianToInt18 = Pack.littleEndianToInt(key, 28);
                iArr2[1][3] = littleEndianToInt18;
                int i23 = 1;
                for (int i24 = 2; i24 < 14; i24 += 2) {
                    int e6 = e(d(littleEndianToInt18, 8)) ^ i23;
                    i23 <<= 1;
                    littleEndianToInt11 ^= e6;
                    iArr2[i24][0] = littleEndianToInt11;
                    littleEndianToInt12 ^= littleEndianToInt11;
                    iArr2[i24][1] = littleEndianToInt12;
                    littleEndianToInt13 ^= littleEndianToInt12;
                    iArr2[i24][2] = littleEndianToInt13;
                    littleEndianToInt14 ^= littleEndianToInt13;
                    iArr2[i24][3] = littleEndianToInt14;
                    littleEndianToInt15 ^= e(littleEndianToInt14);
                    int i25 = i24 + 1;
                    iArr2[i25][0] = littleEndianToInt15;
                    littleEndianToInt16 ^= littleEndianToInt15;
                    iArr2[i25][1] = littleEndianToInt16;
                    littleEndianToInt17 ^= littleEndianToInt16;
                    iArr2[i25][2] = littleEndianToInt17;
                    littleEndianToInt18 ^= littleEndianToInt17;
                    iArr2[i25][3] = littleEndianToInt18;
                }
                int e7 = (e(d(littleEndianToInt18, 8)) ^ i23) ^ littleEndianToInt11;
                iArr2[14][0] = e7;
                int i26 = e7 ^ littleEndianToInt12;
                iArr2[14][1] = i26;
                int i27 = i26 ^ littleEndianToInt13;
                iArr2[14][2] = i27;
                iArr2[14][3] = i27 ^ littleEndianToInt14;
            } else {
                throw new IllegalStateException("Should never get here");
            }
            if (!z) {
                for (int i28 = 1; i28 < this.a; i28++) {
                    for (int i29 = 0; i29 < 4; i29++) {
                        iArr2[i28][i29] = a(iArr2[i28][i29]);
                    }
                }
            }
            this.b = iArr2;
            this.g = z;
            return;
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to AES init - ")));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        if (this.b == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i2 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + 16 <= bArr2.length) {
            char c2 = 0;
            int i4 = 1;
            if (this.g) {
                f(bArr, i2);
                int[][] iArr = this.b;
                int i5 = this.c ^ iArr[0][0];
                int i6 = this.d ^ iArr[0][1];
                int i7 = this.e ^ iArr[0][2];
                int i8 = this.f ^ iArr[0][3];
                int i9 = 1;
                while (i9 < this.a - i4) {
                    byte[] bArr3 = h;
                    int b2 = b(((((bArr3[(i6 >> 8) & 255] & 255) << 8) ^ (bArr3[i5 & 255] & 255)) ^ ((bArr3[(i7 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i8 >> 24) & 255] << Ascii.CAN)) ^ iArr[i9][c2];
                    int b3 = b(((((bArr3[(i7 >> 8) & 255] & 255) << 8) ^ (bArr3[i6 & 255] & 255)) ^ ((bArr3[(i8 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i5 >> 24) & 255] << Ascii.CAN)) ^ iArr[i9][i4];
                    int b4 = b(((((bArr3[(i8 >> 8) & 255] & 255) << 8) ^ (bArr3[i7 & 255] & 255)) ^ ((bArr3[(i5 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i6 >> 24) & 255] << Ascii.CAN)) ^ iArr[i9][2];
                    int i10 = i9 + 1;
                    int b5 = b(((((bArr3[(i5 >> 8) & 255] & 255) << 8) ^ (bArr3[i8 & 255] & 255)) ^ ((bArr3[(i6 >> 16) & 255] & 255) << 16)) ^ (bArr3[(i7 >> 24) & 255] << Ascii.CAN)) ^ iArr[i9][3];
                    int b6 = b((((bArr3[b2 & 255] & 255) ^ ((bArr3[(b3 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(b4 >> 16) & 255] & 255) << 16)) ^ (bArr3[(b5 >> 24) & 255] << Ascii.CAN)) ^ iArr[i10][0];
                    int b8 = b((((bArr3[b3 & 255] & 255) ^ ((bArr3[(b4 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(b5 >> 16) & 255] & 255) << 16)) ^ (bArr3[(b2 >> 24) & 255] << Ascii.CAN)) ^ iArr[i10][1];
                    int i11 = i10 + 1;
                    int b9 = b((((bArr3[b5 & 255] & 255) ^ ((bArr3[(b2 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(b3 >> 16) & 255] & 255) << 16)) ^ (bArr3[(b4 >> 24) & 255] << Ascii.CAN)) ^ iArr[i10][3];
                    i6 = b8;
                    c2 = 0;
                    i4 = 1;
                    i8 = b9;
                    i5 = b6;
                    i7 = b((((bArr3[b4 & 255] & 255) ^ ((bArr3[(b5 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(b2 >> 16) & 255] & 255) << 16)) ^ (bArr3[(b3 >> 24) & 255] << Ascii.CAN)) ^ iArr[i10][2];
                    i9 = i11;
                }
                byte[] bArr4 = h;
                int b10 = b((((bArr4[i5 & 255] & 255) ^ ((bArr4[(i6 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(i7 >> 16) & 255] & 255) << 16)) ^ (bArr4[(i8 >> 24) & 255] << Ascii.CAN)) ^ iArr[i9][0];
                int b11 = b((((bArr4[i6 & 255] & 255) ^ ((bArr4[(i7 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(i8 >> 16) & 255] & 255) << 16)) ^ (bArr4[(i5 >> 24) & 255] << Ascii.CAN)) ^ iArr[i9][1];
                int b12 = b((((bArr4[i7 & 255] & 255) ^ ((bArr4[(i8 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(i5 >> 16) & 255] & 255) << 16)) ^ (bArr4[(i6 >> 24) & 255] << Ascii.CAN)) ^ iArr[i9][2];
                int i12 = i9 + 1;
                int b13 = b(((((bArr4[(i5 >> 8) & 255] & 255) << 8) ^ (bArr4[i8 & 255] & 255)) ^ ((bArr4[(i6 >> 16) & 255] & 255) << 16)) ^ (bArr4[(i7 >> 24) & 255] << Ascii.CAN)) ^ iArr[i9][3];
                this.c = ((((bArr4[b10 & 255] & 255) ^ ((bArr4[(b11 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(b12 >> 16) & 255] & 255) << 16)) ^ (bArr4[(b13 >> 24) & 255] << Ascii.CAN)) ^ iArr[i12][0];
                this.d = ((((bArr4[b11 & 255] & 255) ^ ((bArr4[(b12 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(b13 >> 16) & 255] & 255) << 16)) ^ (bArr4[(b10 >> 24) & 255] << Ascii.CAN)) ^ iArr[i12][1];
                this.e = iArr[i12][2] ^ ((((bArr4[b12 & 255] & 255) ^ ((bArr4[(b13 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(b10 >> 16) & 255] & 255) << 16)) ^ (bArr4[(b11 >> 24) & 255] << Ascii.CAN));
                this.f = iArr[i12][3] ^ ((((bArr4[b13 & 255] & 255) ^ ((bArr4[(b10 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(b11 >> 16) & 255] & 255) << 16)) ^ (bArr4[(b12 >> 24) & 255] << Ascii.CAN));
                c(bArr2, i3);
            } else {
                f(bArr, i2);
                int[][] iArr2 = this.b;
                int i13 = this.c;
                int i14 = this.a;
                int i15 = i13 ^ iArr2[i14][0];
                int i16 = this.d ^ iArr2[i14][1];
                int i17 = this.e ^ iArr2[i14][2];
                int i18 = i14 - 1;
                int i19 = iArr2[i14][3] ^ this.f;
                while (i18 > 1) {
                    byte[] bArr5 = i;
                    int a3 = a((((bArr5[i15 & 255] & 255) ^ ((bArr5[(i19 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i17 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i16 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i18][0];
                    int a4 = a((((bArr5[i16 & 255] & 255) ^ ((bArr5[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i19 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i17 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i18][1];
                    int a5 = a((((bArr5[i17 & 255] & 255) ^ ((bArr5[(i16 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i15 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i19 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i18][2];
                    int i20 = i18 - 1;
                    int a6 = a((bArr5[(i15 >> 24) & 255] << Ascii.CAN) ^ (((bArr5[i19 & 255] & 255) ^ ((bArr5[(i17 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i16 >> 16) & 255] & 255) << 16))) ^ iArr2[i18][3];
                    int a8 = a((((bArr5[a3 & 255] & 255) ^ ((bArr5[(a6 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(a5 >> 16) & 255] & 255) << 16)) ^ (bArr5[(a4 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i20][0];
                    int a9 = a((((bArr5[a4 & 255] & 255) ^ ((bArr5[(a3 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(a6 >> 16) & 255] & 255) << 16)) ^ (bArr5[(a5 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i20][1];
                    int a10 = a((((bArr5[a6 & 255] & 255) ^ ((bArr5[(a5 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(a4 >> 16) & 255] & 255) << 16)) ^ (bArr5[(a3 >> 24) & 255] << Ascii.CAN));
                    int i21 = i20 - 1;
                    i19 = iArr2[i20][3] ^ a10;
                    i15 = a8;
                    i16 = a9;
                    i17 = a((((bArr5[a5 & 255] & 255) ^ ((bArr5[(a4 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(a3 >> 16) & 255] & 255) << 16)) ^ (bArr5[(a6 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i20][2];
                    i18 = i21;
                }
                byte[] bArr6 = i;
                int a11 = a((((bArr6[i15 & 255] & 255) ^ ((bArr6[(i19 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i17 >> 16) & 255] & 255) << 16)) ^ (bArr6[(i16 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i18][0];
                int a12 = a((((bArr6[i16 & 255] & 255) ^ ((bArr6[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i19 >> 16) & 255] & 255) << 16)) ^ (bArr6[(i17 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i18][1];
                int a13 = a((((bArr6[i17 & 255] & 255) ^ ((bArr6[(i16 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i15 >> 16) & 255] & 255) << 16)) ^ (bArr6[(i19 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i18][2];
                int a14 = a((bArr6[(i15 >> 24) & 255] << Ascii.CAN) ^ (((bArr6[i19 & 255] & 255) ^ ((bArr6[(i17 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i16 >> 16) & 255] & 255) << 16))) ^ iArr2[i18][3];
                this.c = ((((bArr6[a11 & 255] & 255) ^ ((bArr6[(a14 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(a13 >> 16) & 255] & 255) << 16)) ^ (bArr6[(a12 >> 24) & 255] << Ascii.CAN)) ^ iArr2[0][0];
                this.d = ((((bArr6[a12 & 255] & 255) ^ ((bArr6[(a11 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(a14 >> 16) & 255] & 255) << 16)) ^ (bArr6[(a13 >> 24) & 255] << Ascii.CAN)) ^ iArr2[0][1];
                this.e = ((((bArr6[a13 & 255] & 255) ^ ((bArr6[(a12 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(a11 >> 16) & 255] & 255) << 16)) ^ (bArr6[(a14 >> 24) & 255] << Ascii.CAN)) ^ iArr2[0][2];
                this.f = iArr2[0][3] ^ ((((bArr6[a14 & 255] & 255) ^ ((bArr6[(a13 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(a12 >> 16) & 255] & 255) << 16)) ^ (bArr6[(a11 >> 24) & 255] << Ascii.CAN));
                c(bArr2, i3);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
