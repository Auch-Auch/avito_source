package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McEliecePrivateKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
public class BCMcEliecePrivateKey implements CipherParameters, PrivateKey {
    private static final long serialVersionUID = 1;
    public McEliecePrivateKeyParameters a;

    public BCMcEliecePrivateKey(McEliecePrivateKeyParameters mcEliecePrivateKeyParameters) {
        this.a = mcEliecePrivateKeyParameters;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePrivateKey)) {
            return false;
        }
        BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) obj;
        if (getN() != bCMcEliecePrivateKey.getN() || getK() != bCMcEliecePrivateKey.getK() || !getField().equals(bCMcEliecePrivateKey.getField()) || !getGoppaPoly().equals(bCMcEliecePrivateKey.getGoppaPoly()) || !getSInv().equals(bCMcEliecePrivateKey.getSInv()) || !getP1().equals(bCMcEliecePrivateKey.getP1()) || !getP2().equals(bCMcEliecePrivateKey.getP2())) {
            return false;
        }
        return true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcEliece), new McEliecePrivateKey(this.a.getN(), this.a.getK(), this.a.getField(), this.a.getGoppaPoly(), this.a.getP1(), this.a.getP2(), this.a.getSInv())).getEncoded();
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

    public Permutation getP1() {
        return this.a.getP1();
    }

    public Permutation getP2() {
        return this.a.getP2();
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.a.getQInv();
    }

    public GF2Matrix getSInv() {
        return this.a.getSInv();
    }

    @Override // java.lang.Object
    public int hashCode() {
        int n = this.a.getN();
        int hashCode = this.a.getField().hashCode();
        int hashCode2 = this.a.getGoppaPoly().hashCode();
        int hashCode3 = this.a.getP1().hashCode();
        int hashCode4 = this.a.getP2().hashCode();
        return this.a.getSInv().hashCode() + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + ((n + (this.a.getK() * 37)) * 37)) * 37)) * 37)) * 37)) * 37);
    }
}
