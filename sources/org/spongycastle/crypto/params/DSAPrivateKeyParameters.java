package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class DSAPrivateKeyParameters extends DSAKeyParameters {
    public BigInteger c;

    public DSAPrivateKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(true, dSAParameters);
        this.c = bigInteger;
    }

    public BigInteger getX() {
        return this.c;
    }
}
