package org.spongycastle.pqc.crypto.gmss.util;

import java.lang.reflect.Array;
import org.spongycastle.crypto.Digest;
public class WinternitzOTSignature {
    public Digest a;
    public int b;
    public int c;
    public byte[][] d;
    public int e;
    public GMSSRandom f;
    public int g;
    public int h;

    public WinternitzOTSignature(byte[] bArr, Digest digest, int i) {
        this.e = i;
        this.a = digest;
        this.f = new GMSSRandom(digest);
        int digestSize = this.a.getDigestSize();
        this.b = digestSize;
        double d2 = (double) i;
        int ceil = (int) Math.ceil(((double) (digestSize << 3)) / d2);
        this.g = ceil;
        int log = getLog((ceil << i) + 1);
        this.h = log;
        int ceil2 = this.g + ((int) Math.ceil(((double) log) / d2));
        this.c = ceil2;
        int[] iArr = new int[2];
        iArr[1] = this.b;
        iArr[0] = ceil2;
        this.d = (byte[][]) Array.newInstance(byte.class, iArr);
        int i2 = this.b;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        for (int i3 = 0; i3 < this.c; i3++) {
            this.d[i3] = this.f.nextSeed(bArr2);
        }
    }

    public int getLog(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public byte[][] getPrivateKey() {
        return this.d;
    }

    public byte[] getPublicKey() {
        int i = this.c;
        int i2 = this.b;
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        byte[] bArr2 = new byte[i2];
        int i4 = 1 << this.e;
        for (int i5 = 0; i5 < this.c; i5++) {
            Digest digest = this.a;
            byte[][] bArr3 = this.d;
            digest.update(bArr3[i5], 0, bArr3[i5].length);
            byte[] bArr4 = new byte[this.a.getDigestSize()];
            this.a.doFinal(bArr4, 0);
            for (int i6 = 2; i6 < i4; i6++) {
                this.a.update(bArr4, 0, bArr4.length);
                bArr4 = new byte[this.a.getDigestSize()];
                this.a.doFinal(bArr4, 0);
            }
            int i7 = this.b;
            System.arraycopy(bArr4, 0, bArr, i7 * i5, i7);
        }
        this.a.update(bArr, 0, i3);
        byte[] bArr5 = new byte[this.a.getDigestSize()];
        this.a.doFinal(bArr5, 0);
        return bArr5;
    }

    public byte[] getSignature(byte[] bArr) {
        int i;
        int i2 = this.c;
        int i3 = this.b;
        byte[] bArr2 = new byte[(i2 * i3)];
        byte[] bArr3 = new byte[i3];
        this.a.update(bArr, 0, bArr.length);
        int digestSize = this.a.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        this.a.doFinal(bArr4, 0);
        int i4 = this.e;
        int i5 = 8;
        if (8 % i4 == 0) {
            int i6 = 8 / i4;
            int i7 = (1 << i4) - 1;
            byte[] bArr5 = new byte[this.b];
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < digestSize; i10++) {
                for (int i11 = 0; i11 < i6; i11++) {
                    int i12 = bArr4[i10] & i7;
                    i8 += i12;
                    System.arraycopy(this.d[i9], 0, bArr5, 0, this.b);
                    while (i12 > 0) {
                        this.a.update(bArr5, 0, bArr5.length);
                        bArr5 = new byte[this.a.getDigestSize()];
                        this.a.doFinal(bArr5, 0);
                        i12--;
                    }
                    int i13 = this.b;
                    System.arraycopy(bArr5, 0, bArr2, i9 * i13, i13);
                    bArr4[i10] = (byte) (bArr4[i10] >>> this.e);
                    i9++;
                }
            }
            int i14 = (this.g << this.e) - i8;
            int i15 = 0;
            while (i15 < this.h) {
                System.arraycopy(this.d[i9], 0, bArr5, 0, this.b);
                for (int i16 = i14 & i7; i16 > 0; i16--) {
                    this.a.update(bArr5, 0, bArr5.length);
                    bArr5 = new byte[this.a.getDigestSize()];
                    this.a.doFinal(bArr5, 0);
                }
                int i17 = this.b;
                System.arraycopy(bArr5, 0, bArr2, i9 * i17, i17);
                int i18 = this.e;
                i14 >>>= i18;
                i9++;
                i15 += i18;
            }
        } else if (i4 < 8) {
            int i19 = this.b;
            int i20 = i19 / i4;
            int i21 = (1 << i4) - 1;
            byte[] bArr6 = new byte[i19];
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i22 < i20) {
                long j = 0;
                for (int i26 = 0; i26 < this.e; i26++) {
                    j ^= (long) ((bArr4[i23] & 255) << (i26 << 3));
                    i23++;
                }
                int i27 = 0;
                while (i27 < i5) {
                    int i28 = (int) (j & ((long) i21));
                    i25 += i28;
                    System.arraycopy(this.d[i24], 0, bArr6, 0, this.b);
                    while (i28 > 0) {
                        this.a.update(bArr6, 0, bArr6.length);
                        bArr6 = new byte[this.a.getDigestSize()];
                        this.a.doFinal(bArr6, 0);
                        i28--;
                    }
                    int i29 = this.b;
                    System.arraycopy(bArr6, 0, bArr2, i24 * i29, i29);
                    j >>>= this.e;
                    i24++;
                    i27++;
                    i20 = i20;
                    i5 = 8;
                }
                i22++;
                i5 = 8;
            }
            int i30 = this.b % this.e;
            int i31 = 0;
            long j2 = 0;
            while (i31 < i30) {
                j2 ^= (long) ((bArr4[i23] & 255) << (i31 << 3));
                i23++;
                i31++;
                i30 = i30;
            }
            int i32 = i30 << 3;
            int i33 = 0;
            while (i33 < i32) {
                int i34 = (int) (((long) i21) & j2);
                i25 += i34;
                System.arraycopy(this.d[i24], 0, bArr6, 0, this.b);
                while (i34 > 0) {
                    this.a.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.a.getDigestSize()];
                    this.a.doFinal(bArr6, 0);
                    i34--;
                }
                int i35 = this.b;
                System.arraycopy(bArr6, 0, bArr2, i24 * i35, i35);
                int i36 = this.e;
                j2 >>>= i36;
                i24++;
                i33 += i36;
            }
            int i37 = (this.g << this.e) - i25;
            int i38 = 0;
            while (i38 < this.h) {
                System.arraycopy(this.d[i24], 0, bArr6, 0, this.b);
                for (int i39 = i37 & i21; i39 > 0; i39--) {
                    this.a.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.a.getDigestSize()];
                    this.a.doFinal(bArr6, 0);
                }
                int i40 = this.b;
                System.arraycopy(bArr6, 0, bArr2, i24 * i40, i40);
                int i41 = this.e;
                i37 >>>= i41;
                i24++;
                i38 += i41;
            }
        } else if (i4 < 57) {
            int i42 = this.b;
            int i43 = (i42 << 3) - i4;
            int i44 = (1 << i4) - 1;
            byte[] bArr7 = new byte[i42];
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            while (i46 <= i43) {
                int i48 = i46 % 8;
                i46 += this.e;
                int i49 = (i46 + 7) >>> 3;
                int i50 = 0;
                long j3 = 0;
                for (int i51 = i46 >>> 3; i51 < i49; i51++) {
                    j3 ^= (long) ((bArr4[i51] & 255) << (i50 << 3));
                    i50++;
                }
                long j4 = (j3 >>> i48) & ((long) i44);
                i45 = (int) (((long) i45) + j4);
                System.arraycopy(this.d[i47], 0, bArr7, 0, this.b);
                while (j4 > 0) {
                    this.a.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.a.getDigestSize()];
                    this.a.doFinal(bArr7, 0);
                    j4--;
                }
                int i52 = this.b;
                System.arraycopy(bArr7, 0, bArr2, i47 * i52, i52);
                i47++;
            }
            int i53 = i46 >>> 3;
            if (i53 < this.b) {
                int i54 = i46 % 8;
                int i55 = 0;
                long j5 = 0;
                while (true) {
                    i = this.b;
                    if (i53 >= i) {
                        break;
                    }
                    j5 ^= (long) ((bArr4[i53] & 255) << (i55 << 3));
                    i55++;
                    i53++;
                }
                long j6 = (j5 >>> i54) & ((long) i44);
                i45 = (int) (((long) i45) + j6);
                System.arraycopy(this.d[i47], 0, bArr7, 0, i);
                while (j6 > 0) {
                    this.a.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.a.getDigestSize()];
                    this.a.doFinal(bArr7, 0);
                    j6--;
                }
                int i56 = this.b;
                System.arraycopy(bArr7, 0, bArr2, i47 * i56, i56);
                i47++;
            }
            int i57 = (this.g << this.e) - i45;
            int i58 = i47;
            int i59 = 0;
            while (i59 < this.h) {
                System.arraycopy(this.d[i58], 0, bArr7, 0, this.b);
                for (long j7 = (long) (i57 & i44); j7 > 0; j7--) {
                    this.a.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.a.getDigestSize()];
                    this.a.doFinal(bArr7, 0);
                }
                int i60 = this.b;
                System.arraycopy(bArr7, 0, bArr2, i58 * i60, i60);
                int i61 = this.e;
                i57 >>>= i61;
                i58++;
                i59 += i61;
            }
        }
        return bArr2;
    }
}
