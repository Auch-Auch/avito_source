package org.spongycastle.crypto.digests;

import a2.b.a.a.a;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.util.Memoable;
public class SkeinDigest implements ExtendedDigest, Memoable {
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;
    public SkeinEngine a;

    public SkeinDigest(int i, int i2) {
        this.a = new SkeinEngine(i, i2);
        init(null);
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SkeinDigest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        return this.a.doFinal(bArr, i);
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        StringBuilder L = a.L("Skein-");
        L.append(this.a.getBlockSize() * 8);
        L.append("-");
        L.append(this.a.getOutputSize() * 8);
        return L.toString();
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.a.getBlockSize();
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return this.a.getOutputSize();
    }

    public void init(SkeinParameters skeinParameters) {
        this.a.init(skeinParameters);
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        this.a.reset(((SkeinDigest) memoable).a);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b) {
        this.a.update(b);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.a.reset();
    }

    public SkeinDigest(SkeinDigest skeinDigest) {
        this.a = new SkeinEngine(skeinDigest.a);
    }
}
