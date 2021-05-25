package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
public class XMSSParameterSpec implements AlgorithmParameterSpec {
    public static final String SHA256 = "SHA256";
    public static final String SHA512 = "SHA512";
    public static final String SHAKE128 = "SHAKE128";
    public static final String SHAKE256 = "SHAKE256";
    public final int a;
    public final String b;

    public XMSSParameterSpec(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public int getHeight() {
        return this.a;
    }

    public String getTreeDigest() {
        return this.b;
    }
}
