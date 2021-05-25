package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
public class GOST3411_2012_512Digest extends GOST3411_2012Digest {
    public static final byte[] m = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public GOST3411_2012_512Digest() {
        super(m);
    }

    @Override // org.spongycastle.crypto.digests.GOST3411_2012Digest, org.spongycastle.util.Memoable
    public Memoable copy() {
        return new GOST3411_2012_512Digest(this);
    }

    @Override // org.spongycastle.crypto.digests.GOST3411_2012Digest, org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "GOST3411-2012-512";
    }

    @Override // org.spongycastle.crypto.digests.GOST3411_2012Digest, org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 64;
    }

    public GOST3411_2012_512Digest(GOST3411_2012_512Digest gOST3411_2012_512Digest) {
        super(m);
        reset(gOST3411_2012_512Digest);
    }
}
