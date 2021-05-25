package org.spongycastle.crypto.digests;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import okio.Utf8;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;
public class DSTU7564Digest implements ExtendedDigest, Memoable {
    public static final byte[][] o = {new byte[]{1, 1, 5, 1, 8, 6, 7, 4}, new byte[]{4, 1, 1, 5, 1, 8, 6, 7}, new byte[]{7, 4, 1, 1, 5, 1, 8, 6}, new byte[]{6, 7, 4, 1, 1, 5, 1, 8}, new byte[]{8, 6, 7, 4, 1, 1, 5, 1}, new byte[]{1, 8, 6, 7, 4, 1, 1, 5}, new byte[]{5, 1, 8, 6, 7, 4, 1, 1}, new byte[]{1, 5, 1, 8, 6, 7, 4, 1}};
    public static final byte[][] p = {new byte[]{-88, 67, 95, 6, 107, 117, 108, 89, 113, -33, -121, -107, Ascii.ETB, -16, -40, 9, 109, -13, Ascii.GS, -53, -55, 77, 44, -81, 121, -32, -105, -3, 111, 75, 69, 57, 62, -35, -93, 79, -76, -74, -102, Ascii.SO, Ascii.US, -65, Ascii.NAK, -31, 73, -46, -109, -58, -110, 114, -98, 97, -47, 99, -6, -18, -12, Ascii.EM, -43, -83, 88, -92, -69, -95, -36, -14, -125, 55, 66, -28, 122, 50, -100, -52, -85, 74, -113, 110, 4, 39, 46, -25, -30, 90, -106, Ascii.SYN, 35, 43, -62, 101, 102, Ascii.SI, PSSSigner.TRAILER_IMPLICIT, -87, 71, 65, 52, 72, -4, -73, 106, -120, -91, 83, -122, -7, 91, -37, 56, 123, -61, Ascii.RS, 34, 51, 36, 40, 54, -57, -78, 59, -114, 119, -70, -11, Ascii.DC4, -97, 8, 85, -101, 76, -2, 96, 92, -38, Ascii.CAN, 70, -51, 125, 33, -80, Utf8.REPLACEMENT_BYTE, Ascii.ESC, -119, -1, -21, -124, 105, 58, -99, -41, -45, 112, 103, SignedBytes.MAX_POWER_OF_TWO, -75, -34, 93, 48, -111, -79, 120, 17, 1, -27, 0, 104, -104, -96, -59, 2, -90, 116, 45, Ascii.VT, -94, 118, -77, -66, -50, -67, -82, -23, -118, 49, Ascii.FS, -20, -15, -103, -108, -86, -10, 38, 47, -17, -24, -116, 53, 3, -44, Byte.MAX_VALUE, -5, 5, -63, 94, -112, 32, 61, -126, -9, -22, 10, Ascii.CR, 126, -8, 80, Ascii.SUB, -60, 7, 87, -72, 60, 98, -29, -56, -84, 82, 100, Ascii.DLE, -48, -39, 19, Ascii.FF, Ascii.DC2, 41, 81, -71, -49, -42, 115, -115, -127, 84, -64, -19, 78, 68, -89, 42, -123, 37, -26, -54, 124, -117, 86, Byte.MIN_VALUE}, new byte[]{-50, -69, -21, -110, -22, -53, 19, -63, -23, 58, -42, -78, -46, -112, Ascii.ETB, -8, 66, Ascii.NAK, 86, -76, 101, Ascii.FS, -120, 67, -59, 92, 54, -70, -11, 87, 103, -115, 49, -10, 100, 88, -98, -12, 34, -86, 117, Ascii.SI, 2, -79, -33, 109, 115, 77, 124, 38, 46, -9, 8, 93, 68, 62, -97, Ascii.DC4, -56, -82, 84, Ascii.DLE, -40, PSSSigner.TRAILER_IMPLICIT, Ascii.SUB, 107, 105, -13, -67, 51, -85, -6, -47, -101, 104, 78, Ascii.SYN, -107, -111, -18, 76, 99, -114, 91, -52, 60, Ascii.EM, -95, -127, 73, 123, -39, 111, 55, 96, -54, -25, 43, 72, -3, -106, 69, -4, 65, Ascii.DC2, Ascii.CR, 121, -27, -119, -116, -29, 32, 48, -36, -73, 108, 74, -75, Utf8.REPLACEMENT_BYTE, -105, -44, 98, 45, 6, -92, -91, -125, 95, 42, -38, -55, 0, 126, -94, 85, -65, 17, -43, -100, -49, Ascii.SO, 10, 61, 81, 125, -109, Ascii.ESC, -2, -60, 71, 9, -122, Ascii.VT, -113, -99, 106, 7, -71, -80, -104, Ascii.CAN, 50, 113, 75, -17, 59, 112, -96, -28, SignedBytes.MAX_POWER_OF_TWO, -1, -61, -87, -26, 120, -7, -117, 70, Byte.MIN_VALUE, Ascii.RS, 56, -31, -72, -88, -32, Ascii.FF, 35, 118, Ascii.GS, 37, 36, 5, -15, 110, -108, 40, -102, -124, -24, -93, 79, 119, -45, -123, -30, 82, -14, -126, 80, 122, 47, 116, 83, -77, 97, -81, 57, 53, -34, -51, Ascii.US, -103, -84, -83, 114, 44, -35, -48, -121, -66, 94, -90, -20, 4, -58, 3, 52, -5, -37, 89, -74, -62, 1, -16, 90, -19, -89, 102, 33, Byte.MAX_VALUE, -118, 39, -57, -64, 41, -41}, new byte[]{-109, -39, -102, -75, -104, 34, 69, -4, -70, 106, -33, 2, -97, -36, 81, 89, 74, Ascii.ETB, 43, -62, -108, -12, -69, -93, 98, -28, 113, -44, -51, 112, Ascii.SYN, -31, 73, 60, -64, -40, 92, -101, -83, -123, 83, -95, 122, -56, 45, -32, -47, 114, -90, 44, -60, -29, 118, 120, -73, -76, 9, 59, Ascii.SO, 65, 76, -34, -78, -112, 37, -91, -41, 3, 17, 0, -61, 46, -110, -17, 78, Ascii.DC2, -99, 125, -53, 53, Ascii.DLE, -43, 79, -98, 77, -87, 85, -58, -48, 123, Ascii.CAN, -105, -45, 54, -26, 72, 86, -127, -113, 119, -52, -100, -71, -30, -84, -72, 47, Ascii.NAK, -92, 124, -38, 56, Ascii.RS, Ascii.VT, 5, -42, Ascii.DC4, 110, 108, 126, 102, -3, -79, -27, 96, -81, 94, 51, -121, -55, -16, 93, 109, Utf8.REPLACEMENT_BYTE, -120, -115, -57, -9, Ascii.GS, -23, -20, -19, Byte.MIN_VALUE, 41, 39, -49, -103, -88, 80, Ascii.SI, 55, 36, 40, 48, -107, -46, 62, 91, SignedBytes.MAX_POWER_OF_TWO, -125, -77, 105, 87, Ascii.US, 7, Ascii.FS, -118, PSSSigner.TRAILER_IMPLICIT, 32, -21, -50, -114, -85, -18, 49, -94, 115, -7, -54, 58, Ascii.SUB, -5, Ascii.CR, -63, -2, -6, -14, 111, -67, -106, -35, 67, 82, -74, 8, -13, -82, -66, Ascii.EM, -119, 50, 38, -80, -22, 75, 100, -124, -126, 107, -11, 121, -65, 1, 95, 117, 99, Ascii.ESC, 35, 61, 104, 42, 101, -24, -111, -10, -1, 19, 88, -15, 71, 10, Byte.MAX_VALUE, -59, -89, -25, 97, 90, 6, 70, 68, 66, 4, -96, -37, 57, -122, 84, -86, -116, 52, 33, -117, -8, Ascii.FF, 116, 103}, new byte[]{104, -115, -54, 77, 115, 75, 78, 42, -44, 82, 38, -77, 84, Ascii.RS, Ascii.EM, Ascii.US, 34, 3, 70, 61, 45, 74, 83, -125, 19, -118, -73, -43, 37, 121, -11, -67, 88, 47, Ascii.CR, 2, -19, 81, -98, 17, -14, 62, 85, 94, -47, Ascii.SYN, 60, 102, 112, 93, -13, 69, SignedBytes.MAX_POWER_OF_TWO, -52, -24, -108, 86, 8, -50, Ascii.SUB, 58, -46, -31, -33, -75, 56, 110, Ascii.SO, -27, -12, -7, -122, -23, 79, -42, -123, 35, -49, 50, -103, 49, Ascii.DC4, -82, -18, -56, 72, -45, 48, -95, -110, 65, -79, Ascii.CAN, -60, 44, 113, 114, 68, Ascii.NAK, -3, 55, -66, 95, -86, -101, -120, -40, -85, -119, -100, -6, 96, -22, PSSSigner.TRAILER_IMPLICIT, 98, Ascii.FF, 36, -90, -88, -20, 103, 32, -37, 124, 40, -35, -84, 91, 52, 126, Ascii.DLE, -15, 123, -113, 99, -96, 5, -102, 67, 119, 33, -65, 39, 9, -61, -97, -74, -41, 41, -62, -21, -64, -92, -117, -116, Ascii.GS, -5, -1, -63, -78, -105, 46, -8, 101, -10, 117, 7, 4, 73, 51, -28, -39, -71, -48, 66, -57, 108, -112, 0, -114, 111, 80, 1, -59, -38, 71, Utf8.REPLACEMENT_BYTE, -51, 105, -94, -30, 122, -89, -58, -109, Ascii.SI, 10, 6, -26, 43, -106, -93, Ascii.FS, -81, 106, Ascii.DC2, -124, 57, -25, -80, -126, -9, -2, -99, -121, 92, -127, 53, -34, -76, -91, -4, Byte.MIN_VALUE, -17, -53, -69, 107, 118, -70, 90, 125, 120, Ascii.VT, -107, -29, -83, 116, -104, 59, 54, 100, 109, -36, -16, 89, -87, 76, Ascii.ETB, Byte.MAX_VALUE, -111, -72, -55, 87, Ascii.ESC, -32, 97}};
    public int a;
    public int b;
    public int c;
    public int d;
    public byte[] e;
    public byte[][] f;
    public byte[][] g;
    public byte[][] h;
    public byte[] i;
    public byte[] j;
    public long[] k;
    public long l;
    public int m;
    public byte[] n;

