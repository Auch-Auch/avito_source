package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;
public class Blake2bDigest implements ExtendedDigest {
    public static final long[] m = {7640891576956012808L, -4942790177534073029L, 4354685564936845355L, -6534734903238641935L, 5840696475078001361L, -7276294671716946913L, 2270897969802886507L, 6620516959819538809L};
    public static final byte[][] n = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI}, new byte[]{Ascii.SO, 10, 4, 8, 9, Ascii.SI, Ascii.CR, 6, 1, Ascii.FF, 0, 2, Ascii.VT, 7, 5, 3}, new byte[]{Ascii.VT, 8, Ascii.FF, 0, 5, 2, Ascii.SI, Ascii.CR, 10, Ascii.SO, 3, 6, 7, 1, 9, 4}, new byte[]{7, 9, 3, 1, Ascii.CR, Ascii.FF, Ascii.VT, Ascii.SO, 2, 6, 5, 10, 4, 0, Ascii.SI, 8}, new byte[]{9, 0, 5, 7, 2, 4, 10, Ascii.SI, Ascii.SO, 1, Ascii.VT, Ascii.FF, 6, 8, 3, Ascii.CR}, new byte[]{2, Ascii.FF, 6, 10, 0, Ascii.VT, 8, 3, 4, Ascii.CR, 7, 5, Ascii.SI, Ascii.SO, 1, 9}, new byte[]{Ascii.FF, 5, 1, Ascii.SI, Ascii.SO, Ascii.CR, 4, 10, 0, 7, 6, 3, 9, 2, 8, Ascii.VT}, new byte[]{Ascii.CR, Ascii.VT, 7, Ascii.SO, Ascii.FF, 1, 3, 9, 5, 0, Ascii.SI, 4, 8, 6, 2, 10}, new byte[]{6, Ascii.SI, Ascii.SO, 9, Ascii.VT, 3, 0, 8, Ascii.FF, 2, Ascii.CR, 7, 1, 4, 10, 5}, new byte[]{10, 2, 8, 4, 7, 6, 1, 5, Ascii.SI, Ascii.VT, 9, Ascii.SO, 3, Ascii.FF, Ascii.CR, 0}, new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI}, new byte[]{Ascii.SO, 10, 4, 8, 9, Ascii.SI, Ascii.CR, 6, 1, Ascii.FF, 0, 2, Ascii.VT, 7, 5, 3}};
    public int a;
    public int b;
    public byte[] c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public int g;
    public long[] h;
    public long[] i;
    public long j;
    public long k;
    public long l;

    public Blake2bDigest() {
        this(512);
    }

    public final void a(long j2, long j3, int i2, int i3, int i4, int i5) {
        long[] jArr = this.h;
        jArr[i2] = jArr[i2] + jArr[i3] + j2;
        jArr[i5] = e(jArr[i5] ^ jArr[i2], 32);
        long[] jArr2 = this.h;
        jArr2[i4] = jArr2[i4] + jArr2[i5];
        jArr2[i3] = e(jArr2[i3] ^ jArr2[i4], 24);
        long[] jArr3 = this.h;
        jArr3[i2] = jArr3[i2] + jArr3[i3] + j3;
        jArr3[i5] = e(jArr3[i5] ^ jArr3[i2], 16);
        long[] jArr4 = this.h;
        jArr4[i4] = jArr4[i4] + jArr4[i5];
        jArr4[i3] = e(jArr4[i3] ^ jArr4[i4], 63);
    }

    public final long b(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    public final void c(byte[] bArr, int i2) {
        long[] jArr = this.i;
        int i3 = 0;
        System.arraycopy(jArr, 0, this.h, 0, jArr.length);
        long[] jArr2 = m;
        System.arraycopy(jArr2, 0, this.h, this.i.length, 4);
        long[] jArr3 = this.h;
        jArr3[12] = this.j ^ jArr2[4];
        jArr3[13] = this.k ^ jArr2[5];
        jArr3[14] = this.l ^ jArr2[6];
        jArr3[15] = jArr2[7];
        long[] jArr4 = new long[16];
        for (int i4 = 0; i4 < 16; i4++) {
            jArr4[i4] = b(bArr, (i4 * 8) + i2);
        }
        int i5 = 0;
        while (i5 < 12) {
            byte[][] bArr2 = n;
            a(jArr4[bArr2[i5][0]], jArr4[bArr2[i5][1]], 0, 4, 8, 12);
            a(jArr4[bArr2[i5][2]], jArr4[bArr2[i5][3]], 1, 5, 9, 13);
            a(jArr4[bArr2[i5][4]], jArr4[bArr2[i5][5]], 2, 6, 10, 14);
            a(jArr4[bArr2[i5][6]], jArr4[bArr2[i5][7]], 3, 7, 11, 15);
            a(jArr4[bArr2[i5][8]], jArr4[bArr2[i5][9]], 0, 5, 10, 15);
            a(jArr4[bArr2[i5][10]], jArr4[bArr2[i5][11]], 1, 6, 11, 12);
            a(jArr4[bArr2[i5][12]], jArr4[bArr2[i5][13]], 2, 7, 8, 13);
            a(jArr4[bArr2[i5][14]], jArr4[bArr2[i5][15]], 3, 4, 9, 14);
            i5++;
            jArr4 = jArr4;
        }
        while (true) {
            long[] jArr5 = this.i;
            if (i3 < jArr5.length) {
                long j2 = jArr5[i3];
                long[] jArr6 = this.h;
                jArr5[i3] = (j2 ^ jArr6[i3]) ^ jArr6[i3 + 8];
                i3++;
            } else {
                return;
            }
        }
    }

    public void clearKey() {
        byte[] bArr = this.e;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
            Arrays.fill(this.f, (byte) 0);
        }
    }

    public void clearSalt() {
        byte[] bArr = this.c;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    public final void d() {
        if (this.i == null) {
            long[] jArr = new long[8];
            this.i = jArr;
            long[] jArr2 = m;
            jArr[0] = jArr2[0] ^ ((long) ((this.a | (this.b << 8)) | 16842752));
            jArr[1] = jArr2[1];
            jArr[2] = jArr2[2];
            jArr[3] = jArr2[3];
            jArr[4] = jArr2[4];
            jArr[5] = jArr2[5];
            byte[] bArr = this.c;
            if (bArr != null) {
                jArr[4] = jArr[4] ^ b(bArr, 0);
                long[] jArr3 = this.i;
                jArr3[5] = jArr3[5] ^ b(this.c, 8);
            }
            long[] jArr4 = this.i;
            jArr4[6] = jArr2[6];
            jArr4[7] = jArr2[7];
            byte[] bArr2 = this.d;
            if (bArr2 != null) {
                jArr4[6] = b(bArr2, 0) ^ jArr4[6];
                long[] jArr5 = this.i;
                jArr5[7] = jArr5[7] ^ b(this.d, 8);
            }
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        long[] jArr;
        int i3;
        int i4;
        this.l = -1;
        long j2 = this.j;
        int i5 = this.g;
        long j3 = j2 + ((long) i5);
        this.j = j3;
        if (j3 < 0 && ((long) i5) > (-j3)) {
            this.k++;
        }
        c(this.f, 0);
        Arrays.fill(this.f, (byte) 0);
        Arrays.fill(this.h, 0);
        int i6 = 0;
        while (true) {
            jArr = this.i;
            if (i6 >= jArr.length || (i3 = i6 * 8) >= (i4 = this.a)) {
                break;
            }
            long j4 = jArr[i6];
            byte[] bArr2 = {(byte) ((int) j4), (byte) ((int) (j4 >> 8)), (byte) ((int) (j4 >> 16)), (byte) ((int) (j4 >> 24)), (byte) ((int) (j4 >> 32)), (byte) ((int) (j4 >> 40)), (byte) ((int) (j4 >> 48)), (byte) ((int) (j4 >> 56))};
            if (i3 < i4 - 8) {
                System.arraycopy(bArr2, 0, bArr, i3 + i2, 8);
            } else {
                System.arraycopy(bArr2, 0, bArr, i2 + i3, i4 - i3);
            }
            i6++;
        }
        Arrays.fill(jArr, 0);
        reset();
        return this.a;
    }

    public final long e(long j2, int i2) {
        return (j2 << (64 - i2)) | (j2 >>> i2);
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "Blake2b";
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 128;
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.g = 0;
        this.l = 0;
        this.j = 0;
        this.k = 0;
        this.i = null;
        Arrays.fill(this.f, (byte) 0);
        byte[] bArr = this.e;
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.f, 0, bArr.length);
            this.g = 128;
        }
        d();
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b2) {
        int i2 = this.g;
        if (128 - i2 == 0) {
            long j2 = this.j + 128;
            this.j = j2;
            if (j2 == 0) {
                this.k++;
            }
            c(this.f, 0);
            Arrays.fill(this.f, (byte) 0);
            this.f[0] = b2;
            this.g = 1;
            return;
        }
        this.f[i2] = b2;
        this.g = i2 + 1;
    }

    public Blake2bDigest(Blake2bDigest blake2bDigest) {
        this.a = 64;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = new long[16];
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.g = blake2bDigest.g;
        this.f = Arrays.clone(blake2bDigest.f);
        this.b = blake2bDigest.b;
        this.e = Arrays.clone(blake2bDigest.e);
        this.a = blake2bDigest.a;
        this.i = Arrays.clone(blake2bDigest.i);
        this.d = Arrays.clone(blake2bDigest.d);
        this.c = Arrays.clone(blake2bDigest.c);
        this.j = blake2bDigest.j;
        this.k = blake2bDigest.k;
        this.l = blake2bDigest.l;
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i2, int i3) {
        int i4;
        if (bArr != null && i3 != 0) {
            int i5 = this.g;
            if (i5 != 0) {
                i4 = 128 - i5;
                if (i4 < i3) {
                    System.arraycopy(bArr, i2, this.f, i5, i4);
                    long j2 = this.j + 128;
                    this.j = j2;
                    if (j2 == 0) {
                        this.k++;
                    }
                    c(this.f, 0);
                    this.g = 0;
                    Arrays.fill(this.f, (byte) 0);
                } else {
                    System.arraycopy(bArr, i2, this.f, i5, i3);
                    this.g += i3;
                    return;
                }
            } else {
                i4 = 0;
            }
            int i6 = i3 + i2;
            int i7 = i6 - 128;
            int i8 = i2 + i4;
            while (i8 < i7) {
                long j3 = this.j + 128;
                this.j = j3;
                if (j3 == 0) {
                    this.k++;
                }
                c(bArr, i8);
                i8 += 128;
            }
            int i9 = i6 - i8;
            System.arraycopy(bArr, i8, this.f, 0, i9);
            this.g += i9;
        }
    }

    public Blake2bDigest(int i2) {
        this.a = 64;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = new long[16];
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        if (i2 == 160 || i2 == 256 || i2 == 384 || i2 == 512) {
            this.f = new byte[128];
            this.b = 0;
            this.a = i2 / 8;
            d();
            return;
        }
        throw new IllegalArgumentException("Blake2b digest restricted to one of [160, 256, 384, 512]");
    }

    public Blake2bDigest(byte[] bArr) {
        this.a = 64;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = new long[16];
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f = new byte[128];
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.e = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            if (bArr.length <= 64) {
                this.b = bArr.length;
                System.arraycopy(bArr, 0, this.f, 0, bArr.length);
                this.g = 128;
            } else {
                throw new IllegalArgumentException("Keys > 64 are not supported");
            }
        }
        this.a = 64;
        d();
    }

    public Blake2bDigest(byte[] bArr, int i2, byte[] bArr2, byte[] bArr3) {
        this.a = 64;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = new long[16];
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f = new byte[128];
        if (i2 < 1 || i2 > 64) {
            throw new IllegalArgumentException("Invalid digest length (required: 1 - 64)");
        }
        this.a = i2;
        if (bArr2 != null) {
            if (bArr2.length == 16) {
                byte[] bArr4 = new byte[16];
                this.c = bArr4;
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            } else {
                throw new IllegalArgumentException("salt length must be exactly 16 bytes");
            }
        }
        if (bArr3 != null) {
            if (bArr3.length == 16) {
                byte[] bArr5 = new byte[16];
                this.d = bArr5;
                System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
            } else {
                throw new IllegalArgumentException("personalization length must be exactly 16 bytes");
            }
        }
        if (bArr != null) {
            byte[] bArr6 = new byte[bArr.length];
            this.e = bArr6;
            System.arraycopy(bArr, 0, bArr6, 0, bArr.length);
            if (bArr.length <= 64) {
                this.b = bArr.length;
                System.arraycopy(bArr, 0, this.f, 0, bArr.length);
                this.g = 128;
            } else {
                throw new IllegalArgumentException("Keys > 64 are not supported");
            }
        }
        d();
    }
}
