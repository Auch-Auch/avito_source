package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;
public class SHA256Digest extends GeneralDigest implements EncodableDigest {
    public static final int[] n = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int[] l;
    public int m;

    public SHA256Digest() {
        this.l = new int[64];
        reset();
    }

    public final int a(int i2, int i3, int i4) {
        return ((~i2) & i4) ^ (i3 & i2);
    }

    public final int b(int i2, int i3, int i4) {
        return ((i2 & i4) ^ (i2 & i3)) ^ (i3 & i4);
    }

    public final int c(int i2) {
        return ((i2 << 10) | (i2 >>> 22)) ^ (((i2 >>> 2) | (i2 << 30)) ^ ((i2 >>> 13) | (i2 << 19)));
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SHA256Digest(this);
    }

    public final int d(int i2) {
        return ((i2 << 7) | (i2 >>> 25)) ^ (((i2 >>> 6) | (i2 << 26)) ^ ((i2 >>> 11) | (i2 << 21)));
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        finish();
        Pack.intToBigEndian(this.d, bArr, i2);
        Pack.intToBigEndian(this.e, bArr, i2 + 4);
        Pack.intToBigEndian(this.f, bArr, i2 + 8);
        Pack.intToBigEndian(this.g, bArr, i2 + 12);
        Pack.intToBigEndian(this.h, bArr, i2 + 16);
        Pack.intToBigEndian(this.i, bArr, i2 + 20);
        Pack.intToBigEndian(this.j, bArr, i2 + 24);
        Pack.intToBigEndian(this.k, bArr, i2 + 28);
        reset();
        return 32;
    }

