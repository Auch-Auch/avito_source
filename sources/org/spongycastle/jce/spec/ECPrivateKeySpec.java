package org.spongycastle.jce.spec;

import java.math.BigInteger;
public class ECPrivateKeySpec extends ECKeySpec {
    public BigInteger b;

    public ECPrivateKeySpec(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.b = bigInteger;
    }

    public BigInteger getD() {
        return this.b;
    }
}
