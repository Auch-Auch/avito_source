package org.spongycastle.crypto.digests;

import a2.b.a.a.a;
import org.spongycastle.util.Memoable;
public class MD4Digest extends GeneralDigest {
    public int d;
    public int e;
    public int f;
    public int g;
    public int[] h;
    public int i;

    public MD4Digest() {
        this.h = new int[16];
        reset();
    }

    public final int a(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    public final int b(int i2, int i3, int i4) {
        return (i2 & i4) | (i2 & i3) | (i3 & i4);
    }

    public final void c(MD4Digest mD4Digest) {
        super.copyIn(mD4Digest);
        this.d = mD4Digest.d;
        this.e = mD4Digest.e;
        this.f = mD4Digest.f;
        this.g = mD4Digest.g;
        int[] iArr = mD4Digest.h;
        System.arraycopy(iArr, 0, this.h, 0, iArr.length);
        this.i = mD4Digest.i;
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new MD4Digest(this);
    }

    public final int d(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        finish();
        e(this.d, bArr, i2);
        e(this.e, bArr, i2 + 4);
        e(this.f, bArr, i2 + 8);
        e(this.g, bArr, i2 + 12);
        reset();
        return 16;
    }

    public final void e(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 3] = (byte) (i2 >>> 24);
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "MD4";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int i2 = this.d;
        int i3 = this.e;
        int i4 = this.f;
        int i5 = this.g;
        int d2 = d(a(i3, i4, i5) + i2 + this.h[0], 3);
        int d3 = d(a(d2, i3, i4) + i5 + this.h[1], 7);
        int d4 = d(a(d3, d2, i3) + i4 + this.h[2], 11);
        int d5 = d(a(d4, d3, d2) + i3 + this.h[3], 19);
        int d6 = d(a(d5, d4, d3) + d2 + this.h[4], 3);
        int d7 = d(a(d6, d5, d4) + d3 + this.h[5], 7);
        int d8 = d(a(d7, d6, d5) + d4 + this.h[6], 11);
        int d9 = d(a(d8, d7, d6) + d5 + this.h[7], 19);
        int d10 = d(a(d9, d8, d7) + d6 + this.h[8], 3);
        int d11 = d(a(d10, d9, d8) + d7 + this.h[9], 7);
        int d12 = d(a(d11, d10, d9) + d8 + this.h[10], 11);
        int d13 = d(a(d12, d11, d10) + d9 + this.h[11], 19);
        int d14 = d(a(d13, d12, d11) + d10 + this.h[12], 3);
        int d15 = d(a(d14, d13, d12) + d11 + this.h[13], 7);
        int d16 = d(a(d15, d14, d13) + d12 + this.h[14], 11);
        int d17 = d(a(d16, d15, d14) + d13 + this.h[15], 19);
        int J2 = a.J2(b(d17, d16, d15) + d14, this.h[0], 1518500249, this, 3);
        int J22 = a.J2(b(J2, d17, d16) + d15, this.h[4], 1518500249, this, 5);
        int J23 = a.J2(b(J22, J2, d17) + d16, this.h[8], 1518500249, this, 9);
        int J24 = a.J2(b(J23, J22, J2) + d17, this.h[12], 1518500249, this, 13);
        int J25 = a.J2(b(J24, J23, J22) + J2, this.h[1], 1518500249, this, 3);
        int J26 = a.J2(b(J25, J24, J23) + J22, this.h[5], 1518500249, this, 5);
        int J27 = a.J2(b(J26, J25, J24) + J23, this.h[9], 1518500249, this, 9);
        int J28 = a.J2(b(J27, J26, J25) + J24, this.h[13], 1518500249, this, 13);
        int J29 = a.J2(b(J28, J27, J26) + J25, this.h[2], 1518500249, this, 3);
        int J210 = a.J2(b(J29, J28, J27) + J26, this.h[6], 1518500249, this, 5);
        int J211 = a.J2(b(J210, J29, J28) + J27, this.h[10], 1518500249, this, 9);
        int J212 = a.J2(b(J211, J210, J29) + J28, this.h[14], 1518500249, this, 13);
        int J213 = a.J2(b(J212, J211, J210) + J29, this.h[3], 1518500249, this, 3);
        int J214 = a.J2(b(J213, J212, J211) + J210, this.h[7], 1518500249, this, 5);
        int J215 = a.J2(b(J214, J213, J212) + J211, this.h[11], 1518500249, this, 9);
        int J216 = a.J2(b(J215, J214, J213) + J212, this.h[15], 1518500249, this, 13);
        int J217 = a.J2(J213 + ((J216 ^ J215) ^ J214), this.h[0], 1859775393, this, 3);
        int J218 = a.J2(J214 + ((J217 ^ J216) ^ J215), this.h[8], 1859775393, this, 9);
        int J219 = a.J2(J215 + ((J218 ^ J217) ^ J216), this.h[4], 1859775393, this, 11);
        int J220 = a.J2(J216 + ((J219 ^ J218) ^ J217), this.h[12], 1859775393, this, 15);
        int J221 = a.J2(J217 + ((J220 ^ J219) ^ J218), this.h[2], 1859775393, this, 3);
        int J222 = a.J2(J218 + ((J221 ^ J220) ^ J219), this.h[10], 1859775393, this, 9);
        int J223 = a.J2(J219 + ((J222 ^ J221) ^ J220), this.h[6], 1859775393, this, 11);
        int J224 = a.J2(J220 + ((J223 ^ J222) ^ J221), this.h[14], 1859775393, this, 15);
        int J225 = a.J2(J221 + ((J224 ^ J223) ^ J222), this.h[1], 1859775393, this, 3);
        int J226 = a.J2(J222 + ((J225 ^ J224) ^ J223), this.h[9], 1859775393, this, 9);
        int J227 = a.J2(J223 + ((J226 ^ J225) ^ J224), this.h[5], 1859775393, this, 11);
        int J228 = a.J2(J224 + ((J227 ^ J226) ^ J225), this.h[13], 1859775393, this, 15);
        int J229 = a.J2(J225 + ((J228 ^ J227) ^ J226), this.h[3], 1859775393, this, 3);
        int J230 = a.J2(J226 + ((J229 ^ J228) ^ J227), this.h[11], 1859775393, this, 9);
        int J231 = a.J2(J227 + ((J230 ^ J229) ^ J228), this.h[7], 1859775393, this, 11);
        int J232 = a.J2(J228 + ((J231 ^ J230) ^ J229), this.h[15], 1859775393, this, 15);
        this.d += J229;
        this.e += J232;
        this.f += J231;
        this.g += J230;
        this.i = 0;
        int i6 = 0;
        while (true) {
            int[] iArr = this.h;
            if (i6 != iArr.length) {
                iArr[i6] = 0;
                i6++;
            } else {
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j) {
        if (this.i > 14) {
            processBlock();
        }
        int[] iArr = this.h;
        iArr[14] = (int) (-1 & j);
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i2) {
        int[] iArr = this.h;
        int i3 = this.i;
        int i4 = i3 + 1;
        this.i = i4;
        iArr[i3] = ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        if (i4 == 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.d = 1732584193;
        this.e = -271733879;
        this.f = -1732584194;
        this.g = 271733878;
        this.i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.h;
            if (i2 != iArr.length) {
                iArr[i2] = 0;
                i2++;
            } else {
                return;
            }
        }
    }

    public MD4Digest(MD4Digest mD4Digest) {
        super(mD4Digest);
        this.h = new int[16];
        c(mD4Digest);
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        c((MD4Digest) memoable);
    }
}
