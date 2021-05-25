package org.spongycastle.pqc.jcajce.provider.mceliece;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
public class BCMcElieceCCA2PublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    public McElieceCCA2PublicKeyParameters a;

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this.a = mcElieceCCA2PublicKeyParameters;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PublicKey)) {
            return false;
        }
        BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey = (BCMcElieceCCA2PublicKey) obj;
        if (this.a.getN() == bCMcElieceCCA2PublicKey.getN() && this.a.getT() == bCMcElieceCCA2PublicKey.getT() && this.a.getG().equals(bCMcElieceCCA2PublicKey.getG())) {
            return true;
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcElieceCca2), new McElieceCCA2PublicKey(this.a.getN(), this.a.getT(), this.a.getG(), AppCompatDelegateImpl.i.u0(this.a.getDigest()))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public GF2Matrix getG() {
        return this.a.getG();
    }

    public int getK() {
        return this.a.getK();
    }

    public int getN() {
        return this.a.getN();
    }

    public int getT() {
        return this.a.getT();
    }

    @Override // java.lang.Object
    public int hashCode() {
        int n = this.a.getN();
        return this.a.getG().hashCode() + (((this.a.getT() * 37) + n) * 37);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder Q = a.Q("McEliecePublicKey:\n", " length of the code         : ");
        Q.append(this.a.getN());
        Q.append("\n");
        StringBuilder Q2 = a.Q(Q.toString(), " error correction capability: ");
        Q2.append(this.a.getT());
        Q2.append("\n");
        StringBuilder Q3 = a.Q(Q2.toString(), " generator matrix           : ");
        Q3.append(this.a.getG().toString());
        return Q3.toString();
    }
}
