package org.spongycastle.jce.spec;

import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.spongycastle.jce.interfaces.MQVPublicKey;
public class MQVPublicKeySpec implements KeySpec, MQVPublicKey {
    public PublicKey a;
    public PublicKey b;

    public MQVPublicKeySpec(PublicKey publicKey, PublicKey publicKey2) {
        this.a = publicKey;
        this.b = publicKey2;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ECMQV";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return null;
    }

    @Override // org.spongycastle.jce.interfaces.MQVPublicKey
    public PublicKey getEphemeralKey() {
        return this.b;
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    @Override // org.spongycastle.jce.interfaces.MQVPublicKey
    public PublicKey getStaticKey() {
        return this.a;
    }
}
