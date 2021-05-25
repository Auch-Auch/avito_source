package org.spongycastle.pqc.jcajce.provider.mceliece;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
public class BCMcElieceCCA2PrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    public McElieceCCA2PrivateKeyParameters a;

    public BCMcElieceCCA2PrivateKey(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this.a = mcElieceCCA2PrivateKeyParameters;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PrivateKey)) {
            return false;
        }
        BCMcElieceCCA2PrivateKey bCMcElieceCCA2PrivateKey = (BCMcElieceCCA2PrivateKey) obj;
        if (getN() != bCMcElieceCCA2PrivateKey.getN() || getK() != bCMcElieceCCA2PrivateKey.getK() || !getField().equals(bCMcElieceCCA2PrivateKey.getField()) || !getGoppaPoly().equals(bCMcElieceCCA2PrivateKey.getGoppaPoly()) || !getP().equals(bCMcElieceCCA2PrivateKey.getP()) || !getH().equals(bCMcElieceCCA2PrivateKey.getH())) {
            return false;
        }
        return true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcElieceCca2), new McElieceCCA2PrivateKey(getN(), getK(), getField(), getGoppaPoly(), getP(), AppCompatDelegateImpl.i.u0(this.a.getDigest()))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public GF2mField getField() {
        return this.a.getField();
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.a.getGoppaPoly();
    }

    public GF2Matrix getH() {
        return this.a.getH();
    }

    public int getK() {
        return this.a.getK();
    }

    public int getN() {
        return this.a.getN();
    }

    public Permutation getP() {
        return this.a.getP();
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.a.getQInv();
    }

    public int getT() {
        return this.a.getGoppaPoly().getDegree();
    }

    @Override // java.lang.Object
    public int hashCode() {
        int n = this.a.getN();
        int hashCode = this.a.getField().hashCode();
        int hashCode2 = this.a.getGoppaPoly().hashCode();
        int hashCode3 = this.a.getP().hashCode();
        return this.a.getH().hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + ((n + (this.a.getK() * 37)) * 37)) * 37)) * 37)) * 37);
    }
}
