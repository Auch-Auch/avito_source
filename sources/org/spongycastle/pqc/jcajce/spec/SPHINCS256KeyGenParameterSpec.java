package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
public class SPHINCS256KeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final String SHA3_256 = "SHA3-256";
    public static final String SHA512_256 = "SHA512-256";
    public final String a;

    public SPHINCS256KeyGenParameterSpec() {
        this(SHA512_256);
    }

    public String getTreeDigest() {
        return this.a;
    }

    public SPHINCS256KeyGenParameterSpec(String str) {
        this.a = str;
    }
}
