package org.spongycastle.crypto.digests;

import java.lang.reflect.Array;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;
public class GOST3411Digest implements ExtendedDigest, Memoable {
    public static final byte[] s = {0, -1, 0, -1, 0, -1, 0, -1, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, -1, -1, 0, -1};
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public byte[][] e;
    public byte[] f;
    public int g;
    public long h;
    public BlockCipher i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public short[] m;
    public short[] n;
    public byte[] o;
    public byte[] p;
    public byte[] q;
    public byte[] r;

    public GOST3411Digest() {
        this.a = new byte[32];
        this.b = new byte[32];
        this.c = new byte[32];
        this.d = new byte[32];
        this.e = (byte[][]) Array.newInstance(byte.class, 4, 32);
        this.f = new byte[32];
        this.i = new GOST28147Engine();
        this.k = new byte[32];
        this.l = new byte[8];
        this.m = new short[16];
        this.n = new short[16];
        this.o = new byte[32];
        this.p = new byte[32];
        this.q = new byte[32];
        this.r = new byte[32];
        byte[] sBox = GOST28147Engine.getSBox("D-A");
        this.j = sBox;
        this.i.init(true, new ParametersWithSBox(null, sBox));
        reset();
    }

    public final byte[] a(byte[] bArr) {
        for (int i2 = 0; i2 < 8; i2++) {
            this.l[i2] = (byte) (bArr[i2] ^ bArr[i2 + 8]);
        }
        System.arraycopy(bArr, 8, bArr, 0, 24);
        System.arraycopy(this.l, 0, bArr, 24, 8);
        return bArr;
    }

    public final byte[] b(byte[] bArr) {
        for (int i2 = 0; i2 < 8; i2++) {
            byte[] bArr2 = this.k;
            int i3 = i2 * 4;
            bArr2[i3] = bArr[i2];
            bArr2[i3 + 1] = bArr[i2 + 8];
            bArr2[i3 + 2] = bArr[i2 + 16];
            bArr2[i3 + 3] = bArr[i2 + 24];
        }
        return this.k;
    }

    public final void c(byte[] bArr) {
        short[] sArr = this.m;
        for (int i2 = 0; i2 < bArr.length / 2; i2++) {
            int i3 = i2 * 2;
            sArr[i2] = (short) ((bArr[i3] & 255) | ((bArr[i3 + 1] << 8) & 65280));
        }
        short[] sArr2 = this.n;
        short[] sArr3 = this.m;
        sArr2[15] = (short) (((((sArr3[0] ^ sArr3[1]) ^ sArr3[2]) ^ sArr3[3]) ^ sArr3[12]) ^ sArr3[15]);
        System.arraycopy(sArr3, 1, sArr2, 0, 15);
        short[] sArr4 = this.n;
        for (int i4 = 0; i4 < bArr.length / 2; i4++) {
            int i5 = i4 * 2;
            bArr[i5 + 1] = (byte) (sArr4[i4] >> 8);
            bArr[i5] = (byte) sArr4[i4];
        }
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new GOST3411Digest(this);
    }

