package org.spongycastle.crypto.digests;

import a2.b.a.a.a;
import com.adjust.sdk.Constants;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;
public class MD5Digest extends GeneralDigest implements EncodableDigest {
    public int d;
    public int e;
    public int f;
    public int g;
    public int[] h;
    public int i;

    public MD5Digest() {
        this.h = new int[16];
        reset();
    }

    public final int a(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    public final int b(int i2, int i3, int i4) {
        return (i2 & i4) | (i3 & (~i4));
    }

    public final int c(int i2, int i3, int i4) {
        return (i2 | (~i4)) ^ i3;
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new MD5Digest(this);
    }

    public final void d(MD5Digest mD5Digest) {
        super.copyIn(mD5Digest);
        this.d = mD5Digest.d;
        this.e = mD5Digest.e;
        this.f = mD5Digest.f;
        this.g = mD5Digest.g;
        int[] iArr = mD5Digest.h;
        System.arraycopy(iArr, 0, this.h, 0, iArr.length);
        this.i = mD5Digest.i;
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        finish();
        f(this.d, bArr, i2);
        f(this.e, bArr, i2 + 4);
        f(this.f, bArr, i2 + 8);
        f(this.g, bArr, i2 + 12);
        reset();
        return 16;
    }

    public final int e(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    public final void f(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 3] = (byte) (i2 >>> 24);
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return Constants.MD5;
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.i * 4) + 36)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.d, bArr, 16);
        Pack.intToBigEndian(this.e, bArr, 20);
        Pack.intToBigEndian(this.f, bArr, 24);
        Pack.intToBigEndian(this.g, bArr, 28);
        Pack.intToBigEndian(this.i, bArr, 32);
        for (int i2 = 0; i2 != this.i; i2++) {
            Pack.intToBigEndian(this.h[i2], bArr, (i2 * 4) + 36);
        }
        return bArr;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int i2 = this.d;
        int i3 = this.e;
        int i4 = this.f;
        int i5 = this.g;
        int U2 = a.U2(i2 + a(i3, i4, i5), this.h[0], -680876936, this, 7, i3);
        int U22 = a.U2(a(U2, i3, i4) + i5, this.h[1], -389564586, this, 12, U2);
        int U23 = a.U2(a(U22, U2, i3) + i4, this.h[2], 606105819, this, 17, U22);
        int U24 = a.U2(a(U23, U22, U2) + i3, this.h[3], -1044525330, this, 22, U23);
        int U25 = a.U2(a(U24, U23, U22) + U2, this.h[4], -176418897, this, 7, U24);
        int U26 = a.U2(a(U25, U24, U23) + U22, this.h[5], 1200080426, this, 12, U25);
        int U27 = a.U2(a(U26, U25, U24) + U23, this.h[6], -1473231341, this, 17, U26);
        int U28 = a.U2(a(U27, U26, U25) + U24, this.h[7], -45705983, this, 22, U27);
        int U29 = a.U2(a(U28, U27, U26) + U25, this.h[8], 1770035416, this, 7, U28);
        int U210 = a.U2(a(U29, U28, U27) + U26, this.h[9], -1958414417, this, 12, U29);
        int U211 = a.U2(a(U210, U29, U28) + U27, this.h[10], -42063, this, 17, U210);
        int U212 = a.U2(a(U211, U210, U29) + U28, this.h[11], -1990404162, this, 22, U211);
        int U213 = a.U2(a(U212, U211, U210) + U29, this.h[12], 1804603682, this, 7, U212);
        int U214 = a.U2(a(U213, U212, U211) + U210, this.h[13], -40341101, this, 12, U213);
        int U215 = a.U2(a(U214, U213, U212) + U211, this.h[14], -1502002290, this, 17, U214);
        int U216 = a.U2(a(U215, U214, U213) + U212, this.h[15], 1236535329, this, 22, U215);
        int U217 = a.U2(b(U216, U215, U214) + U213, this.h[1], -165796510, this, 5, U216);
        int U218 = a.U2(b(U217, U216, U215) + U214, this.h[6], -1069501632, this, 9, U217);
        int U219 = a.U2(b(U218, U217, U216) + U215, this.h[11], 643717713, this, 14, U218);
        int U220 = a.U2(b(U219, U218, U217) + U216, this.h[0], -373897302, this, 20, U219);
        int U221 = a.U2(b(U220, U219, U218) + U217, this.h[5], -701558691, this, 5, U220);
        int U222 = a.U2(b(U221, U220, U219) + U218, this.h[10], 38016083, this, 9, U221);
        int U223 = a.U2(b(U222, U221, U220) + U219, this.h[15], -660478335, this, 14, U222);
        int U224 = a.U2(b(U223, U222, U221) + U220, this.h[4], -405537848, this, 20, U223);
        int U225 = a.U2(b(U224, U223, U222) + U221, this.h[9], 568446438, this, 5, U224);
        int U226 = a.U2(b(U225, U224, U223) + U222, this.h[14], -1019803690, this, 9, U225);
        int U227 = a.U2(b(U226, U225, U224) + U223, this.h[3], -187363961, this, 14, U226);
        int U228 = a.U2(b(U227, U226, U225) + U224, this.h[8], 1163531501, this, 20, U227);
        int U229 = a.U2(b(U228, U227, U226) + U225, this.h[13], -1444681467, this, 5, U228);
        int U230 = a.U2(b(U229, U228, U227) + U226, this.h[2], -51403784, this, 9, U229);
        int U231 = a.U2(b(U230, U229, U228) + U227, this.h[7], 1735328473, this, 14, U230);
        int U232 = a.U2(b(U231, U230, U229) + U228, this.h[12], -1926607734, this, 20, U231);
        int U233 = a.U2(((U232 ^ U231) ^ U230) + U229, this.h[5], -378558, this, 4, U232);
        int U234 = a.U2(((U233 ^ U232) ^ U231) + U230, this.h[8], -2022574463, this, 11, U233);
        int U235 = a.U2(((U234 ^ U233) ^ U232) + U231, this.h[11], 1839030562, this, 16, U234);
        int U236 = a.U2(((U235 ^ U234) ^ U233) + U232, this.h[14], -35309556, this, 23, U235);
        int U237 = a.U2(((U236 ^ U235) ^ U234) + U233, this.h[1], -1530992060, this, 4, U236);
        int U238 = a.U2(((U237 ^ U236) ^ U235) + U234, this.h[4], 1272893353, this, 11, U237);
        int U239 = a.U2(((U238 ^ U237) ^ U236) + U235, this.h[7], -155497632, this, 16, U238);
        int U240 = a.U2(U236 + ((U239 ^ U238) ^ U237), this.h[10], -1094730640, this, 23, U239);
        int U241 = a.U2(((U240 ^ U239) ^ U238) + U237, this.h[13], 681279174, this, 4, U240);
        int U242 = a.U2(((U241 ^ U240) ^ U239) + U238, this.h[0], -358537222, this, 11, U241);
        int U243 = a.U2(((U242 ^ U241) ^ U240) + U239, this.h[3], -722521979, this, 16, U242);
        int U244 = a.U2(((U243 ^ U242) ^ U241) + U240, this.h[6], 76029189, this, 23, U243);
        int U245 = a.U2(((U244 ^ U243) ^ U242) + U241, this.h[9], -640364487, this, 4, U244);
        int U246 = a.U2(((U245 ^ U244) ^ U243) + U242, this.h[12], -421815835, this, 11, U245);
        int U247 = a.U2(((U246 ^ U245) ^ U244) + U243, this.h[15], 530742520, this, 16, U246);
        int U248 = a.U2(((U247 ^ U246) ^ U245) + U244, this.h[2], -995338651, this, 23, U247);
        int U249 = a.U2(c(U248, U247, U246) + U245, this.h[0], -198630844, this, 6, U248);
        int U250 = a.U2(c(U249, U248, U247) + U246, this.h[7], 1126891415, this, 10, U249);
        int U251 = a.U2(c(U250, U249, U248) + U247, this.h[14], -1416354905, this, 15, U250);
        int U252 = a.U2(c(U251, U250, U249) + U248, this.h[5], -57434055, this, 21, U251);
        int U253 = a.U2(c(U252, U251, U250) + U249, this.h[12], 1700485571, this, 6, U252);
        int U254 = a.U2(c(U253, U252, U251) + U250, this.h[3], -1894986606, this, 10, U253);
        int U255 = a.U2(c(U254, U253, U252) + U251, this.h[10], -1051523, this, 15, U254);
        int U256 = a.U2(c(U255, U254, U253) + U252, this.h[1], -2054922799, this, 21, U255);
        int U257 = a.U2(c(U256, U255, U254) + U253, this.h[8], 1873313359, this, 6, U256);
        int U258 = a.U2(c(U257, U256, U255) + U254, this.h[15], -30611744, this, 10, U257);
        int U259 = a.U2(c(U258, U257, U256) + U255, this.h[6], -1560198380, this, 15, U258);
        int U260 = a.U2(c(U259, U258, U257) + U256, this.h[13], 1309151649, this, 21, U259);
        int U261 = a.U2(c(U260, U259, U258) + U257, this.h[4], -145523070, this, 6, U260);
        int U262 = a.U2(c(U261, U260, U259) + U258, this.h[11], -1120210379, this, 10, U261);
        int U263 = a.U2(c(U262, U261, U260) + U259, this.h[2], 718787259, this, 15, U262);
        int U264 = a.U2(c(U263, U262, U261) + U260, this.h[9], -343485551, this, 21, U263);
        this.d += U261;
        this.e += U264;
        this.f += U263;
        this.g += U262;
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

    public MD5Digest(byte[] bArr) {
        super(bArr);
        this.h = new int[16];
        this.d = Pack.bigEndianToInt(bArr, 16);
        this.e = Pack.bigEndianToInt(bArr, 20);
        this.f = Pack.bigEndianToInt(bArr, 24);
        this.g = Pack.bigEndianToInt(bArr, 28);
        this.i = Pack.bigEndianToInt(bArr, 32);
        for (int i2 = 0; i2 != this.i; i2++) {
            this.h[i2] = Pack.bigEndianToInt(bArr, (i2 * 4) + 36);
        }
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        d((MD5Digest) memoable);
    }

    public MD5Digest(MD5Digest mD5Digest) {
        super(mD5Digest);
        this.h = new int[16];
        d(mD5Digest);
    }
}
