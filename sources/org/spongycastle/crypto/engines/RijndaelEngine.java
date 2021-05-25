package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Array;
import okio.Utf8;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
public class RijndaelEngine implements BlockCipher {
    public static final byte[] m = {0, 0, Ascii.EM, 1, 50, 2, Ascii.SUB, -58, 75, -57, Ascii.ESC, 104, 51, -18, -33, 3, 100, 4, -32, Ascii.SO, 52, -115, -127, -17, 76, 113, 8, -56, -8, 105, Ascii.FS, -63, 125, -62, Ascii.GS, -75, -7, -71, 39, 106, 77, -28, -90, 114, -102, -55, 9, 120, 101, 47, -118, 5, 33, Ascii.SI, -31, 36, Ascii.DC2, -16, -126, 69, 53, -109, -38, -114, -106, -113, -37, -67, 54, -48, -50, -108, 19, 92, -46, -15, SignedBytes.MAX_POWER_OF_TWO, 70, -125, 56, 102, -35, -3, 48, -65, 6, -117, 98, -77, 37, -30, -104, 34, -120, -111, Ascii.DLE, 126, 110, 72, -61, -93, -74, Ascii.RS, 66, 58, 107, 40, 84, -6, -123, 61, -70, 43, 121, 10, Ascii.NAK, -101, -97, 94, -54, 78, -44, -84, -27, -13, 115, -89, 87, -81, 88, -88, 80, -12, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, 44, -41, 117, 122, -21, Ascii.SYN, Ascii.VT, -11, 89, -53, 95, -80, -100, -87, 81, -96, Byte.MAX_VALUE, Ascii.FF, -10, 111, Ascii.ETB, -60, 73, -20, -40, 67, Ascii.US, 45, -92, 118, 123, -73, -52, -69, 62, 90, -5, 96, -79, -122, 59, 82, -95, 108, -86, 85, 41, -99, -105, -78, -121, -112, 97, -66, -36, -4, PSSSigner.TRAILER_IMPLICIT, -107, -49, -51, 55, Utf8.REPLACEMENT_BYTE, 91, -47, 83, 57, -124, 60, 65, -94, 109, 71, Ascii.DC4, 42, -98, 93, 86, -14, -45, -85, 68, 17, -110, -39, 35, 32, 46, -119, -76, 124, -72, 38, 119, -103, -29, -91, 103, 74, -19, -34, -59, 49, -2, Ascii.CAN, Ascii.CR, 99, -116, Byte.MIN_VALUE, -64, -9, 112, 7};
    public static final byte[] n = {0, 3, 5, Ascii.SI, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, Ascii.RS, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, Ascii.FF, Ascii.DC4, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, Ascii.CAN, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, Byte.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, Ascii.DLE, 48, 80, -16, Ascii.VT, Ascii.GS, 39, 105, -69, -42, 97, -93, -2, Ascii.EM, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, Ascii.SYN, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, Ascii.NAK, Utf8.REPLACEMENT_BYTE, 65, -61, 94, -30, 61, 71, -55, SignedBytes.MAX_POWER_OF_TWO, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, Byte.MIN_VALUE, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, Ascii.US, 33, 99, -91, -12, 7, 9, Ascii.ESC, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, Ascii.SO, Ascii.DC2, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, Ascii.CR, Ascii.ETB, 57, 75, -35, 124, -124, -105, -94, -3, Ascii.FS, 36, 108, -76, -57, 82, -10, 1, 3, 5, Ascii.SI, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, Ascii.RS, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, Ascii.FF, Ascii.DC4, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, Ascii.CAN, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, Byte.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, Ascii.DLE, 48, 80, -16, Ascii.VT, Ascii.GS, 39, 105, -69, -42, 97, -93, -2, Ascii.EM, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, Ascii.SYN, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, Ascii.NAK, Utf8.REPLACEMENT_BYTE, 65, -61, 94, -30, 61, 71, -55, SignedBytes.MAX_POWER_OF_TWO, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, Byte.MIN_VALUE, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, Ascii.US, 33, 99, -91, -12, 7, 9, Ascii.ESC, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, Ascii.SO, Ascii.DC2, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, Ascii.CR, Ascii.ETB, 57, 75, -35, 124, -124, -105, -94, -3, Ascii.FS, 36, 108, -76, -57, 82, -10, 1};
    public static final byte[] o = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.NAK, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, Ascii.DC2, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.SUB, Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, Ascii.DLE, -1, -13, -46, -51, Ascii.FF, 19, -20, 95, -105, 68, Ascii.ETB, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, Ascii.DC4, -34, 94, Ascii.VT, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, Ascii.FS, -90, -76, -58, -24, -35, 116, Ascii.US, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, Ascii.SO, 97, 53, 87, -71, -122, -63, Ascii.GS, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, Ascii.RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, Ascii.CR, -65, -26, 66, 104, 65, -103, 45, Ascii.SI, -80, 84, -69, Ascii.SYN};
    public static final byte[] p = {82, 9, 106, -43, 48, 54, -91, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, Ascii.VT, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, Ascii.SYN, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, Ascii.NAK, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, Ascii.RS, -113, -54, Utf8.REPLACEMENT_BYTE, Ascii.SI, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, Ascii.FS, 117, -33, 110, 71, -15, Ascii.SUB, 113, Ascii.GS, 41, -59, -119, 111, -73, 98, Ascii.SO, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, Ascii.US, -35, -88, 51, -120, 7, -57, 49, -79, Ascii.DC2, Ascii.DLE, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, Byte.MAX_VALUE, -87, Ascii.EM, -75, 74, Ascii.CR, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, Ascii.ETB, 43, 4, 126, -70, 119, -42, 38, -31, 105, Ascii.DC4, 99, 85, 33, Ascii.FF, 125};
    public static final int[] q = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
    public static byte[][] r = {new byte[]{0, 8, Ascii.DLE, Ascii.CAN}, new byte[]{0, 8, Ascii.DLE, Ascii.CAN}, new byte[]{0, 8, Ascii.DLE, Ascii.CAN}, new byte[]{0, 8, Ascii.DLE, 32}, new byte[]{0, 8, Ascii.CAN, 32}};
    public static byte[][] s = {new byte[]{0, Ascii.CAN, Ascii.DLE, 8}, new byte[]{0, 32, Ascii.CAN, Ascii.DLE}, new byte[]{0, 40, 32, Ascii.CAN}, new byte[]{0, 48, 40, Ascii.CAN}, new byte[]{0, 56, 40, 32}};
    public int a;
    public long b;
    public int c;
    public int d;
    public long[][] e;
    public long f;
    public long g;
    public long h;
    public long i;
    public boolean j;
    public byte[] k;
    public byte[] l;

    public RijndaelEngine() {
        this(128);
    }

    public final void a(long[] jArr) {
        this.f ^= jArr[0];
        this.g ^= jArr[1];
        this.h ^= jArr[2];
        this.i ^= jArr[3];
    }

    public final void b(byte[] bArr) {
        this.g = l(this.g, bArr[1]);
        this.h = l(this.h, bArr[2]);
        this.i = l(this.i, bArr[3]);
    }

    public final void c(byte[] bArr) {
        this.f = d(this.f, bArr);
        this.g = d(this.g, bArr);
        this.h = d(this.h, bArr);
        this.i = d(this.i, bArr);
    }

    public final long d(long j2, byte[] bArr) {
        long j3 = 0;
        for (int i2 = 0; i2 < this.a; i2 += 8) {
            j3 |= ((long) (bArr[(int) ((j2 >> i2) & 255)] & 255)) << i2;
        }
        return j3;
    }

    public final byte e(int i2) {
        if (i2 != 0) {
            return n[(m[i2] & 255) + 25];
        }
        return 0;
    }

    public final byte f(int i2) {
        if (i2 != 0) {
            return n[(m[i2] & 255) + 1];
        }
        return 0;
    }

    public final byte g(int i2) {
        if (i2 >= 0) {
            return n[i2 + 199];
        }
        return 0;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Rijndael";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.a / 2;
    }

    public final byte h(int i2) {
        if (i2 >= 0) {
            return n[i2 + 104];
        }
        return 0;
    }

    public final byte i(int i2) {
        if (i2 >= 0) {
            return n[i2 + 238];
        }
        return 0;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        int i2;
        int i3;
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            int i4 = 8;
            int length = key.length * 8;
            byte[][] bArr = (byte[][]) Array.newInstance(byte.class, 4, 64);
            long[][] jArr = (long[][]) Array.newInstance(long.class, 15, 4);
            int i5 = 4;
            if (length == 128) {
                i2 = 4;
            } else if (length == 160) {
                i2 = 5;
            } else if (length == 192) {
                i2 = 6;
            } else if (length == 224) {
                i2 = 7;
            } else if (length == 256) {
                i2 = 8;
            } else {
                throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
            }
            if (length >= this.d) {
                this.c = i2 + 6;
            } else {
                this.c = (this.a / 8) + 6;
            }
            char c2 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i6 < key.length) {
                bArr[i6 % 4][i6 / 4] = key[i7];
                i6++;
                i7++;
            }
            int i8 = 0;
            int i9 = 0;
            while (i8 < i2) {
                if (i9 >= (this.a / 8) * (this.c + 1)) {
                    break;
                }
                int i10 = 0;
                while (i10 < i5) {
                    int i11 = this.a;
                    long[] jArr2 = jArr[i9 / (i11 / 8)];
                    jArr2[i10] = jArr2[i10] | (((long) (bArr[i10][i8] & 255)) << ((i9 * 8) % i11));
                    i10++;
                    i5 = 4;
                }
                i8++;
                i9++;
                i5 = 4;
            }
            int i12 = 0;
            while (true) {
                if (i9 < (this.a / i4) * (this.c + 1)) {
                    int i13 = 0;
                    while (i13 < 4) {
                        byte[] bArr2 = bArr[i13];
                        i13++;
                        bArr2[c2] = (byte) (bArr2[c2] ^ o[bArr[i13 % 4][i2 - 1] & 255]);
                    }
                    byte[] bArr3 = bArr[c2];
                    int i14 = i12 + 1;
                    bArr3[c2] = (byte) (q[i12] ^ bArr3[c2]);
                    if (i2 <= 6) {
                        for (int i15 = 1; i15 < i2; i15++) {
                            for (int i16 = 0; i16 < 4; i16++) {
                                byte[] bArr4 = bArr[i16];
                                bArr4[i15] = (byte) (bArr4[i15] ^ bArr[i16][i15 - 1]);
                            }
                        }
                    } else {
                        int i17 = 1;
                        while (true) {
                            i3 = 4;
                            if (i17 >= 4) {
                                break;
                            }
                            int i18 = 0;
                            while (i18 < i3) {
                                byte[] bArr5 = bArr[i18];
                                bArr5[i17] = (byte) (bArr5[i17] ^ bArr[i18][i17 - 1]);
                                i18++;
                                i3 = 4;
                            }
                            i17++;
                        }
                        for (int i19 = 0; i19 < 4; i19++) {
                            byte[] bArr6 = bArr[i19];
                            bArr6[4] = (byte) (bArr6[4] ^ o[bArr[i19][3] & 255]);
                        }
                        int i20 = 5;
                        while (i20 < i2) {
                            int i21 = 0;
                            while (i21 < i3) {
                                byte[] bArr7 = bArr[i21];
                                bArr7[i20] = (byte) (bArr7[i20] ^ bArr[i21][i20 - 1]);
                                i21++;
                                i3 = 4;
                            }
                            i20++;
                            i3 = 4;
                        }
                    }
                    int i22 = 0;
                    while (i22 < i2) {
                        if (i9 >= (this.a / i4) * (this.c + 1)) {
                            break;
                        }
                        for (int i23 = 0; i23 < 4; i23++) {
                            int i24 = this.a;
                            long[] jArr3 = jArr[i9 / (i24 / 8)];
                            jArr3[i23] = jArr3[i23] | (((long) (bArr[i23][i22] & 255)) << ((i9 * 8) % i24));
                        }
                        i22++;
                        i9++;
                        i4 = 8;
                    }
                    c2 = 0;
                    i4 = 8;
                    i12 = i14;
                } else {
                    this.e = jArr;
                    this.j = z;
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to Rijndael init - ")));
        }
    }

    public final byte j(int i2) {
        if (i2 >= 0) {
            return n[i2 + 223];
        }
        return 0;
    }

    public final void k(byte[] bArr, int i2) {
        for (int i3 = 0; i3 != this.a; i3 += 8) {
            int i4 = i2 + 1;
            bArr[i2] = (byte) ((int) (this.f >> i3));
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((int) (this.g >> i3));
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((int) (this.h >> i3));
            i2 = i6 + 1;
            bArr[i6] = (byte) ((int) (this.i >> i3));
        }
    }

    public final long l(long j2, int i2) {
        return ((j2 << (this.a - i2)) | (j2 >>> i2)) & this.b;
    }

    public final void m(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        this.f = (long) (bArr[i2] & 255);
        int i4 = i3 + 1;
        this.g = (long) (bArr[i3] & 255);
        int i5 = i4 + 1;
        this.h = (long) (bArr[i4] & 255);
        int i6 = i5 + 1;
        this.i = (long) (bArr[i5] & 255);
        for (int i7 = 8; i7 != this.a; i7 += 8) {
            int i8 = i6 + 1;
            this.f |= ((long) (bArr[i6] & 255)) << i7;
            int i9 = i8 + 1;
            this.g |= ((long) (bArr[i8] & 255)) << i7;
            int i10 = i9 + 1;
            this.h |= ((long) (bArr[i9] & 255)) << i7;
            i6 = i10 + 1;
            this.i |= ((long) (bArr[i10] & 255)) << i7;
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        if (this.e != null) {
            int i4 = this.a;
            if ((i4 / 2) + i2 > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if ((i4 / 2) + i3 <= bArr2.length) {
                long j2 = 255;
                if (this.j) {
                    m(bArr, i2);
                    long[][] jArr = this.e;
                    a(jArr[0]);
                    int i5 = 1;
                    while (i5 < this.c) {
                        c(o);
                        b(this.k);
                        long j3 = 0;
                        long j4 = 0;
                        int i6 = 0;
                        long j5 = 0;
                        long j6 = 0;
                        while (i6 < this.a) {
                            int i7 = (int) ((this.f >> i6) & j2);
                            int i8 = (int) ((this.g >> i6) & j2);
                            int i9 = (int) ((this.h >> i6) & j2);
                            int i10 = (int) ((this.i >> i6) & j2);
                            j6 |= ((long) ((((e(i7) ^ f(i8)) ^ i9) ^ i10) & 255)) << i6;
                            j4 |= ((long) ((((e(i8) ^ f(i9)) ^ i10) ^ i7) & 255)) << i6;
                            byte e2 = e(i10);
                            i6 += 8;
                            j3 |= ((long) ((((e(i9) ^ f(i10)) ^ i7) ^ i8) & 255)) << i6;
                            jArr = jArr;
                            j2 = 255;
                            j5 = (((long) (((i8 ^ (f(i7) ^ e2)) ^ i9) & 255)) << i6) | j5;
                        }
                        this.f = j6;
                        this.g = j4;
                        this.h = j3;
                        this.i = j5;
                        a(jArr[i5]);
                        i5++;
                        j2 = 255;
                    }
                    c(o);
                    b(this.k);
                    a(jArr[this.c]);
                    k(bArr2, i3);
                } else {
                    m(bArr, i2);
                    long[][] jArr2 = this.e;
                    a(jArr2[this.c]);
                    c(p);
                    b(this.l);
                    int i11 = this.c - 1;
                    while (i11 > 0) {
                        a(jArr2[i11]);
                        int i12 = 0;
                        long j7 = 0;
                        long j8 = 0;
                        long j9 = 0;
                        long j10 = 0;
                        while (i12 < this.a) {
                            int i13 = (int) ((this.f >> i12) & 255);
                            int i14 = (int) ((this.g >> i12) & 255);
                            int i15 = (int) ((this.h >> i12) & 255);
                            int i16 = (int) ((this.i >> i12) & 255);
                            int i17 = i13 != 0 ? m[i13 & 255] & 255 : -1;
                            int i18 = i14 != 0 ? m[i14 & 255] & 255 : -1;
                            int i19 = i15 != 0 ? m[i15 & 255] & 255 : -1;
                            int i20 = i16 != 0 ? m[i16 & 255] & 255 : -1;
                            j9 |= ((long) ((((j(i17) ^ h(i18)) ^ i(i19)) ^ g(i20)) & 255)) << i12;
                            j10 |= ((long) ((((j(i18) ^ h(i19)) ^ i(i20)) ^ g(i17)) & 255)) << i12;
                            j8 |= ((long) ((((j(i19) ^ h(i20)) ^ i(i17)) ^ g(i18)) & 255)) << i12;
                            j7 = (((long) ((((h(i17) ^ j(i20)) ^ i(i18)) ^ g(i19)) & 255)) << i12) | j7;
                            i12 += 8;
                            i11 = i11;
                            jArr2 = jArr2;
                        }
                        this.f = j9;
                        this.g = j10;
                        this.h = j8;
                        this.i = j7;
                        c(p);
                        b(this.l);
                        i11--;
                    }
                    a(jArr2[0]);
                    k(bArr2, i3);
                }
                return this.a / 2;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            throw new IllegalStateException("Rijndael engine not initialised");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }

    public RijndaelEngine(int i2) {
        if (i2 == 128) {
            this.a = 32;
            this.b = BodyPartID.bodyIdMax;
            this.k = r[0];
            this.l = s[0];
        } else if (i2 == 160) {
            this.a = 40;
            this.b = 1099511627775L;
            this.k = r[1];
            this.l = s[1];
        } else if (i2 == 192) {
            this.a = 48;
            this.b = 281474976710655L;
            this.k = r[2];
            this.l = s[2];
        } else if (i2 == 224) {
            this.a = 56;
            this.b = 72057594037927935L;
            this.k = r[3];
            this.l = s[3];
        } else if (i2 == 256) {
            this.a = 64;
            this.b = -1;
            this.k = r[4];
            this.l = s[4];
        } else {
            throw new IllegalArgumentException("unknown blocksize to Rijndael");
        }
        this.d = i2;
    }
}
