package org.spongycastle.jce.spec;

import java.math.BigInteger;
public class ElGamalPrivateKeySpec extends ElGamalKeySpec {
    public BigInteger b;

    public ElGamalPrivateKeySpec(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        super(elGamalParameterSpec);
        this.b = bigInteger;
    }

    public BigInteger getX() {
        return this.b;
    }
}
