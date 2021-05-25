package org.spongycastle.pqc.jcajce.provider.gmss;

import a2.b.a.a.a;
import java.security.PublicKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.GMSSPublicKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.ParSet;
import org.spongycastle.pqc.crypto.gmss.GMSSParameters;
import org.spongycastle.pqc.crypto.gmss.GMSSPublicKeyParameters;
import org.spongycastle.pqc.jcajce.provider.util.KeyUtil;
import org.spongycastle.util.encoders.Hex;
public class BCGMSSPublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    public byte[] a;
    public GMSSParameters b;

    public BCGMSSPublicKey(byte[] bArr, GMSSParameters gMSSParameters) {
        this.b = gMSSParameters;
        this.a = bArr;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "GMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.gmss, new ParSet(this.b.getNumOfLayers(), this.b.getHeightOfTrees(), this.b.getWinternitzParameter(), this.b.getK()).toASN1Primitive()), new GMSSPublicKey(this.a));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public GMSSParameters getParameterSet() {
        return this.b;
    }

    public byte[] getPublicKeyBytes() {
        return this.a;
    }

    @Override // java.lang.Object
    public String toString() {
        String t = a.t(a.L("GMSS public key : "), new String(Hex.encode(this.a)), "\nHeight of Trees: \n");
        for (int i = 0; i < this.b.getHeightOfTrees().length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(t);
            sb.append("Layer ");
            sb.append(i);
            sb.append(" : ");
            sb.append(this.b.getHeightOfTrees()[i]);
            sb.append(" WinternitzParameter: ");
            sb.append(this.b.getWinternitzParameter()[i]);
            sb.append(" K: ");
            t = a.j(sb, this.b.getK()[i], "\n");
        }
        return t;
    }

    public BCGMSSPublicKey(GMSSPublicKeyParameters gMSSPublicKeyParameters) {
        this(gMSSPublicKeyParameters.getPublicKey(), gMSSPublicKeyParameters.getParameters());
    }
}
