package org.spongycastle.crypto.digests;

import a2.b.a.a.a;
public class SHA3Digest extends KeccakDigest {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SHA3Digest(int i) {
        super(i);
        if (i == 224 || i == 256 || i == 384 || i == 512) {
            return;
        }
        throw new IllegalArgumentException(a.Q2("'bitLength' ", i, " not supported for SHA-3"));
    }

    @Override // org.spongycastle.crypto.digests.KeccakDigest, org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        absorbBits(2, 2);
        return super.doFinal(bArr, i);
    }

    @Override // org.spongycastle.crypto.digests.KeccakDigest, org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        StringBuilder L = a.L("SHA3-");
        L.append(this.fixedOutputLength);
        return L.toString();
    }

    public SHA3Digest() {
        this(256);
    }

    @Override // org.spongycastle.crypto.digests.KeccakDigest
    public int doFinal(byte[] bArr, int i, byte b, int i2) {
        if (i2 < 0 || i2 > 7) {
            throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
        }
        int i3 = (b & ((1 << i2) - 1)) | (2 << i2);
        int i4 = i2 + 2;
        if (i4 >= 8) {
            absorb(new byte[]{(byte) i3}, 0, 1);
            i4 -= 8;
            i3 >>>= 8;
        }
        return super.doFinal(bArr, i, (byte) i3, i4);
    }

    public SHA3Digest(SHA3Digest sHA3Digest) {
        super(sHA3Digest);
    }
}
