package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;
public class SM3Digest extends GeneralDigest {
    public static final int[] i = new int[64];
    public int[] d;
    public int[] e;
    public int f;
    public int[] g;
    public int[] h;

    static {
        int i2;
        int i3 = 0;
        while (true) {
            if (i3 >= 16) {
                break;
            }
            i[i3] = (2043430169 >>> (32 - i3)) | (2043430169 << i3);
            i3++;
        }
        for (i2 = 16; i2 < 64; i2++) {
            int i4 = i2 % 32;
            i[i2] = (2055708042 >>> (32 - i4)) | (2055708042 << i4);
        }
    }

    public SM3Digest() {
        this.d = new int[8];
        this.e = new int[16];
        this.g = new int[68];
        this.h = new int[64];
        reset();
    }

    public final void a(SM3Digest sM3Digest) {
        int[] iArr = sM3Digest.d;
        int[] iArr2 = this.d;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = sM3Digest.e;
        int[] iArr4 = this.e;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        this.f = sM3Digest.f;
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SM3Digest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        finish();
        Pack.intToBigEndian(this.d[0], bArr, i2 + 0);
        Pack.intToBigEndian(this.d[1], bArr, i2 + 4);
        Pack.intToBigEndian(this.d[2], bArr, i2 + 8);
        Pack.intToBigEndian(this.d[3], bArr, i2 + 12);
        Pack.intToBigEndian(this.d[4], bArr, i2 + 16);
        Pack.intToBigEndian(this.d[5], bArr, i2 + 20);
        Pack.intToBigEndian(this.d[6], bArr, i2 + 24);
        Pack.intToBigEndian(this.d[7], bArr, i2 + 28);
        reset();
        return 32;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SM3";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int i2;
        for (int i3 = 0; i3 < 16; i3++) {
            this.g[i3] = this.e[i3];
        }
        for (int i4 = 16; i4 < 68; i4++) {
            int[] iArr = this.g;
            int i5 = iArr[i4 - 3];
            int i6 = (i5 >>> 17) | (i5 << 15);
            int i7 = iArr[i4 - 13];
            int i8 = i6 ^ (iArr[i4 - 16] ^ iArr[i4 - 9]);
            iArr[i4] = (((i8 ^ ((i8 << 15) | (i8 >>> 17))) ^ ((i8 << 23) | (i8 >>> 9))) ^ ((i7 >>> 25) | (i7 << 7))) ^ iArr[i4 - 6];
        }
        int i9 = 0;
        while (true) {
            i2 = 64;
            if (i9 >= 64) {
                break;
            }
            int[] iArr2 = this.h;
            int[] iArr3 = this.g;
            iArr2[i9] = iArr3[i9 + 4] ^ iArr3[i9];
            i9++;
        }
        int[] iArr4 = this.d;
        int i10 = iArr4[0];
        int i11 = iArr4[1];
        int i12 = iArr4[2];
        int i13 = iArr4[3];
        int i14 = iArr4[4];
        int i15 = iArr4[5];
        int i16 = iArr4[6];
        int i17 = iArr4[7];
        int i18 = 0;
        while (i18 < 16) {
            int i19 = (i10 << 12) | (i10 >>> 20);
            int i20 = i19 + i14 + i[i18];
            int i21 = (i20 << 7) | (i20 >>> 25);
            int i22 = ((i10 ^ i11) ^ i12) + i13 + (i21 ^ i19) + this.h[i18];
            int i23 = ((i14 ^ i15) ^ i16) + i17 + i21 + this.g[i18];
            int i24 = (i11 << 9) | (i11 >>> 23);
            int i25 = (i15 << 19) | (i15 >>> 13);
            int i26 = (i23 ^ ((i23 << 9) | (i23 >>> 23))) ^ ((i23 << 17) | (i23 >>> 15));
            i18++;
            i12 = i24;
            i17 = i16;
            i16 = i25;
            i11 = i10;
            i10 = i22;
            i13 = i12;
            i15 = i14;
            i14 = i26;
        }
        int i27 = i17;
        int i28 = i14;
        int i29 = i16;
        int i30 = i13;
        int i31 = i12;
        int i32 = i11;
        int i33 = i10;
        int i34 = 16;
        while (i34 < i2) {
            int i35 = (i33 << 12) | (i33 >>> 20);
            int i36 = i35 + i28 + i[i34];
            int i37 = (i36 << 7) | (i36 >>> 25);
            int i38 = ((i33 & i31) | (i33 & i32) | (i32 & i31)) + i30;
            int i39 = (((~i28) & i29) | (i15 & i28)) + i27 + i37 + this.g[i34];
            int i40 = (i32 >>> 23) | (i32 << 9);
            int i41 = (i15 << 19) | (i15 >>> 13);
            int i42 = i39 ^ ((i39 << 9) | (i39 >>> 23));
            i34++;
            i15 = i28;
            i28 = i42 ^ ((i39 << 17) | (i39 >>> 15));
            i2 = 64;
            i27 = i29;
            i29 = i41;
            i32 = i33;
            i33 = i38 + (i37 ^ i35) + this.h[i34];
            i30 = i31;
            i31 = i40;
        }
        int[] iArr5 = this.d;
        iArr5[0] = iArr5[0] ^ i33;
        iArr5[1] = iArr5[1] ^ i32;
        iArr5[2] = iArr5[2] ^ i31;
        iArr5[3] = iArr5[3] ^ i30;
        iArr5[4] = iArr5[4] ^ i28;
        iArr5[5] = iArr5[5] ^ i15;
        iArr5[6] = i29 ^ iArr5[6];
        iArr5[7] = iArr5[7] ^ i27;
        this.f = 0;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j) {
        int i2 = this.f;
        if (i2 > 14) {
            this.e[i2] = 0;
            this.f = i2 + 1;
            processBlock();
        }
        while (true) {
            int i3 = this.f;
            if (i3 < 14) {
                this.e[i3] = 0;
                this.f = i3 + 1;
            } else {
                int[] iArr = this.e;
                int i4 = i3 + 1;
                this.f = i4;
                iArr[i3] = (int) (j >>> 32);
                this.f = i4 + 1;
                iArr[i4] = (int) j;
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = (bArr[i4 + 1] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8);
        int[] iArr = this.e;
        int i6 = this.f;
        iArr[i6] = i5;
        int i7 = i6 + 1;
        this.f = i7;
        if (i7 >= 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        SM3Digest sM3Digest = (SM3Digest) memoable;
        super.copyIn(sM3Digest);
        a(sM3Digest);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        int[] iArr = this.d;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.f = 0;
    }

    public SM3Digest(SM3Digest sM3Digest) {
        super(sM3Digest);
        this.d = new int[8];
        this.e = new int[16];
        this.g = new int[68];
        this.h = new int[64];
        a(sM3Digest);
    }
}