    public DSTU7564Digest(DSTU7564Digest dSTU7564Digest) {
        a(dSTU7564Digest);
    }

    public final void a(DSTU7564Digest dSTU7564Digest) {
        this.a = dSTU7564Digest.a;
        this.b = dSTU7564Digest.b;
        this.c = dSTU7564Digest.c;
        this.d = dSTU7564Digest.d;
        this.e = Arrays.clone(dSTU7564Digest.e);
        this.f = Arrays.clone(dSTU7564Digest.f);
        this.g = Arrays.clone(dSTU7564Digest.g);
        this.h = Arrays.clone(dSTU7564Digest.h);
        this.i = Arrays.clone(dSTU7564Digest.i);
        this.j = Arrays.clone(dSTU7564Digest.j);
        this.k = Arrays.clone(dSTU7564Digest.k);
        this.l = dSTU7564Digest.l;
        this.m = dSTU7564Digest.m;
        this.n = Arrays.clone(dSTU7564Digest.n);
    }

    public final byte b(byte b2, byte b3) {
        byte b4 = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            if ((b3 & 1) == 1) {
                b4 = (byte) (b4 ^ b2);
            }
            byte b5 = (byte) (b2 & Byte.MIN_VALUE);
            b2 = (byte) (b2 << 1);
            if (b5 == Byte.MIN_VALUE) {
                b2 = (byte) (b2 ^ Ascii.GS);
            }
            b3 = (byte) (b3 >> 1);
        }
        return b4;
    }

    public final void c(byte[] bArr, int i2) {
        for (int i3 = 0; i3 < this.f.length; i3++) {
            Arrays.fill(this.g[i3], (byte) 0);
            Arrays.fill(this.h[i3], (byte) 0);
        }
        for (int i4 = 0; i4 < 8; i4++) {
            for (int i5 = 0; i5 < this.c; i5++) {
                byte[] bArr2 = this.g[i5];
                byte b2 = this.f[i5][i4];
                int c2 = a.c2(i5, 8, i4, i2);
                bArr2[i4] = (byte) (b2 ^ bArr[c2]);
                this.h[i5][i4] = bArr[c2];
            }
        }
        int i6 = 0;
        while (true) {
            int i7 = -1;
            if (i6 >= this.d) {
                break;
            }
            for (int i8 = 0; i8 < this.c; i8++) {
                byte[] bArr3 = this.g[i8];
                bArr3[0] = (byte) (bArr3[0] ^ ((byte) ((i8 * 16) ^ i6)));
            }
            for (int i9 = 0; i9 < 8; i9++) {
                for (int i10 = 0; i10 < this.c; i10++) {
                    byte[][] bArr4 = this.g;
                    bArr4[i10][i9] = p[i9 % 4][bArr4[i10][i9] & 255];
                }
            }
            int i11 = 0;
            while (i11 < 8) {
                i7 = (i11 == 7 && this.c == 16) ? 11 : i7 + 1;
                int i12 = 0;
                while (true) {
                    int i13 = this.c;
                    if (i12 >= i13) {
                        break;
                    }
                    this.i[(i12 + i7) % i13] = this.g[i12][i11];
                    i12++;
                }
                for (int i14 = 0; i14 < this.c; i14++) {
                    this.g[i14][i11] = this.i[i14];
                }
                i11++;
            }
            for (int i15 = 0; i15 < this.c; i15++) {
                Arrays.fill(this.j, (byte) 0);
                for (int i16 = 7; i16 >= 0; i16--) {
                    byte b3 = 0;
                    for (int i17 = 7; i17 >= 0; i17--) {
                        b3 = (byte) (b3 ^ b(this.g[i15][i17], o[i16][i17]));
                    }
                    this.j[i16] = b3;
                }
                for (int i18 = 0; i18 < 8; i18++) {
                    this.g[i15][i18] = this.j[i18];
                }
            }
            i6++;
        }
        for (int i19 = 0; i19 < this.d; i19++) {
            for (int i20 = 0; i20 < this.c; i20++) {
                this.k[i20] = Pack.littleEndianToLong(this.h[i20], 0);
                long[] jArr = this.k;
                jArr[i20] = jArr[i20] + (67818912035696883L ^ (((((long) ((this.c - i20) - 1)) * 16) ^ ((long) i19)) << 56));
                Pack.longToLittleEndian(jArr[i20], this.h[i20], 0);
            }
            for (int i21 = 0; i21 < 8; i21++) {
                for (int i22 = 0; i22 < this.c; i22++) {
                    byte[][] bArr5 = this.h;
                    bArr5[i22][i21] = p[i21 % 4][bArr5[i22][i21] & 255];
                }
            }
            int i23 = 0;
            int i24 = -1;
            while (i23 < 8) {
                i24 = (i23 == 7 && this.c == 16) ? 11 : i24 + 1;
                int i25 = 0;
                while (true) {
                    int i26 = this.c;
                    if (i25 >= i26) {
                        break;
                    }
                    this.i[(i25 + i24) % i26] = this.h[i25][i23];
                    i25++;
                }
                for (int i27 = 0; i27 < this.c; i27++) {
                    this.h[i27][i23] = this.i[i27];
                }
                i23++;
            }
            for (int i28 = 0; i28 < this.c; i28++) {
                Arrays.fill(this.j, (byte) 0);
                for (int i29 = 7; i29 >= 0; i29--) {
                    byte b4 = 0;
                    for (int i30 = 7; i30 >= 0; i30--) {
                        b4 = (byte) (b4 ^ b(this.h[i28][i30], o[i29][i30]));
                    }
                    this.j[i29] = b4;
                }
                for (int i31 = 0; i31 < 8; i31++) {
                    this.h[i28][i31] = this.j[i31];
                }
            }
        }
        for (int i32 = 0; i32 < 8; i32++) {
            for (int i33 = 0; i33 < this.c; i33++) {
                byte[] bArr6 = this.f[i33];
                bArr6[i32] = (byte) (bArr6[i32] ^ ((byte) (this.g[i33][i32] ^ this.h[i33][i32])));
            }
        }
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new DSTU7564Digest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        byte[] bArr2;
        byte[] bArr3 = this.n;
        int i3 = this.m;
        int i4 = this.b;
        if (i4 - i3 < 13) {
            bArr2 = new byte[(i4 * 2)];
        } else {
            bArr2 = new byte[i4];
        }
        System.arraycopy(bArr3, 0, bArr2, 0, i3);
        bArr2[i3] = Byte.MIN_VALUE;
        Pack.longToLittleEndian(this.l * 8, bArr2, bArr2.length - 12);
        this.e = bArr2;
        int length = bArr2.length;
        int i5 = 0;
        while (length != 0) {
            c(this.e, i5);
            int i6 = this.b;
            i5 += i6;
            length -= i6;
        }
        byte[][] bArr4 = new byte[128][];
        int i7 = 0;
        while (true) {
            byte[][] bArr5 = this.f;
            if (i7 >= bArr5.length) {
                break;
            }
            bArr4[i7] = new byte[8];
            System.arraycopy(bArr5[i7], 0, bArr4[i7], 0, 8);
            i7++;
        }
        for (int i8 = 0; i8 < this.d; i8++) {
            for (int i9 = 0; i9 < this.c; i9++) {
                byte[] bArr6 = bArr4[i9];
                bArr6[0] = (byte) (bArr6[0] ^ ((byte) ((i9 * 16) ^ i8)));
            }
            for (int i10 = 0; i10 < 8; i10++) {
                for (int i11 = 0; i11 < this.c; i11++) {
                    bArr4[i11][i10] = p[i10 % 4][bArr4[i11][i10] & 255];
                }
            }
            int i12 = -1;
            int i13 = 0;
            while (i13 < 8) {
                i12 = (i13 == 7 && this.c == 16) ? 11 : i12 + 1;
                int i14 = 0;
                while (true) {
                    int i15 = this.c;
                    if (i14 >= i15) {
                        break;
                    }
                    this.i[(i14 + i12) % i15] = bArr4[i14][i13];
                    i14++;
                }
                for (int i16 = 0; i16 < this.c; i16++) {
                    bArr4[i16][i13] = this.i[i16];
                }
                i13++;
            }
            for (int i17 = 0; i17 < this.c; i17++) {
                Arrays.fill(this.j, (byte) 0);
                for (int i18 = 7; i18 >= 0; i18--) {
                    byte b2 = 0;
                    for (int i19 = 7; i19 >= 0; i19--) {
                        b2 = (byte) (b2 ^ b(bArr4[i17][i19], o[i18][i19]));
                    }
                    this.j[i18] = b2;
                }
                for (int i20 = 0; i20 < 8; i20++) {
                    bArr4[i17][i20] = this.j[i20];
                }
            }
        }
        for (int i21 = 0; i21 < 8; i21++) {
            for (int i22 = 0; i22 < this.c; i22++) {
                byte[] bArr7 = this.f[i22];
                bArr7[i21] = (byte) (bArr7[i21] ^ bArr4[i22][i21]);
            }
        }
        int i23 = this.c * 8;
        byte[] bArr8 = new byte[i23];
        int i24 = 0;
        for (int i25 = 0; i25 < this.c; i25++) {
            for (int i26 = 0; i26 < 8; i26++) {
                bArr8[i24] = this.f[i25][i26];
                i24++;
            }
        }
        int i27 = this.a;
        System.arraycopy(bArr8, i23 - i27, bArr, i2, i27);
        reset();
        return this.a;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "DSTU7564";
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.b;
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        byte[][] bArr;
        int i2 = 0;
        while (true) {
            bArr = this.f;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = new byte[this.c];
            i2++;
        }
        bArr[0][0] = (byte) bArr.length;
        this.l = 0;
        this.m = 0;
        Arrays.fill(this.n, (byte) 0);
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            Arrays.fill(bArr2, (byte) 0);
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b2) {
        byte[] bArr = this.n;
        int i2 = this.m;
        int i3 = i2 + 1;
        this.m = i3;
        bArr[i2] = b2;
        if (i3 == this.b) {
            c(bArr, 0);
            this.m = 0;
        }
        this.l++;
    }

    public DSTU7564Digest(int i2) {
        byte[][] bArr;
        if (i2 == 256 || i2 == 384 || i2 == 512) {
            this.a = i2 / 8;
            if (i2 > 256) {
                this.b = 128;
                this.c = 16;
                this.d = 14;
                this.f = new byte[128][];
            } else {
                this.b = 64;
                this.c = 8;
                this.d = 10;
                this.f = new byte[64][];
            }
            int i3 = 0;
            while (true) {
                bArr = this.f;
                if (i3 >= bArr.length) {
                    break;
                }
                bArr[i3] = new byte[this.c];
                i3++;
            }
            bArr[0][0] = (byte) bArr.length;
            this.e = null;
            this.g = new byte[128][];
            this.h = new byte[128][];
            for (int i4 = 0; i4 < this.f.length; i4++) {
                this.g[i4] = new byte[8];
                this.h[i4] = new byte[8];
            }
            this.i = new byte[16];
            this.j = new byte[8];
            this.k = new long[this.c];
            this.n = new byte[this.b];
            return;
        }
        throw new IllegalArgumentException("Hash size is not recommended. Use 256/384/512 instead");
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i2, int i3) {
        while (this.m != 0 && i3 > 0) {
            update(bArr[i2]);
            i3--;
            i2++;
        }
        if (i3 > 0) {
            while (i3 > this.b) {
                c(bArr, i2);
                int i4 = this.b;
                i2 += i4;
                this.l += (long) i4;
                i3 -= i4;
            }
            while (i3 > 0) {
                update(bArr[i2]);
                i3--;
                i2++;
            }
        }
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        a((DSTU7564Digest) memoable);
    }
}
