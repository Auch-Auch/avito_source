package org.spongycastle.jce.spec;

import java.math.BigInteger;
public class ElGamalPublicKeySpec extends ElGamalKeySpec {
    public BigInteger b;

    public ElGamalPublicKeySpec(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        super(elGamalParameterSpec);
        this.b = bigInteger;
    }

    public BigInteger getY() {
        return this.b;
    }
}
