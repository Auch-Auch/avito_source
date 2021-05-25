package org.spongycastle.jce.spec;

import java.security.spec.KeySpec;
public class ElGamalKeySpec implements KeySpec {
    public ElGamalParameterSpec a;

    public ElGamalKeySpec(ElGamalParameterSpec elGamalParameterSpec) {
        this.a = elGamalParameterSpec;
    }

    public ElGamalParameterSpec getParams() {
        return this.a;
    }
}
