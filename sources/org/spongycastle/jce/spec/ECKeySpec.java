package org.spongycastle.jce.spec;

import java.security.spec.KeySpec;
public class ECKeySpec implements KeySpec {
    public ECParameterSpec a;

    public ECKeySpec(ECParameterSpec eCParameterSpec) {
        this.a = eCParameterSpec;
    }

    public ECParameterSpec getParams() {
        return this.a;
    }
}
