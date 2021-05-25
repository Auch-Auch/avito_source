package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class GOST3410PrivateKeyParameters extends GOST3410KeyParameters {
    public BigInteger c;

    public GOST3410PrivateKeyParameters(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        super(true, gOST3410Parameters);
        this.c = bigInteger;
    }

    public BigInteger getX() {
        return this.c;
    }
}
