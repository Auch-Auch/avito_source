package org.spongycastle.pqc.jcajce.provider.mceliece;

import a2.b.a.a.a;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
public class McElieceCCA2KeysToParams {
    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCMcElieceCCA2PrivateKey) {
            return ((BCMcElieceCCA2PrivateKey) privateKey).a;
        }
        throw new InvalidKeyException("can't identify McElieceCCA2 private key.");
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCMcElieceCCA2PublicKey) {
            return ((BCMcElieceCCA2PublicKey) publicKey).a;
        }
        StringBuilder L = a.L("can't identify McElieceCCA2 public key: ");
        L.append(publicKey.getClass().getName());
        throw new InvalidKeyException(L.toString());
    }
}
