package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.EphemeralKeyPair;
import org.spongycastle.crypto.KeyEncoder;
public class EphemeralKeyPairGenerator {
    public AsymmetricCipherKeyPairGenerator a;
    public KeyEncoder b;

    public EphemeralKeyPairGenerator(AsymmetricCipherKeyPairGenerator asymmetricCipherKeyPairGenerator, KeyEncoder keyEncoder) {
        this.a = asymmetricCipherKeyPairGenerator;
        this.b = keyEncoder;
    }

    public EphemeralKeyPair generate() {
        return new EphemeralKeyPair(this.a.generateKeyPair(), this.b);
    }
}
