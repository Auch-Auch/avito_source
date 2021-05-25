package org.spongycastle.jce.spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.spongycastle.jce.interfaces.IESKey;
public class IEKeySpec implements KeySpec, IESKey {
    public PublicKey a;
    public PrivateKey b;

    public IEKeySpec(PrivateKey privateKey, PublicKey publicKey) {
        this.b = privateKey;
        this.a = publicKey;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "IES";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    @Override // org.spongycastle.jce.interfaces.IESKey
    public PrivateKey getPrivate() {
        return this.b;
    }

    @Override // org.spongycastle.jce.interfaces.IESKey
    public PublicKey getPublic() {
        return this.a;
    }
}
