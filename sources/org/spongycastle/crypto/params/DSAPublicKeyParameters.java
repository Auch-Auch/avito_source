package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class DSAPublicKeyParameters extends DSAKeyParameters {
    public static final BigInteger d = BigInteger.valueOf(1);
    public static final BigInteger e = BigInteger.valueOf(2);
    public BigInteger c;

    public DSAPublicKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(false, dSAParameters);
        if (dSAParameters != null) {
            BigInteger bigInteger2 = e;
            if (bigInteger2.compareTo(bigInteger) > 0 || dSAParameters.getP().subtract(bigInteger2).compareTo(bigInteger) < 0 || !d.equals(bigInteger.modPow(dSAParameters.getQ(), dSAParameters.getP()))) {
                throw new IllegalArgumentException("y value does not appear to be in correct group");
            }
        }
        this.c = bigInteger;
    }

    public BigInteger getY() {
        return this.c;
    }
}
