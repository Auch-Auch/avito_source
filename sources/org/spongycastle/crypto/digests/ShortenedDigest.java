package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
public class ShortenedDigest implements ExtendedDigest {
    public ExtendedDigest a;
    public int b;

    public ShortenedDigest(ExtendedDigest extendedDigest, int i) {
        if (extendedDigest == null) {
            throw new IllegalArgumentException("baseDigest must not be null");
        } else if (i <= extendedDigest.getDigestSize()) {
            this.a = extendedDigest;
            this.b = i;
        } else {
            throw new IllegalArgumentException("baseDigest output not large enough to support length");
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        byte[] bArr2 = new byte[this.a.getDigestSize()];
        this.a.doFinal(bArr2, 0);
        System.arraycopy(bArr2, 0, bArr, i, this.b);
        return this.b;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return this.a.getAlgorithmName() + "(" + (this.b * 8) + ")";
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.a.getByteLength();
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return this.b;
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.a.reset();
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b2) {
        this.a.update(b2);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }
}
