package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.crypto.Digest;
import x6.e.f.a.d.c;
public final class XMSSMTParameters {
    public final XMSSParameters a;
    public final int b;
    public final int c;

    public XMSSMTParameters(int i, int i2, Digest digest) {
        this.b = i;
        this.c = i2;
        if (i < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        } else if (i % i2 == 0) {
            int i3 = i / i2;
            if (i3 != 1) {
                this.a = new XMSSParameters(i3, digest);
                DefaultXMSSMTOid.lookup(getDigest().getAlgorithmName(), getDigestSize(), getWinternitzParameter(), getLen(), getHeight(), i2);
                return;
            }
            throw new IllegalArgumentException("height / layers must be greater than 1");
        } else {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
    }

    public Digest getDigest() {
        return this.a.getDigest();
    }

    public int getDigestSize() {
        return this.a.getDigestSize();
    }

    public int getHeight() {
        return this.b;
    }

    public int getLayers() {
        return this.c;
    }

    public int getLen() {
        return this.a.a.a.e;
    }

    public c getWOTSPlus() {
        return this.a.a;
    }

    public int getWinternitzParameter() {
        return this.a.getWinternitzParameter();
    }

    public XMSSParameters getXMSSParameters() {
        return this.a;
    }
}