    public final void e(SHA256Digest sHA256Digest) {
        super.copyIn(sHA256Digest);
        this.d = sHA256Digest.d;
        this.e = sHA256Digest.e;
        this.f = sHA256Digest.f;
        this.g = sHA256Digest.g;
        this.h = sHA256Digest.h;
        this.i = sHA256Digest.i;
        this.j = sHA256Digest.j;
        this.k = sHA256Digest.k;
        int[] iArr = sHA256Digest.l;
        System.arraycopy(iArr, 0, this.l, 0, iArr.length);
        this.m = sHA256Digest.m;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-256";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.spongycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.m * 4) + 52)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.d, bArr, 16);
        Pack.intToBigEndian(this.e, bArr, 20);
        Pack.intToBigEndian(this.f, bArr, 24);
        Pack.intToBigEndian(this.g, bArr, 28);
        Pack.intToBigEndian(this.h, bArr, 32);
        Pack.intToBigEndian(this.i, bArr, 36);
        Pack.intToBigEndian(this.j, bArr, 40);
        Pack.intToBigEndian(this.k, bArr, 44);
        Pack.intToBigEndian(this.m, bArr, 48);
        for (int i2 = 0; i2 != this.m; i2++) {
            Pack.intToBigEndian(this.l[i2], bArr, (i2 * 4) + 52);
        }
        return bArr;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        for (int i2 = 16; i2 <= 63; i2++) {
            int[] iArr = this.l;
            int i3 = iArr[i2 - 2];
            int i4 = ((i3 >>> 10) ^ (((i3 >>> 17) | (i3 << 15)) ^ ((i3 >>> 19) | (i3 << 13)))) + iArr[i2 - 7];
            int i5 = iArr[i2 - 15];
            iArr[i2] = i4 + ((i5 >>> 3) ^ (((i5 >>> 7) | (i5 << 25)) ^ ((i5 >>> 18) | (i5 << 14)))) + iArr[i2 - 16];
        }
        int i6 = this.d;
        int i7 = this.e;
        int i8 = this.f;
        int i9 = this.g;
        int i10 = this.h;
        int i11 = this.i;
        int i12 = this.j;
        int i13 = this.k;
        int i14 = 0;
        int i15 = 0;
        while (i14 < 8) {
            int a = a(i10, i11, i12) + d(i10);
            int[] iArr2 = n;
            int i16 = a + iArr2[i15] + this.l[i15] + i13;
            int i17 = i9 + i16;
            int b = b(i6, i7, i8) + c(i6) + i16;
            int i18 = i15 + 1;
            int a3 = a(i17, i10, i11) + d(i17) + iArr2[i18] + this.l[i18] + i12;
            int i19 = i8 + a3;
            int b2 = b(b, i6, i7) + c(b) + a3;
            int i20 = i18 + 1;
            int a4 = a(i19, i17, i10) + d(i19) + iArr2[i20] + this.l[i20] + i11;
            int i21 = i7 + a4;
            int b3 = b(b2, b, i6) + c(b2) + a4;
            int i22 = i20 + 1;
            int a5 = a(i21, i19, i17) + d(i21) + iArr2[i22] + this.l[i22] + i10;
            int i23 = i6 + a5;
            int b4 = b(b3, b2, b) + c(b3) + a5;
            int i24 = i22 + 1;
            int a6 = a(i23, i21, i19) + d(i23) + iArr2[i24] + this.l[i24] + i17;
            int i25 = b + a6;
            int b5 = b(b4, b3, b2) + c(b4) + a6;
            int i26 = i24 + 1;
            int a8 = a(i25, i23, i21) + d(i25) + iArr2[i26] + this.l[i26] + i19;
            int i27 = b2 + a8;
            int b6 = b(b5, b4, b3) + c(b5) + a8;
            int i28 = i26 + 1;
            int a9 = a(i27, i25, i23) + d(i27) + iArr2[i28] + this.l[i28] + i21;
            int i29 = b3 + a9;
            int b8 = b(b6, b5, b4) + c(b6) + a9;
            int i30 = i28 + 1;
            int a10 = a(i29, i27, i25) + d(i29) + iArr2[i30] + this.l[i30] + i23;
            i15 = i30 + 1;
            i14++;
            i10 = b4 + a10;
            i6 = b(b8, b6, b5) + c(b8) + a10;
            i11 = i29;
            i7 = b8;
            i12 = i27;
            i8 = b6;
            i13 = i25;
            i9 = b5;
        }
        this.d += i6;
        this.e += i7;
        this.f += i8;
        this.g += i9;
        this.h += i10;
        this.i += i11;
        this.j += i12;
        this.k += i13;
        this.m = 0;
        for (int i31 = 0; i31 < 16; i31++) {
            this.l[i31] = 0;
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j2) {
        if (this.m > 14) {
            processBlock();
        }
        int[] iArr = this.l;
        iArr[14] = (int) (j2 >>> 32);
        iArr[15] = (int) (j2 & -1);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = (bArr[i4 + 1] & 255) | (bArr[i2] << Ascii.CAN) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8);
        int[] iArr = this.l;
        int i6 = this.m;
        iArr[i6] = i5;
        int i7 = i6 + 1;
        this.m = i7;
        if (i7 == 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.d = 1779033703;
        this.e = -1150833019;
        this.f = 1013904242;
        this.g = -1521486534;
        this.h = 1359893119;
        this.i = -1694144372;
        this.j = 528734635;
        this.k = 1541459225;
        this.m = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.l;
            if (i2 != iArr.length) {
                iArr[i2] = 0;
                i2++;
            } else {
                return;
            }
        }
    }

    public SHA256Digest(SHA256Digest sHA256Digest) {
        super(sHA256Digest);
        this.l = new int[64];
        e(sHA256Digest);
    }

    public SHA256Digest(byte[] bArr) {
        super(bArr);
        this.l = new int[64];
        this.d = Pack.bigEndianToInt(bArr, 16);
        this.e = Pack.bigEndianToInt(bArr, 20);
        this.f = Pack.bigEndianToInt(bArr, 24);
        this.g = Pack.bigEndianToInt(bArr, 28);
        this.h = Pack.bigEndianToInt(bArr, 32);
        this.i = Pack.bigEndianToInt(bArr, 36);
        this.j = Pack.bigEndianToInt(bArr, 40);
        this.k = Pack.bigEndianToInt(bArr, 44);
        this.m = Pack.bigEndianToInt(bArr, 48);
        for (int i2 = 0; i2 != this.m; i2++) {
            this.l[i2] = Pack.bigEndianToInt(bArr, (i2 * 4) + 52);
        }
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        e((SHA256Digest) memoable);
    }
}
