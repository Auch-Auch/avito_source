package org.spongycastle.jcajce.spec;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.util.Arrays;
public class MQVParameterSpec implements AlgorithmParameterSpec {
    public final PublicKey a;
    public final PrivateKey b;
    public final PublicKey c;
    public final byte[] d;

    public MQVParameterSpec(PublicKey publicKey, PrivateKey privateKey, PublicKey publicKey2, byte[] bArr) {
        this.a = publicKey;
        this.b = privateKey;
        this.c = publicKey2;
        this.d = Arrays.clone(bArr);
    }

    public PrivateKey getEphemeralPrivateKey() {
        return this.b;
    }

    public PublicKey getEphemeralPublicKey() {
        return this.a;
    }

    public PublicKey getOtherPartyEphemeralKey() {
        return this.c;
    }

    public byte[] getUserKeyingMaterial() {
        return Arrays.clone(this.d);
    }

    public MQVParameterSpec(PublicKey publicKey, PrivateKey privateKey, PublicKey publicKey2) {
        this(publicKey, privateKey, publicKey2, null);
    }

    public MQVParameterSpec(KeyPair keyPair, PublicKey publicKey, byte[] bArr) {
        this(keyPair.getPublic(), keyPair.getPrivate(), publicKey, bArr);
    }

    public MQVParameterSpec(PrivateKey privateKey, PublicKey publicKey, byte[] bArr) {
        this(null, privateKey, publicKey, bArr);
    }

    public MQVParameterSpec(KeyPair keyPair, PublicKey publicKey) {
        this(keyPair.getPublic(), keyPair.getPrivate(), publicKey, null);
    }

    public MQVParameterSpec(PrivateKey privateKey, PublicKey publicKey) {
        this(null, privateKey, publicKey, null);
    }
}
