package org.spongycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
public class ECNamedCurveGenParameterSpec implements AlgorithmParameterSpec {
    public String a;

    public ECNamedCurveGenParameterSpec(String str) {
        this.a = str;
    }

    public String getName() {
        return this.a;
    }
}
