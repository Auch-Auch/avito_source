package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;
public final class WhirlpoolDigest implements ExtendedDigest, Memoable {
    public static final int[] j = {24, 35, 198, 232, 135, 184, 1, 79, 54, 166, 210, 245, 121, 111, 145, 82, 96, 188, 155, 142, 163, 12, 123, 53, 29, 224, 215, 194, 46, 75, 254, 87, 21, 119, 55, 229, 159, 240, 74, 218, 88, 201, 41, 10, 177, 160, 107, 133, 189, 93, 16, 244, 203, 62, 5, 103, 228, 39, 65, 139, 167, 125, 149, 216, 251, 238, 124, 102, 221, 23, 71, 158, 202, 45, 191, 7, 173, 90, 131, 51, 99, 2, 170, 113, 200, 25, 73, 217, 242, 227, 91, 136, 154, 38, 50, 176, 233, 15, 213, 128, 190, 205, 52, 72, 255, 122, 144, 95, 32, 104, 26, 174, 180, 84, 147, 34, 100, 241, 115, 18, 64, 8, 195, 236, 219, 161, 141, 61, 151, 0, 207, 43, 118, 130, 214, 27, 181, 175, 106, 80, 69, 243, 48, 239, 63, 85, 162, 234, 101, 186, 47, 192, 222, 28, 253, 77, 146, 117, 6, 138, 178, 230, 14, 31, 98, 212, 168, 150, 249, 197, 37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 59, 171, 206, 17, 143, 78, 183, 235, 60, 129, 148, 247, 185, 19, 44, 211, 231, 110, 196, 3, 86, 68, 127, 169, 42, 187, 193, 83, 220, 11, 157, 108, 49, 116, 246, 70, 172, 137, 20, 225, 22, 58, 105, 9, 112, 182, 208, 237, 204, 66, 152, 164, 40, 92, 248, 134};
    public static final long[] k = new long[256];
    public static final long[] l = new long[256];
    public static final long[] m = new long[256];
    public static final long[] n = new long[256];
    public static final long[] o = new long[256];
    public static final long[] p = new long[256];
    public static final long[] q = new long[256];
    public static final long[] r = new long[256];
    public static final short[] s;
    public final long[] a;
    public byte[] b;
    public int c;
    public short[] d;
    public long[] e;
    public long[] f;
    public long[] g;
    public long[] h;
    public long[] i;

    static {
        short[] sArr = new short[32];
        s = sArr;
        sArr[31] = 8;
    }

