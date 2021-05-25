package org.spongycastle.crypto.digests;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;
public class SHA1Digest extends GeneralDigest implements EncodableDigest {
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int[] i;
    public int j;

    public SHA1Digest() {
        this.i = new int[80];
        reset();
    }

    public final void a(SHA1Digest sHA1Digest) {
        this.d = sHA1Digest.d;
        this.e = sHA1Digest.e;
        this.f = sHA1Digest.f;
        this.g = sHA1Digest.g;
        this.h = sHA1Digest.h;
        int[] iArr = sHA1Digest.i;
        System.arraycopy(iArr, 0, this.i, 0, iArr.length);
        this.j = sHA1Digest.j;
    }

    public final int b(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    public final int c(int i2, int i3, int i4) {
        return (i2 & i4) | (i2 & i3) | (i3 & i4);
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SHA1Digest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        finish();
        Pack.intToBigEndian(this.d, bArr, i2);
        Pack.intToBigEndian(this.e, bArr, i2 + 4);
        Pack.intToBigEndian(this.f, bArr, i2 + 8);
        Pack.intToBigEndian(this.g, bArr, i2 + 12);
        Pack.intToBigEndian(this.h, bArr, i2 + 16);
        reset();
        return 20;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.spongycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.j * 4) + 40)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.d, bArr, 16);
        Pack.intToBigEndian(this.e, bArr, 20);
        Pack.intToBigEndian(this.f, bArr, 24);
        Pack.intToBigEndian(this.g, bArr, 28);
        Pack.intToBigEndian(this.h, bArr, 32);
        Pack.intToBigEndian(this.j, bArr, 36);
        for (int i2 = 0; i2 != this.j; i2++) {
            Pack.intToBigEndian(this.i[i2], bArr, (i2 * 4) + 40);
        }
        return bArr;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        for (int i2 = 16; i2 < 80; i2++) {
            int[] iArr = this.i;
            int i3 = ((iArr[i2 - 3] ^ iArr[i2 - 8]) ^ iArr[i2 - 14]) ^ iArr[i2 - 16];
            iArr[i2] = (i3 >>> 31) | (i3 << 1);
        }
        int i4 = this.d;
        int i5 = this.e;
        int i6 = this.f;
        int i7 = this.g;
        int i8 = this.h;
        int i9 = 0;
        int i10 = 0;
        while (i9 < 4) {
            int i11 = i10 + 1;
            int G1 = a.G1(b(i5, i6, i7) + ((i4 << 5) | (i4 >>> 27)), this.i[i10], 1518500249, i8);
            int i12 = (i5 >>> 2) | (i5 << 30);
            int i13 = i11 + 1;
            int G12 = a.G1(b(i4, i12, i6) + ((G1 << 5) | (G1 >>> 27)), this.i[i11], 1518500249, i7);
            int i14 = (i4 >>> 2) | (i4 << 30);
            int i15 = i13 + 1;
            int G13 = a.G1(b(G1, i14, i12) + ((G12 << 5) | (G12 >>> 27)), this.i[i13], 1518500249, i6);
            i8 = (G1 >>> 2) | (G1 << 30);
            int i16 = i15 + 1;
            i5 = a.G1(b(G12, i8, i14) + ((G13 << 5) | (G13 >>> 27)), this.i[i15], 1518500249, i12);
            i7 = (G12 >>> 2) | (G12 << 30);
            i4 = a.G1(b(G13, i7, i8) + ((i5 << 5) | (i5 >>> 27)), this.i[i16], 1518500249, i14);
            i6 = (G13 >>> 2) | (G13 << 30);
            i9++;
            i10 = i16 + 1;
        }
        int i17 = 0;
        while (i17 < 4) {
            int[] iArr2 = this.i;
            int i18 = i10 + 1;
            int G14 = a.G1(((i4 << 5) | (i4 >>> 27)) + ((i5 ^ i6) ^ i7), iArr2[i10], 1859775393, i8);
            int i19 = (i5 >>> 2) | (i5 << 30);
            int i20 = i18 + 1;
            int G15 = a.G1(((G14 << 5) | (G14 >>> 27)) + ((i4 ^ i19) ^ i6), iArr2[i18], 1859775393, i7);
            int i21 = (i4 >>> 2) | (i4 << 30);
            int i22 = i20 + 1;
            int G16 = a.G1(((G15 << 5) | (G15 >>> 27)) + ((G14 ^ i21) ^ i19), iArr2[i20], 1859775393, i6);
            i8 = (G14 >>> 2) | (G14 << 30);
            int i23 = i22 + 1;
            i5 = a.G1(((G16 << 5) | (G16 >>> 27)) + ((G15 ^ i8) ^ i21), iArr2[i22], 1859775393, i19);
            i7 = (G15 >>> 2) | (G15 << 30);
            i4 = a.G1(((i5 << 5) | (i5 >>> 27)) + ((G16 ^ i7) ^ i8), iArr2[i23], 1859775393, i21);
            i6 = (G16 >>> 2) | (G16 << 30);
            i17++;
            i10 = i23 + 1;
        }
        int i24 = 0;
        while (i24 < 4) {
            int i25 = i10 + 1;
            int G17 = a.G1(c(i5, i6, i7) + ((i4 << 5) | (i4 >>> 27)), this.i[i10], -1894007588, i8);
            int i26 = (i5 >>> 2) | (i5 << 30);
            int i27 = i25 + 1;
            int G18 = a.G1(c(i4, i26, i6) + ((G17 << 5) | (G17 >>> 27)), this.i[i25], -1894007588, i7);
            int i28 = (i4 >>> 2) | (i4 << 30);
            int i29 = i27 + 1;
            int G19 = a.G1(c(G17, i28, i26) + ((G18 << 5) | (G18 >>> 27)), this.i[i27], -1894007588, i6);
            i8 = (G17 >>> 2) | (G17 << 30);
            int i30 = i29 + 1;
            i5 = a.G1(c(G18, i8, i28) + ((G19 << 5) | (G19 >>> 27)), this.i[i29], -1894007588, i26);
            i7 = (G18 >>> 2) | (G18 << 30);
            i4 = a.G1(c(G19, i7, i8) + ((i5 << 5) | (i5 >>> 27)), this.i[i30], -1894007588, i28);
            i6 = (G19 >>> 2) | (G19 << 30);
            i24++;
            i10 = i30 + 1;
        }
        int i31 = 0;
        while (i31 <= 3) {
            int[] iArr3 = this.i;
            int i32 = i10 + 1;
            int G110 = a.G1(((i4 << 5) | (i4 >>> 27)) + ((i5 ^ i6) ^ i7), iArr3[i10], -899497514, i8);
            int i33 = (i5 >>> 2) | (i5 << 30);
            int i34 = i32 + 1;
            int G111 = a.G1(((G110 << 5) | (G110 >>> 27)) + ((i4 ^ i33) ^ i6), iArr3[i32], -899497514, i7);
            int i35 = (i4 >>> 2) | (i4 << 30);
            int i36 = i34 + 1;
            int G112 = a.G1(((G111 << 5) | (G111 >>> 27)) + ((G110 ^ i35) ^ i33), iArr3[i34], -899497514, i6);
            i8 = (G110 >>> 2) | (G110 << 30);
            int i37 = i36 + 1;
            i5 = a.G1(((G112 << 5) | (G112 >>> 27)) + ((G111 ^ i8) ^ i35), iArr3[i36], -899497514, i33);
            i7 = (G111 >>> 2) | (G111 << 30);
            i4 = a.G1(((i5 << 5) | (i5 >>> 27)) + ((G112 ^ i7) ^ i8), iArr3[i37], -899497514, i35);
            i6 = (G112 >>> 2) | (G112 << 30);
            i31++;
            i10 = i37 + 1;
        }
        this.d += i4;
        this.e += i5;
        this.f += i6;
        this.g += i7;
        this.h += i8;
        this.j = 0;
        for (int i38 = 0; i38 < 16; i38++) {
            this.i[i38] = 0;
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j2) {
        if (this.j > 14) {
            processBlock();
        }
        int[] iArr = this.i;
        iArr[14] = (int) (j2 >>> 32);
        iArr[15] = (int) (j2 & -1);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = (bArr[i4 + 1] & 255) | (bArr[i2] << Ascii.CAN) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8);
        int[] iArr = this.i;
        int i6 = this.j;
        iArr[i6] = i5;
        int i7 = i6 + 1;
        this.j = i7;
        if (i7 == 16) {
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
        this.h = -1009589776;
        this.j = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.i;
            if (i2 != iArr.length) {
                iArr[i2] = 0;
                i2++;
            } else {
                return;
            }
        }
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        this.i = new int[80];
        a(sHA1Digest);
    }

    public SHA1Digest(byte[] bArr) {
        super(bArr);
        this.i = new int[80];
        this.d = Pack.bigEndianToInt(bArr, 16);
        this.e = Pack.bigEndianToInt(bArr, 20);
        this.f = Pack.bigEndianToInt(bArr, 24);
        this.g = Pack.bigEndianToInt(bArr, 28);
        this.h = Pack.bigEndianToInt(bArr, 32);
        this.j = Pack.bigEndianToInt(bArr, 36);
        for (int i2 = 0; i2 != this.j; i2++) {
            this.i[i2] = Pack.bigEndianToInt(bArr, (i2 * 4) + 40);
        }
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.copyIn(sHA1Digest);
        a(sHA1Digest);
    }
}
