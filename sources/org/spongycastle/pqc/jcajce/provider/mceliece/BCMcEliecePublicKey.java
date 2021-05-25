package org.spongycastle.pqc.jcajce.provider.mceliece;

import a2.b.a.a.a;
import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.pqc.asn1.McEliecePublicKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
public class BCMcEliecePublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    public McEliecePublicKeyParameters a;

    public BCMcEliecePublicKey(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this.a = mcEliecePublicKeyParameters;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePublicKey)) {
            return false;
        }
        BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey) obj;
        if (this.a.getN() == bCMcEliecePublicKey.getN() && this.a.getT() == bCMcEliecePublicKey.getT() && this.a.getG().equals(bCMcEliecePublicKey.getG())) {
            return true;
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.mcEliece), new McEliecePublicKey(this.a.getN(), this.a.getT(), this.a.getG())).getEncoded();
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
        Q3.append(this.a.getG());
        return Q3.toString();
    }
}
