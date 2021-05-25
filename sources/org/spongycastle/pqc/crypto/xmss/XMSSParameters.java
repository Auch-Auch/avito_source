package org.spongycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.spongycastle.crypto.Digest;
import x6.e.f.a.d.c;
import x6.e.f.a.d.e;
public final class XMSSParameters {
    public final c a;
    public final int b;
    public final int c;

    public XMSSParameters(int i, Digest digest) {
        if (i >= 2) {
            Objects.requireNonNull(digest, "digest == null");
            this.a = new c(new e(digest));
            this.b = i;
            int i2 = 2;
            while (true) {
                int i3 = this.b;
                if (i2 > i3) {
                    throw new IllegalStateException("should never happen...");
                } else if ((i3 - i2) % 2 == 0) {
                    this.c = i2;
                    DefaultXMSSOid.lookup(getDigest().getAlgorithmName(), getDigestSize(), getWinternitzParameter(), this.a.a.e, i);
                    return;
                } else {
                    i2++;
                }
            }
        } else {
            throw new IllegalArgumentException("height must be >= 2");
        }
    }

    public Digest getDigest() {
        return this.a.a.b;
    }

    public int getDigestSize() {
        return this.a.a.c;
    }

    public int getHeight() {
        return this.b;
    }

    public int getWinternitzParameter() {
        return this.a.a.d;
    }
}
