package org.spongycastle.crypto.params;

import java.math.BigInteger;
import java.util.Objects;
public class DHPublicKeyParameters extends DHKeyParameters {
    public static final BigInteger d = BigInteger.valueOf(1);
    public static final BigInteger e = BigInteger.valueOf(2);
    public BigInteger c;

    public DHPublicKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(false, dHParameters);
        Objects.requireNonNull(bigInteger, "y value cannot be null");
        BigInteger bigInteger2 = e;
        if (bigInteger.compareTo(bigInteger2) < 0 || bigInteger.compareTo(dHParameters.getP().subtract(bigInteger2)) > 0) {
            throw new IllegalArgumentException("invalid DH public key");
        } else if (dHParameters.getQ() == null || d.equals(bigInteger.modPow(dHParameters.getQ(), dHParameters.getP()))) {
            this.c = bigInteger;
        } else {
            throw new IllegalArgumentException("Y value does not appear to be in correct group");
        }
    }

    @Override // org.spongycastle.crypto.params.DHKeyParameters
    public boolean equals(Object obj) {
        if ((obj instanceof DHPublicKeyParameters) && ((DHPublicKeyParameters) obj).getY().equals(this.c) && super.equals(obj)) {
            return true;
        }
        return false;
    }

    public BigInteger getY() {
        return this.c;
    }

    @Override // org.spongycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        return this.c.hashCode() ^ super.hashCode();
    }
}
