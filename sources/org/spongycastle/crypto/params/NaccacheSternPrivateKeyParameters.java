package org.spongycastle.crypto.params;

import java.math.BigInteger;
import java.util.Vector;
public class NaccacheSternPrivateKeyParameters extends NaccacheSternKeyParameters {
    public BigInteger e;
    public Vector f;

    public NaccacheSternPrivateKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, int i, Vector vector, BigInteger bigInteger3) {
        super(true, bigInteger, bigInteger2, i);
        this.f = vector;
        this.e = bigInteger3;
    }

    public BigInteger getPhi_n() {
        return this.e;
    }

    public Vector getSmallPrimes() {
        return this.f;
    }
}
