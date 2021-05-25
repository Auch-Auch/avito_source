package org.spongycastle.jcajce.provider.symmetric.util;

import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
public class BCPBEKey implements PBEKey {
    public String a;
    public ASN1ObjectIdentifier b;
    public int c;
    public int d;
    public int e;
    public int f;
    public CipherParameters g;
    public PBEKeySpec h;
    public boolean i = false;

    public BCPBEKey(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, int i2, int i3, int i4, int i5, PBEKeySpec pBEKeySpec, CipherParameters cipherParameters) {
        this.a = str;
        this.b = aSN1ObjectIdentifier;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.h = pBEKeySpec;
        this.g = cipherParameters;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.a;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        KeyParameter keyParameter;
        CipherParameters cipherParameters = this.g;
        if (cipherParameters != null) {
            if (cipherParameters instanceof ParametersWithIV) {
                keyParameter = (KeyParameter) ((ParametersWithIV) cipherParameters).getParameters();
            } else {
                keyParameter = (KeyParameter) cipherParameters;
            }
            return keyParameter.getKey();
        }
        int i2 = this.c;
        if (i2 == 2) {
            return PBEParametersGenerator.PKCS12PasswordToBytes(this.h.getPassword());
        }
        if (i2 == 5) {
            return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(this.h.getPassword());
        }
        return PBEParametersGenerator.PKCS5PasswordToBytes(this.h.getPassword());
    }

    @Override // java.security.Key
    public String getFormat() {
        return "RAW";
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        return this.h.getIterationCount();
    }

    public int getIvSize() {
        return this.f;
    }

    public ASN1ObjectIdentifier getOID() {
        return this.b;
    }

    public CipherParameters getParam() {
        return this.g;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public char[] getPassword() {
        return this.h.getPassword();
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        return this.h.getSalt();
    }

    public void setTryWrongPKCS12Zero(boolean z) {
        this.i = z;
    }
}
