package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
public class NonMemoableDigest implements ExtendedDigest {
    public ExtendedDigest a;

    public NonMemoableDigest(ExtendedDigest extendedDigest) {
        if (extendedDigest != null) {
            this.a = extendedDigest;
            return;
        }
        throw new IllegalArgumentException("baseDigest must not be null");
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        return this.a.doFinal(bArr, i);
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return this.a.getAlgorithmName();
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.a.getByteLength();
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return this.a.getDigestSize();
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.a.reset();
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b) {
        this.a.update(b);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }
}
