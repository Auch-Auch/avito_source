package org.spongycastle.pqc.crypto.gmss;

import a2.b.a.a.a;
import java.lang.reflect.Array;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.util.encoders.Hex;
public class GMSSRootSig {
    public Digest a;
    public int b;
    public int c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public int g;
    public GMSSRandom h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public long o;
    public long p;
    public int q;
    public int r;
    public int s;
    public byte[] t;

    public GMSSRootSig(Digest digest, byte[][] bArr, int[] iArr) {
        this.a = digest;
        this.h = new GMSSRandom(digest);
        this.m = iArr[0];
        this.l = iArr[1];
        this.n = iArr[2];
        this.k = iArr[3];
        this.q = iArr[4];
        this.c = iArr[5];
        this.s = iArr[6];
        this.g = iArr[7];
        this.r = iArr[8];
        int digestSize = this.a.getDigestSize();
        this.b = digestSize;
        int i2 = this.g;
        this.j = (1 << i2) - 1;
        this.i = (int) Math.ceil(((double) (digestSize << 3)) / ((double) i2));
        this.d = bArr[0];
        this.t = bArr[1];
        this.e = bArr[2];
        this.f = bArr[3];
        this.o = (((long) (bArr[4][1] & 255)) << 8) | ((long) (bArr[4][0] & 255)) | (((long) (bArr[4][2] & 255)) << 16) | (((long) (bArr[4][3] & 255)) << 24) | (((long) (bArr[4][4] & 255)) << 32) | (((long) (bArr[4][5] & 255)) << 40) | (((long) (bArr[4][6] & 255)) << 48) | (((long) (bArr[4][7] & 255)) << 56);
        this.p = ((long) (bArr[4][8] & 255)) | (((long) (bArr[4][9] & 255)) << 8) | (((long) (bArr[4][10] & 255)) << 16) | (((long) (bArr[4][11] & 255)) << 24) | (((long) (bArr[4][12] & 255)) << 32) | (((long) (bArr[4][13] & 255)) << 40) | (((long) (bArr[4][14] & 255)) << 48) | (((long) (bArr[4][15] & 255)) << 56);
    }

    public int getLog(int i2) {
        int i3 = 1;
        int i4 = 2;
        while (i4 < i2) {
            i4 <<= 1;
            i3++;
        }
        return i3;
    }

    public byte[] getSig() {
        return this.f;
    }

    public byte[][] getStatByte() {
        int[] iArr = new int[2];
        iArr[1] = this.b;
        iArr[0] = 5;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        bArr[0] = this.d;
        bArr[1] = this.t;
        bArr[2] = this.e;
        bArr[3] = this.f;
        bArr[4] = getStatLong();
        return bArr;
    }

    public int[] getStatInt() {
        return new int[]{this.m, this.l, this.n, this.k, this.q, this.c, this.s, this.g, this.r};
    }

    public byte[] getStatLong() {
        long j2 = this.o;
        long j3 = this.p;
        return new byte[]{(byte) ((int) (j2 & 255)), (byte) ((int) ((j2 >> 8) & 255)), (byte) ((int) ((j2 >> 16) & 255)), (byte) ((int) ((j2 >> 24) & 255)), (byte) ((int) ((j2 >> 32) & 255)), (byte) ((int) ((j2 >> 40) & 255)), (byte) ((int) ((j2 >> 48) & 255)), (byte) ((int) ((j2 >> 56) & 255)), (byte) ((int) (j3 & 255)), (byte) ((int) ((j3 >> 8) & 255)), (byte) ((int) ((j3 >> 16) & 255)), (byte) ((int) ((j3 >> 24) & 255)), (byte) ((int) ((j3 >> 32) & 255)), (byte) ((int) ((j3 >> 40) & 255)), (byte) ((int) ((j3 >> 48) & 255)), (byte) ((int) ((j3 >> 56) & 255))};
    }

