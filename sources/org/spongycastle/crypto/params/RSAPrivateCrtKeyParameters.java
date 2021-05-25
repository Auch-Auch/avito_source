package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {
    public BigInteger e;
    public BigInteger f;
    public BigInteger g;
    public BigInteger i;
    public BigInteger j;
    public BigInteger k;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.e = bigInteger2;
        this.f = bigInteger4;
        this.g = bigInteger5;
        this.i = bigInteger6;
        this.j = bigInteger7;
        this.k = bigInteger8;
    }

    public BigInteger getDP() {
        return this.i;
    }

    public BigInteger getDQ() {
        return this.j;
    }

    public BigInteger getP() {
        return this.f;
    }

    public BigInteger getPublicExponent() {
        return this.e;
    }

    public BigInteger getQ() {
        return this.g;
    }

    public BigInteger getQInv() {
        return this.k;
    }
}
