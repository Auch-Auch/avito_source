package org.spongycastle.jcajce.spec;

import javax.crypto.SecretKey;
public class RepeatedSecretKeySpec implements SecretKey {
    public String a;

    public RepeatedSecretKeySpec(String str) {
        this.a = str;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.a;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }
}
