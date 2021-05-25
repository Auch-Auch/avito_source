package org.spongycastle.crypto;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
public class AsymmetricCipherKeyPair {
    public AsymmetricKeyParameter a;
    public AsymmetricKeyParameter b;

    public AsymmetricCipherKeyPair(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricKeyParameter asymmetricKeyParameter2) {
        this.a = asymmetricKeyParameter;
        this.b = asymmetricKeyParameter2;
    }

    public AsymmetricKeyParameter getPrivate() {
        return this.b;
    }

    public AsymmetricKeyParameter getPublic() {
        return this.a;
    }

    public AsymmetricCipherKeyPair(CipherParameters cipherParameters, CipherParameters cipherParameters2) {
        this.a = (AsymmetricKeyParameter) cipherParameters;
        this.b = (AsymmetricKeyParameter) cipherParameters2;
    }
}
