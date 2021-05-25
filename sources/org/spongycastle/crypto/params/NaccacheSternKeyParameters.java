package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class NaccacheSternKeyParameters extends AsymmetricKeyParameter {
    public BigInteger b;
    public BigInteger c;
    public int d;

    public NaccacheSternKeyParameters(boolean z, BigInteger bigInteger, BigInteger bigInteger2, int i) {
        super(z);
        this.b = bigInteger;
        this.c = bigInteger2;
        this.d = i;
    }

    public BigInteger getG() {
        return this.b;
    }

    public int getLowerSigmaBound() {
        return this.d;
    }

    public BigInteger getModulus() {
        return this.c;
    }
}
