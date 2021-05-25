package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;
public class GOST3410PrivateKeySpec implements KeySpec {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;
    public BigInteger d;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.a = bigInteger;
        this.b = bigInteger2;
        this.c = bigInteger3;
        this.d = bigInteger4;
    }

    public BigInteger getA() {
        return this.d;
    }

    public BigInteger getP() {
        return this.b;
    }

    public BigInteger getQ() {
        return this.c;
    }

    public BigInteger getX() {
        return this.a;
    }
}
