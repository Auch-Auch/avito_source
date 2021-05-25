package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class GOST3410PublicKeyParameters extends GOST3410KeyParameters {
    public BigInteger c;

    public GOST3410PublicKeyParameters(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        super(false, gOST3410Parameters);
        this.c = bigInteger;
    }

    public BigInteger getY() {
        return this.c;
    }
}