    public final void d(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr2 = this.d;
            if (i2 != bArr2.length) {
                int i4 = (bArr2[i2] & 255) + (bArr[i2] & 255) + i3;
                bArr2[i2] = (byte) i4;
                i3 = i4 >>> 8;
                i2++;
            } else {
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        Pack.longToLittleEndian(this.h * 8, this.b, 0);
        while (this.g != 0) {
            update((byte) 0);
        }
        processBlock(this.b, 0);
        processBlock(this.d, 0);
        byte[] bArr2 = this.a;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        reset();
        return 32;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "GOST3411";
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 32;
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    public void processBlock(byte[] bArr, int i2) {
        System.arraycopy(bArr, i2, this.c, 0, 32);
        System.arraycopy(this.a, 0, this.p, 0, 32);
        System.arraycopy(this.c, 0, this.q, 0, 32);
        for (int i3 = 0; i3 < 32; i3++) {
            this.r[i3] = (byte) (this.p[i3] ^ this.q[i3]);
        }
        byte[] b2 = b(this.r);
        byte[] bArr2 = this.o;
        byte[] bArr3 = this.a;
        this.i.init(true, new KeyParameter(b2));
        this.i.processBlock(bArr3, 0, bArr2, 0);
        for (int i4 = 1; i4 < 4; i4++) {
            byte[] bArr4 = this.p;
            a(bArr4);
            for (int i5 = 0; i5 < 32; i5++) {
                this.p[i5] = (byte) (bArr4[i5] ^ this.e[i4][i5]);
            }
            byte[] bArr5 = this.q;
            a(bArr5);
            a(bArr5);
            this.q = bArr5;
            for (int i6 = 0; i6 < 32; i6++) {
                this.r[i6] = (byte) (this.p[i6] ^ this.q[i6]);
            }
            byte[] b3 = b(this.r);
            byte[] bArr6 = this.o;
            int i7 = i4 * 8;
            byte[] bArr7 = this.a;
            this.i.init(true, new KeyParameter(b3));
            this.i.processBlock(bArr7, i7, bArr6, i7);
        }
        for (int i8 = 0; i8 < 12; i8++) {
            c(this.o);
        }
        for (int i9 = 0; i9 < 32; i9++) {
            byte[] bArr8 = this.o;
            bArr8[i9] = (byte) (bArr8[i9] ^ this.c[i9]);
        }
        c(this.o);
        for (int i10 = 0; i10 < 32; i10++) {
            byte[] bArr9 = this.o;
            bArr9[i10] = (byte) (this.a[i10] ^ bArr9[i10]);
        }
        for (int i11 = 0; i11 < 61; i11++) {
            c(this.o);
        }
        byte[] bArr10 = this.o;
        byte[] bArr11 = this.a;
        System.arraycopy(bArr10, 0, bArr11, 0, bArr11.length);
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.h = 0;
        this.g = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 0;
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = this.b;
            if (i3 >= bArr2.length) {
                break;
            }
            bArr2[i3] = 0;
            i3++;
        }
        int i4 = 0;
        while (true) {
            byte[] bArr3 = this.c;
            if (i4 >= bArr3.length) {
                break;
            }
            bArr3[i4] = 0;
            i4++;
        }
        int i5 = 0;
        while (true) {
            byte[][] bArr4 = this.e;
            if (i5 >= bArr4[1].length) {
                break;
            }
            bArr4[1][i5] = 0;
            i5++;
        }
        int i6 = 0;
        while (true) {
            byte[][] bArr5 = this.e;
            if (i6 >= bArr5[3].length) {
                break;
            }
            bArr5[3][i6] = 0;
            i6++;
        }
        int i7 = 0;
        while (true) {
            byte[] bArr6 = this.d;
            if (i7 >= bArr6.length) {
                break;
            }
            bArr6[i7] = 0;
            i7++;
        }
        int i8 = 0;
        while (true) {
            byte[] bArr7 = this.f;
            if (i8 < bArr7.length) {
                bArr7[i8] = 0;
                i8++;
            } else {
                byte[] bArr8 = s;
                System.arraycopy(bArr8, 0, this.e[2], 0, bArr8.length);
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b2) {
        byte[] bArr = this.f;
        int i2 = this.g;
        int i3 = i2 + 1;
        this.g = i3;
        bArr[i2] = b2;
        if (i3 == bArr.length) {
            d(bArr);
            processBlock(this.f, 0);
            this.g = 0;
        }
        this.h++;
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i2, int i3) {
        while (this.g != 0 && i3 > 0) {
            update(bArr[i2]);
            i2++;
            i3--;
        }
        while (true) {
            byte[] bArr2 = this.f;
            if (i3 <= bArr2.length) {
                break;
            }
            System.arraycopy(bArr, i2, bArr2, 0, bArr2.length);
            d(this.f);
            processBlock(this.f, 0);
            byte[] bArr3 = this.f;
            i2 += bArr3.length;
            i3 -= bArr3.length;
            this.h += (long) bArr3.length;
        }
        while (i3 > 0) {
            update(bArr[i2]);
            i2++;
            i3--;
        }
    }

    public GOST3411Digest(byte[] bArr) {
        this.a = new byte[32];
        this.b = new byte[32];
        this.c = new byte[32];
        this.d = new byte[32];
        this.e = (byte[][]) Array.newInstance(byte.class, 4, 32);
        this.f = new byte[32];
        this.i = new GOST28147Engine();
        this.k = new byte[32];
        this.l = new byte[8];
        this.m = new short[16];
        this.n = new short[16];
        this.o = new byte[32];
        this.p = new byte[32];
        this.q = new byte[32];
        this.r = new byte[32];
        byte[] clone = Arrays.clone(bArr);
        this.j = clone;
        this.i.init(true, new ParametersWithSBox(null, clone));
        reset();
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        GOST3411Digest gOST3411Digest = (GOST3411Digest) memoable;
        byte[] bArr = gOST3411Digest.j;
        this.j = bArr;
        this.i.init(true, new ParametersWithSBox(null, bArr));
        reset();
        byte[] bArr2 = gOST3411Digest.a;
        System.arraycopy(bArr2, 0, this.a, 0, bArr2.length);
        byte[] bArr3 = gOST3411Digest.b;
        System.arraycopy(bArr3, 0, this.b, 0, bArr3.length);
        byte[] bArr4 = gOST3411Digest.c;
        System.arraycopy(bArr4, 0, this.c, 0, bArr4.length);
        byte[] bArr5 = gOST3411Digest.d;
        System.arraycopy(bArr5, 0, this.d, 0, bArr5.length);
        byte[][] bArr6 = gOST3411Digest.e;
        System.arraycopy(bArr6[1], 0, this.e[1], 0, bArr6[1].length);
        byte[][] bArr7 = gOST3411Digest.e;
        System.arraycopy(bArr7[2], 0, this.e[2], 0, bArr7[2].length);
        byte[][] bArr8 = gOST3411Digest.e;
        System.arraycopy(bArr8[3], 0, this.e[3], 0, bArr8[3].length);
        byte[] bArr9 = gOST3411Digest.f;
        System.arraycopy(bArr9, 0, this.f, 0, bArr9.length);
        this.g = gOST3411Digest.g;
        this.h = gOST3411Digest.h;
    }

    public GOST3411Digest(GOST3411Digest gOST3411Digest) {
        this.a = new byte[32];
        this.b = new byte[32];
        this.c = new byte[32];
        this.d = new byte[32];
        this.e = (byte[][]) Array.newInstance(byte.class, 4, 32);
        this.f = new byte[32];
        this.i = new GOST28147Engine();
        this.k = new byte[32];
        this.l = new byte[8];
        this.m = new short[16];
        this.n = new short[16];
        this.o = new byte[32];
        this.p = new byte[32];
        this.q = new byte[32];
        this.r = new byte[32];
        reset(gOST3411Digest);
    }
}
