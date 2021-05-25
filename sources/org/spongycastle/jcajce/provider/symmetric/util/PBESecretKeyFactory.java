package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
public class PBESecretKeyFactory extends BaseSecretKeyFactory implements PBE {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;

    public PBESecretKeyFactory(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, int i, int i2, int i3, int i4) {
        super(str, aSN1ObjectIdentifier);
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
    public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        CipherParameters cipherParameters;
        if (keySpec instanceof PBEKeySpec) {
            PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
            if (pBEKeySpec.getSalt() == null) {
                return new BCPBEKey(this.algName, this.algOid, this.b, this.c, this.d, this.e, pBEKeySpec, null);
            }
            if (this.a) {
                cipherParameters = PBE.Util.makePBEParameters(pBEKeySpec, this.b, this.c, this.d, this.e);
            } else {
                cipherParameters = PBE.Util.makePBEMacParameters(pBEKeySpec, this.b, this.c, this.d);
            }
            return new BCPBEKey(this.algName, this.algOid, this.b, this.c, this.d, this.e, pBEKeySpec, cipherParameters);
        }
        throw new InvalidKeySpecException("Invalid KeySpec");
    }
}