    public void initSign(byte[] bArr, byte[] bArr2) {
        int i2;
        int i3;
        this.e = new byte[this.b];
        this.a.update(bArr2, 0, bArr2.length);
        byte[] bArr3 = new byte[this.a.getDigestSize()];
        this.e = bArr3;
        this.a.doFinal(bArr3, 0);
        int i4 = this.b;
        byte[] bArr4 = new byte[i4];
        System.arraycopy(this.e, 0, bArr4, 0, i4);
        int log = getLog((this.i << this.g) + 1);
        int i5 = this.g;
        int i6 = 8;
        if (8 % i5 == 0) {
            int i7 = 8 / i5;
            i2 = 0;
            for (int i8 = 0; i8 < this.b; i8++) {
                for (int i9 = 0; i9 < i7; i9++) {
                    i2 += bArr4[i8] & this.j;
                    bArr4[i8] = (byte) (bArr4[i8] >>> this.g);
                }
            }
            int i10 = (this.i << this.g) - i2;
            this.r = i10;
            int i11 = 0;
            while (i11 < log) {
                i2 += this.j & i10;
                int i12 = this.g;
                i10 >>>= i12;
                i11 += i12;
            }
        } else if (i5 < 8) {
            int i13 = this.b / i5;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i14 < i13) {
                long j2 = 0;
                for (int i17 = 0; i17 < this.g; i17++) {
                    j2 ^= (long) ((bArr4[i15] & 255) << (i17 << 3));
                    i15++;
                }
                int i18 = 0;
                while (i18 < i6) {
                    i16 += (int) (((long) this.j) & j2);
                    j2 >>>= this.g;
                    i18++;
                    i13 = i13;
                    i6 = 8;
                }
                i14++;
                i6 = 8;
            }
            int i19 = this.b % this.g;
            long j3 = 0;
            for (int i20 = 0; i20 < i19; i20++) {
                j3 ^= (long) ((bArr4[i15] & 255) << (i20 << 3));
                i15++;
            }
            int i21 = i19 << 3;
            int i22 = 0;
            while (i22 < i21) {
                i16 += (int) (((long) this.j) & j3);
                int i23 = this.g;
                j3 >>>= i23;
                i22 += i23;
            }
            int i24 = (this.i << this.g) - i16;
            this.r = i24;
            i2 = i16;
            int i25 = 0;
            while (i25 < log) {
                i2 += this.j & i24;
                int i26 = this.g;
                i24 >>>= i26;
                i25 += i26;
            }
        } else if (i5 < 57) {
            int i27 = 0;
            int i28 = 0;
            while (true) {
                i3 = this.b;
                int i29 = this.g;
                if (i27 > (i3 << 3) - i29) {
                    break;
                }
                int i30 = i27 % 8;
                i27 += i29;
                int i31 = (i27 + 7) >>> 3;
                long j4 = 0;
                int i32 = 0;
                for (int i33 = i27 >>> 3; i33 < i31; i33++) {
                    j4 ^= (long) ((bArr4[i33] & 255) << (i32 << 3));
                    i32++;
                }
                i28 = (int) (((long) i28) + ((j4 >>> i30) & ((long) this.j)));
            }
            int i34 = i27 >>> 3;
            if (i34 < i3) {
                int i35 = i27 % 8;
                int i36 = 0;
                long j5 = 0;
                while (i34 < this.b) {
                    j5 ^= (long) ((bArr4[i34] & 255) << (i36 << 3));
                    i36++;
                    i34++;
                }
                i28 = (int) (((long) i28) + ((j5 >>> i35) & ((long) this.j)));
            }
            int i37 = (this.i << this.g) - i28;
            this.r = i37;
            i2 = i28;
            int i38 = 0;
            while (i38 < log) {
                i2 += this.j & i37;
                int i39 = this.g;
                i37 >>>= i39;
                i38 += i39;
            }
        } else {
            i2 = 0;
        }
        int ceil = this.i + ((int) Math.ceil(((double) log) / ((double) this.g)));
        this.c = ceil;
        this.q = (int) Math.ceil(((double) (ceil + i2)) / ((double) (1 << this.s)));
        int i40 = this.c;
        int i41 = this.b;
        this.f = new byte[(i40 * i41)];
        this.m = 0;
        this.l = 0;
        this.n = 0;
        this.o = 0;
        this.k = 0;
        this.d = new byte[i41];
        byte[] bArr5 = new byte[i41];
        this.t = bArr5;
        System.arraycopy(bArr, 0, bArr5, 0, i41);
    }

    public String toString() {
        String l2 = a.l(a.L(""), this.p, "  ");
        int[] statInt = getStatInt();
        int[] iArr = new int[2];
        iArr[1] = this.b;
        iArr[0] = 5;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        byte[][] statByte = getStatByte();
        for (int i2 = 0; i2 < 9; i2++) {
            l2 = a.j(a.L(l2), statInt[i2], " ");
        }
        for (int i3 = 0; i3 < 5; i3++) {
            l2 = a.t(a.L(l2), new String(Hex.encode(statByte[i3])), " ");
        }
        return l2;
    }

    public boolean updateSign() {
        int i2;
        for (int i3 = 0; i3 < this.q; i3++) {
            int i4 = this.m;
            if (i4 < this.c) {
                int i5 = this.g;
                if (8 % i5 == 0) {
                    int i6 = this.l;
                    if (i6 == 0) {
                        this.d = this.h.nextSeed(this.t);
                        int i7 = this.n;
                        if (i7 < this.b) {
                            byte[] bArr = this.e;
                            this.l = bArr[i7] & this.j;
                            bArr[i7] = (byte) (bArr[i7] >>> this.g);
                        } else {
                            int i8 = this.r;
                            this.l = this.j & i8;
                            this.r = i8 >>> this.g;
                        }
                    } else if (i6 > 0) {
                        Digest digest = this.a;
                        byte[] bArr2 = this.d;
                        digest.update(bArr2, 0, bArr2.length);
                        byte[] bArr3 = new byte[this.a.getDigestSize()];
                        this.d = bArr3;
                        this.a.doFinal(bArr3, 0);
                        this.l--;
                    }
                    if (this.l == 0) {
                        byte[] bArr4 = this.d;
                        byte[] bArr5 = this.f;
                        int i9 = this.m;
                        int i10 = this.b;
                        System.arraycopy(bArr4, 0, bArr5, i9 * i10, i10);
                        int i11 = this.m + 1;
                        this.m = i11;
                        if (i11 % (8 / this.g) == 0) {
                            this.n++;
                        }
                    }
                } else if (i5 < 8) {
                    int i12 = this.l;
                    if (i12 == 0) {
                        if (i4 % 8 == 0 && this.n < (i2 = this.b)) {
                            this.p = 0;
                            if (i4 < ((i2 / i5) << 3)) {
                                for (int i13 = 0; i13 < this.g; i13++) {
                                    long j2 = this.p;
                                    byte[] bArr6 = this.e;
                                    int i14 = this.n;
                                    this.p = j2 ^ ((long) ((bArr6[i14] & 255) << (i13 << 3)));
                                    this.n = i14 + 1;
                                }
                            } else {
                                for (int i15 = 0; i15 < this.b % this.g; i15++) {
                                    long j3 = this.p;
                                    byte[] bArr7 = this.e;
                                    int i16 = this.n;
                                    this.p = j3 ^ ((long) ((bArr7[i16] & 255) << (i15 << 3)));
                                    this.n = i16 + 1;
                                }
                            }
                        }
                        if (this.m == this.i) {
                            this.p = (long) this.r;
                        }
                        this.l = (int) (this.p & ((long) this.j));
                        this.d = this.h.nextSeed(this.t);
                    } else if (i12 > 0) {
                        Digest digest2 = this.a;
                        byte[] bArr8 = this.d;
                        digest2.update(bArr8, 0, bArr8.length);
                        byte[] bArr9 = new byte[this.a.getDigestSize()];
                        this.d = bArr9;
                        this.a.doFinal(bArr9, 0);
                        this.l--;
                    }
                    if (this.l == 0) {
                        byte[] bArr10 = this.d;
                        byte[] bArr11 = this.f;
                        int i17 = this.m;
                        int i18 = this.b;
                        System.arraycopy(bArr10, 0, bArr11, i17 * i18, i18);
                        this.p >>>= this.g;
                        this.m++;
                    }
                } else if (i5 < 57) {
                    int i19 = (this.o > 0 ? 1 : (this.o == 0 ? 0 : -1));
                    if (i19 == 0) {
                        this.p = 0;
                        this.n = 0;
                        int i20 = this.k;
                        int i21 = i20 % 8;
                        int i22 = i20 >>> 3;
                        int i23 = this.b;
                        if (i22 < i23) {
                            if (i20 <= (i23 << 3) - i5) {
                                int i24 = i20 + i5;
                                this.k = i24;
                                i23 = (i24 + 7) >>> 3;
                            } else {
                                this.k = i20 + i5;
                            }
                            while (i22 < i23) {
                                long j4 = this.p;
                                int i25 = this.n;
                                this.p = j4 ^ ((long) ((this.e[i22] & 255) << (i25 << 3)));
                                this.n = i25 + 1;
                                i22++;
                            }
                            long j5 = this.p >>> i21;
                            this.p = j5;
                            this.o = j5 & ((long) this.j);
                        } else {
                            int i26 = this.r;
                            this.o = (long) (this.j & i26);
                            this.r = i26 >>> i5;
                        }
                        this.d = this.h.nextSeed(this.t);
                    } else if (i19 > 0) {
                        Digest digest3 = this.a;
                        byte[] bArr12 = this.d;
                        digest3.update(bArr12, 0, bArr12.length);
                        byte[] bArr13 = new byte[this.a.getDigestSize()];
                        this.d = bArr13;
                        this.a.doFinal(bArr13, 0);
                        this.o--;
                    }
                    if (this.o == 0) {
                        byte[] bArr14 = this.d;
                        byte[] bArr15 = this.f;
                        int i27 = this.m;
                        int i28 = this.b;
                        System.arraycopy(bArr14, 0, bArr15, i27 * i28, i28);
                        this.m++;
                    }
                }
            }
            if (this.m == this.c) {
                return true;
            }
        }
        return false;
    }

    public GMSSRootSig(Digest digest, int i2, int i3) {
        this.a = digest;
        this.h = new GMSSRandom(digest);
        int digestSize = this.a.getDigestSize();
        this.b = digestSize;
        this.g = i2;
        this.s = i3;
        this.j = (1 << i2) - 1;
        this.i = (int) Math.ceil(((double) (digestSize << 3)) / ((double) i2));
    }
}
