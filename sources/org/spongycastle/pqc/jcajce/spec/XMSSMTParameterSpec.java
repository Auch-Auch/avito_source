package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
public class XMSSMTParameterSpec implements AlgorithmParameterSpec {
    public static final String SHA256 = "SHA256";
    public static final String SHA512 = "SHA512";
    public static final String SHAKE128 = "SHAKE128";
    public static final String SHAKE256 = "SHAKE256";
    public final int a;
    public final int b;
    public final String c;

    public XMSSMTParameterSpec(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public int getHeight() {
        return this.a;
    }

    public int getLayers() {
        return this.b;
    }

    public String getTreeDigest() {
        return this.c;
    }
}
