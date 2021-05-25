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
import org.spongycastle.util.Pack;
public class SM4Engine implements BlockCipher {
    public static final byte[] c = {-42, -112, -23, -2, -52, -31, 61, -73, Ascii.SYN, -74, Ascii.DC4, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, Ascii.VT, 67, -19, -49, -84, 98, -28, -77, Ascii.FS, -87, -55, 8, -24, -107, Byte.MIN_VALUE, -33, -108, -6, 117, -113, Utf8.REPLACEMENT_BYTE, -90, 71, 7, -89, -4, -13, 115, Ascii.ETB, -70, -125, 89, 60, Ascii.EM, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, Ascii.SI, 75, 112, 86, -99, 53, Ascii.RS, 36, Ascii.SO, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, SignedBytes.MAX_POWER_OF_TWO, -57, 56, -75, -93, -9, -14, -50, -7, 97, Ascii.NAK, -95, -32, -82, 93, -92, -101, 52, Ascii.SUB, 85, -83, -109, 50, 48, -11, -116, -79, -29, Ascii.GS, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, Ascii.CR, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, Ascii.ESC, -81, -110, -69, -35, PSSSigner.TRAILER_IMPLICIT, Byte.MAX_VALUE, 17, -39, 92, 65, Ascii.US, Ascii.DLE, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, Ascii.DC2, -72, -27, -76, -80, -119, 105, -105, 74, Ascii.FF, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, Ascii.CAN, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};
    public static final int[] d = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};
    public static final int[] e = {-1548633402, 1453994832, 1736282519, -1301273892};
    public final int[] a = new int[4];
    public int[] b;

    public final int a(int i) {
        int d2 = d(i);
        return c(d2, 24) ^ (((c(d2, 2) ^ d2) ^ c(d2, 10)) ^ c(d2, 18));
    }

    public final int b(int i) {
        int d2 = d(i);
        return c(d2, 23) ^ (c(d2, 13) ^ d2);
    }

    public final int c(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public final int d(int i) {
        byte[] bArr = c;
        return (bArr[i & 255] & 255) | ((bArr[(i >> 24) & 255] & 255) << 24) | ((bArr[(i >> 16) & 255] & 255) << 16) | ((bArr[(i >> 8) & 255] & 255) << 8);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "SM4";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                int[] iArr = new int[32];
                int[] iArr2 = {Pack.bigEndianToInt(key, 0), Pack.bigEndianToInt(key, 4), Pack.bigEndianToInt(key, 8), Pack.bigEndianToInt(key, 12)};
                int i = iArr2[0];
                int[] iArr3 = e;
                int[] iArr4 = {i ^ iArr3[0], iArr2[1] ^ iArr3[1], iArr2[2] ^ iArr3[2], iArr2[3] ^ iArr3[3]};
                if (z) {
                    int i2 = iArr4[0];
                    int i3 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
                    int[] iArr5 = d;
                    iArr[0] = i2 ^ b(i3 ^ iArr5[0]);
                    iArr[1] = iArr4[1] ^ b(((iArr4[2] ^ iArr4[3]) ^ iArr[0]) ^ iArr5[1]);
                    iArr[2] = iArr4[2] ^ b(((iArr4[3] ^ iArr[0]) ^ iArr[1]) ^ iArr5[2]);
                    iArr[3] = iArr4[3] ^ b(((iArr[0] ^ iArr[1]) ^ iArr[2]) ^ iArr5[3]);
                    for (int i4 = 4; i4 < 32; i4++) {
                        iArr[i4] = iArr[i4 - 4] ^ b(((iArr[i4 - 3] ^ iArr[i4 - 2]) ^ iArr[i4 - 1]) ^ d[i4]);
                    }
                } else {
                    int i5 = iArr4[0];
                    int i6 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
                    int[] iArr6 = d;
                    iArr[31] = i5 ^ b(i6 ^ iArr6[0]);
                    iArr[30] = iArr4[1] ^ b(((iArr4[2] ^ iArr4[3]) ^ iArr[31]) ^ iArr6[1]);
                    iArr[29] = iArr4[2] ^ b(((iArr4[3] ^ iArr[31]) ^ iArr[30]) ^ iArr6[2]);
                    iArr[28] = iArr4[3] ^ b(((iArr[31] ^ iArr[30]) ^ iArr[29]) ^ iArr6[3]);
                    for (int i7 = 27; i7 >= 0; i7--) {
                        iArr[i7] = iArr[i7 + 4] ^ b(((iArr[i7 + 3] ^ iArr[i7 + 2]) ^ iArr[i7 + 1]) ^ d[31 - i7]);
                    }
                }
                this.b = iArr;
                return;
            }
            throw new IllegalArgumentException("SM4 requires a 128 bit key");
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to SM4 init - ")));
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        if (this.b == null) {
            throw new IllegalStateException("SM4 not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            this.a[0] = Pack.bigEndianToInt(bArr, i);
            this.a[1] = Pack.bigEndianToInt(bArr, i + 4);
            this.a[2] = Pack.bigEndianToInt(bArr, i + 8);
            this.a[3] = Pack.bigEndianToInt(bArr, i + 12);
            for (int i3 = 0; i3 < 32; i3 += 4) {
                int[] iArr = this.a;
                int i4 = this.b[i3];
                iArr[0] = a(i4 ^ ((iArr[1] ^ iArr[2]) ^ iArr[3])) ^ iArr[0];
                int[] iArr2 = this.a;
                int i5 = this.b[i3 + 1];
                iArr2[1] = a(i5 ^ ((iArr2[2] ^ iArr2[3]) ^ iArr2[0])) ^ iArr2[1];
                int[] iArr3 = this.a;
                int i6 = this.b[i3 + 2];
                iArr3[2] = a(i6 ^ ((iArr3[3] ^ iArr3[0]) ^ iArr3[1])) ^ iArr3[2];
                int[] iArr4 = this.a;
                int i7 = this.b[i3 + 3];
                iArr4[3] = a(i7 ^ ((iArr4[0] ^ iArr4[1]) ^ iArr4[2])) ^ iArr4[3];
            }
            int[] iArr5 = this.a;
            iArr5[0] = iArr5[0] ^ iArr5[3];
            iArr5[3] = iArr5[0] ^ iArr5[3];
            iArr5[0] = iArr5[0] ^ iArr5[3];
            iArr5[1] = iArr5[1] ^ iArr5[2];
            iArr5[2] = iArr5[1] ^ iArr5[2];
            iArr5[1] = iArr5[1] ^ iArr5[2];
            Pack.intToBigEndian(iArr5[0], bArr2, i2);
            Pack.intToBigEndian(this.a[1], bArr2, i2 + 4);
            Pack.intToBigEndian(this.a[2], bArr2, i2 + 8);
            Pack.intToBigEndian(this.a[3], bArr2, i2 + 12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }
}
