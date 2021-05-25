package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
public class DHParameters implements CipherParameters {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;
    public BigInteger d;
    public int e;
    public int f;
    public DHValidationParameters g;

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, null, 0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHParameters)) {
            return false;
        }
        DHParameters dHParameters = (DHParameters) obj;
        if (getQ() != null) {
            if (!getQ().equals(dHParameters.getQ())) {
                return false;
            }
        } else if (dHParameters.getQ() != null) {
            return false;
        }
        if (!dHParameters.getP().equals(this.b) || !dHParameters.getG().equals(this.a)) {
            return false;
        }
        return true;
    }

    public BigInteger getG() {
        return this.a;
    }

    public BigInteger getJ() {
        return this.d;
    }

    public int getL() {
        return this.f;
    }

    public int getM() {
        return this.e;
    }

    public BigInteger getP() {
        return this.b;
    }

    public BigInteger getQ() {
        return this.c;
    }

    public DHValidationParameters getValidationParameters() {
        return this.g;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) ^ (getQ() != null ? getQ().hashCode() : 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DHParameters(java.math.BigInteger r10, java.math.BigInteger r11, java.math.BigInteger r12, int r13) {
        /*
            r9 = this;
            r0 = 160(0xa0, float:2.24E-43)
            if (r13 != 0) goto L_0x0007
            r5 = 160(0xa0, float:2.24E-43)
            goto L_0x000b
        L_0x0007:
            if (r13 >= r0) goto L_0x000a
            r0 = r13
        L_0x000a:
            r5 = r0
        L_0x000b:
            r7 = 0
            r8 = 0
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.params.DHParameters.<init>(java.math.BigInteger, java.math.BigInteger, java.math.BigInteger, int):void");
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2) {
        this(bigInteger, bigInteger2, bigInteger3, i, i2, null, null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0, bigInteger4, dHValidationParameters);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        if (i2 != 0) {
            if (i2 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            } else if (i2 < i) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        this.a = bigInteger2;
        this.b = bigInteger;
        this.c = bigInteger3;
        this.e = i;
        this.f = i2;
        this.d = bigInteger4;
        this.g = dHValidationParameters;
    }
}
