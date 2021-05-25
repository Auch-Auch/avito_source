package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class SRP6GroupParameters {
    public BigInteger a;
    public BigInteger b;

    public SRP6GroupParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = bigInteger;
        this.b = bigInteger2;
    }

    public BigInteger getG() {
        return this.b;
    }

    public BigInteger getN() {
        return this.a;
    }
}