    public WhirlpoolDigest() {
        this.a = new long[11];
        this.b = new byte[64];
        this.c = 0;
        this.d = new short[32];
        this.e = new long[8];
        this.f = new long[8];
        this.g = new long[8];
        this.h = new long[8];
        this.i = new long[8];
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = j[i2];
            int a3 = a(i3 << 1);
            int a4 = a(a3 << 1);
            int i4 = a4 ^ i3;
            int a5 = a(a4 << 1);
            int i5 = a5 ^ i3;
            k[i2] = b(i3, i3, a4, i3, a5, i4, a3, i5);
            l[i2] = b(i5, i3, i3, a4, i3, a5, i4, a3);
            m[i2] = b(a3, i5, i3, i3, a4, i3, a5, i4);
            n[i2] = b(i4, a3, i5, i3, i3, a4, i3, a5);
            o[i2] = b(a5, i4, a3, i5, i3, i3, a4, i3);
            p[i2] = b(i3, a5, i4, a3, i5, i3, i3, a4);
            q[i2] = b(a4, i3, a5, i4, a3, i5, i3, i3);
            r[i2] = b(i3, a4, i3, a5, i4, a3, i5, i3);
        }
        this.a[0] = 0;
        for (int i6 = 1; i6 <= 10; i6++) {
            int i7 = (i6 - 1) * 8;
            this.a[i6] = (((((((k[i7] & -72057594037927936L) ^ (l[i7 + 1] & 71776119061217280L)) ^ (m[i7 + 2] & 280375465082880L)) ^ (n[i7 + 3] & 1095216660480L)) ^ (o[i7 + 4] & 4278190080L)) ^ (p[i7 + 5] & 16711680)) ^ (q[i7 + 6] & 65280)) ^ (r[i7 + 7] & 255);
        }
    }

    public final int a(int i2) {
        return ((long) i2) >= 256 ? i2 ^ 285 : i2;
    }

    public final long b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return (((((((((long) i3) << 48) ^ (((long) i2) << 56)) ^ (((long) i4) << 40)) ^ (((long) i5) << 32)) ^ (((long) i6) << 24)) ^ (((long) i7) << 16)) ^ (((long) i8) << 8)) ^ ((long) i9);
    }

    public final void c() {
        for (int i2 = 0; i2 < this.i.length; i2++) {
            long[] jArr = this.h;
            byte[] bArr = this.b;
            int i3 = i2 * 8;
            jArr[i2] = (((long) bArr[i3 + 7]) & 255) | ((((long) bArr[i3 + 0]) & 255) << 56) | ((((long) bArr[i3 + 1]) & 255) << 48) | ((((long) bArr[i3 + 2]) & 255) << 40) | ((((long) bArr[i3 + 3]) & 255) << 32) | ((((long) bArr[i3 + 4]) & 255) << 24) | ((((long) bArr[i3 + 5]) & 255) << 16) | ((((long) bArr[i3 + 6]) & 255) << 8);
        }
        processBlock();
        this.c = 0;
        Arrays.fill(this.b, (byte) 0);
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new WhirlpoolDigest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[32];
        for (int i3 = 0; i3 < 32; i3++) {
            bArr2[i3] = (byte) (this.d[i3] & 255);
        }
        byte[] bArr3 = this.b;
        int i4 = this.c;
        int i5 = i4 + 1;
        this.c = i5;
        bArr3[i4] = (byte) (bArr3[i4] | 128);
        if (i5 == bArr3.length) {
            c();
        }
        if (this.c > 32) {
            while (this.c != 0) {
                update((byte) 0);
            }
        }
        while (this.c <= 32) {
            update((byte) 0);
        }
        System.arraycopy(bArr2, 0, this.b, 32, 32);
        c();
        for (int i6 = 0; i6 < 8; i6++) {
            long j2 = this.e[i6];
            int i7 = (i6 * 8) + i2;
            for (int i8 = 0; i8 < 8; i8++) {
                bArr[i7 + i8] = (byte) ((int) ((j2 >> (56 - (i8 * 8))) & 255));
            }
        }
        reset();
        return getDigestSize();
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "Whirlpool";
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 64;
    }

    public void processBlock() {
        for (int i2 = 0; i2 < 8; i2++) {
            long[] jArr = this.i;
            long j2 = this.h[i2];
            long[] jArr2 = this.f;
            long j3 = this.e[i2];
            jArr2[i2] = j3;
            jArr[i2] = j2 ^ j3;
        }
        int i3 = 1;
        while (i3 <= 10) {
            int i4 = 0;
            while (i4 < 8) {
                long[] jArr3 = this.g;
                jArr3[i4] = 0;
                long j4 = jArr3[i4];
                long[] jArr4 = k;
                long[] jArr5 = this.f;
                jArr3[i4] = jArr4[((int) (jArr5[(i4 + 0) & 7] >>> 56)) & 255] ^ j4;
                jArr3[i4] = jArr3[i4] ^ l[((int) (jArr5[(i4 - 1) & 7] >>> 48)) & 255];
                jArr3[i4] = jArr3[i4] ^ m[((int) (jArr5[(i4 - 2) & 7] >>> 40)) & 255];
                jArr3[i4] = jArr3[i4] ^ n[((int) (jArr5[(i4 - 3) & 7] >>> 32)) & 255];
                jArr3[i4] = jArr3[i4] ^ o[((int) (jArr5[(i4 - 4) & 7] >>> 24)) & 255];
                jArr3[i4] = jArr3[i4] ^ p[((int) (jArr5[(i4 - 5) & 7] >>> 16)) & 255];
                jArr3[i4] = jArr3[i4] ^ q[((int) (jArr5[(i4 - 6) & 7] >>> 8)) & 255];
                jArr3[i4] = jArr3[i4] ^ r[((int) jArr5[(i4 - 7) & 7]) & 255];
                i4++;
                i3 = i3;
            }
            long[] jArr6 = this.g;
            long[] jArr7 = this.f;
            System.arraycopy(jArr6, 0, jArr7, 0, jArr7.length);
            long[] jArr8 = this.f;
            jArr8[0] = jArr8[0] ^ this.a[i3];
            for (int i5 = 0; i5 < 8; i5++) {
                long[] jArr9 = this.g;
                jArr9[i5] = this.f[i5];
                long j5 = jArr9[i5];
                long[] jArr10 = k;
                long[] jArr11 = this.i;
                jArr9[i5] = j5 ^ jArr10[((int) (jArr11[(i5 + 0) & 7] >>> 56)) & 255];
                jArr9[i5] = jArr9[i5] ^ l[((int) (jArr11[(i5 - 1) & 7] >>> 48)) & 255];
                jArr9[i5] = jArr9[i5] ^ m[((int) (jArr11[(i5 - 2) & 7] >>> 40)) & 255];
                jArr9[i5] = jArr9[i5] ^ n[((int) (jArr11[(i5 - 3) & 7] >>> 32)) & 255];
                jArr9[i5] = jArr9[i5] ^ o[((int) (jArr11[(i5 - 4) & 7] >>> 24)) & 255];
                jArr9[i5] = jArr9[i5] ^ p[((int) (jArr11[(i5 - 5) & 7] >>> 16)) & 255];
                jArr9[i5] = jArr9[i5] ^ q[((int) (jArr11[(i5 - 6) & 7] >>> 8)) & 255];
                jArr9[i5] = jArr9[i5] ^ r[((int) jArr11[(i5 - 7) & 7]) & 255];
            }
            long[] jArr12 = this.g;
            long[] jArr13 = this.i;
            System.arraycopy(jArr12, 0, jArr13, 0, jArr13.length);
            i3++;
        }
        for (int i6 = 0; i6 < 8; i6++) {
            long[] jArr14 = this.e;
            jArr14[i6] = jArr14[i6] ^ (this.i[i6] ^ this.h[i6]);
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.c = 0;
        Arrays.fill(this.d, (short) 0);
        Arrays.fill(this.b, (byte) 0);
        Arrays.fill(this.e, 0);
        Arrays.fill(this.f, 0);
        Arrays.fill(this.g, 0);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b2) {
        byte[] bArr = this.b;
        int i2 = this.c;
        bArr[i2] = b2;
        int i3 = i2 + 1;
        this.c = i3;
        if (i3 == bArr.length) {
            c();
        }
        int i4 = 0;
        for (int length = this.d.length - 1; length >= 0; length--) {
            short[] sArr = this.d;
            int i5 = (sArr[length] & 255) + s[length] + i4;
            i4 = i5 >>> 8;
            sArr[length] = (short) (i5 & 255);
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i2, int i3) {
        while (i3 > 0) {
            update(bArr[i2]);
            i2++;
            i3--;
        }
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        WhirlpoolDigest whirlpoolDigest = (WhirlpoolDigest) memoable;
        long[] jArr = whirlpoolDigest.a;
        long[] jArr2 = this.a;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        byte[] bArr = whirlpoolDigest.b;
        byte[] bArr2 = this.b;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.c = whirlpoolDigest.c;
        short[] sArr = whirlpoolDigest.d;
        short[] sArr2 = this.d;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        long[] jArr3 = whirlpoolDigest.e;
        long[] jArr4 = this.e;
        System.arraycopy(jArr3, 0, jArr4, 0, jArr4.length);
        long[] jArr5 = whirlpoolDigest.f;
        long[] jArr6 = this.f;
        System.arraycopy(jArr5, 0, jArr6, 0, jArr6.length);
        long[] jArr7 = whirlpoolDigest.g;
        long[] jArr8 = this.g;
        System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
        long[] jArr9 = whirlpoolDigest.h;
        long[] jArr10 = this.h;
        System.arraycopy(jArr9, 0, jArr10, 0, jArr10.length);
        long[] jArr11 = whirlpoolDigest.i;
        long[] jArr12 = this.i;
        System.arraycopy(jArr11, 0, jArr12, 0, jArr12.length);
    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpoolDigest) {
        this.a = new long[11];
        this.b = new byte[64];
        this.c = 0;
        this.d = new short[32];
        this.e = new long[8];
        this.f = new long[8];
        this.g = new long[8];
        this.h = new long[8];
        this.i = new long[8];
        reset(whirlpoolDigest);
    }
}
